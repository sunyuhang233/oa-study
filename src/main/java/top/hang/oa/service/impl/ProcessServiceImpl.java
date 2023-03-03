package top.hang.oa.service.impl;

import top.hang.oa.entity.Employee;
import top.hang.oa.entity.Leave;
import top.hang.oa.entity.ProcessFlow;
import top.hang.oa.mapper.EmployeeMapper;
import top.hang.oa.mapper.LeaveMapper;
import top.hang.oa.mapper.ProcessMapper;
import top.hang.oa.service.ProcessService;
import top.hang.oa.utils.DateUtils;
import top.hang.oa.utils.MybatisUtils;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Ahang
 * @version 1.0
 * @description TODO
 * @date 2023/3/3 10:17
 */
public class ProcessServiceImpl implements ProcessService {
    @Override
    public Leave createLeave(Leave form) {
        return (Leave) MybatisUtils.executeUpdate(sqlSession -> {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.selectById(form.getEmployeeId());
            if (employee.getLevel() == 8) {
                form.setState("approved");
            } else {
                form.setState("processing");
            }

            LeaveMapper leaveMapper = sqlSession.getMapper(LeaveMapper.class);
            leaveMapper.insert(form);

            ProcessMapper processMapper = sqlSession.getMapper(ProcessMapper.class);
            ProcessFlow build = ProcessFlow.builder().formId(form.getFormId())
                    .operatorId(form.getEmployeeId()).
                    action("apply")
                    .createTime(new Date())
                    .orderNo(1).
                    state("complete").
                    isLast(0).build();
            processMapper.insert(build);

            int level = employee.getLevel();
            EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
            switch (level) {
                case 1, 2, 3, 4, 5, 6 -> {
                    Employee leader = employeeService.selectLeader(employee.getEmployeeId());
                    System.out.println(leader);
                    ProcessFlow processFlow = new ProcessFlow();
                    processFlow.setFormId(form.getFormId());
                    processFlow.setOperatorId(leader.getEmployeeId());
                    processFlow.setAction("audit");
                    processFlow.setCreateTime(new Date());
                    processFlow.setOrderNo(2);
                    processFlow.setState("process");

                    long hours= DateUtils.getDiffHours(form.getStartTime(),form.getEndTime());


                    if (hours >= 72) {
                        processFlow.setIsLast(0);
                        processMapper.insert(processFlow);

                        Employee boss = employeeService.selectLeader(leader.getEmployeeId());

                        ProcessFlow flow3 = new ProcessFlow();
                        flow3.setFormId(form.getFormId());
                        flow3.setOperatorId(boss.getEmployeeId());
                        flow3.setAction("audit");
                        flow3.setCreateTime(new Date());
                        flow3.setState("ready");
                        flow3.setOrderNo(3);
                        flow3.setIsLast(1);
                        processMapper.insert(flow3);
                    } else {
                        processFlow.setIsLast(1);
                        processMapper.insert(processFlow);
                    }
                }
                case 7 -> {
                    Employee boss = employeeService.selectLeader(employee.getEmployeeId());
                    ProcessFlow flow2 = new ProcessFlow();
                    flow2.setFormId(form.getFormId());
                    flow2.setOperatorId(boss.getEmployeeId());
                    flow2.setAction("audit");
                    flow2.setCreateTime(new Date());
                    flow2.setState("process");
                    flow2.setOrderNo(2);
                    flow2.setIsLast(1);
                }
                case 8 -> {
                    ProcessFlow flow2 = new ProcessFlow();
                    flow2.setFormId(form.getFormId());
                    flow2.setOperatorId(employee.getEmployeeId());
                    flow2.setAction("audit");
                    flow2.setResult("approved");
                    flow2.setReason("自动通过");
                    flow2.setCreateTime(new Date());
                    flow2.setAuditTime(new Date());
                    flow2.setState("complete");
                    flow2.setOrderNo(2);
                    flow2.setIsLast(1);
                    processMapper.insert(flow2);
                }

                default -> System.out.println("无此等级");

            }
            return form;

        });
    }


}

package top.hang.oa.service.impl;

import top.hang.oa.entity.Employee;
import top.hang.oa.mapper.EmployeeMapper;
import top.hang.oa.service.EmployeeService;
import top.hang.oa.utils.MybatisUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @author Ahang
 * @version 1.0
 * @description TODO
 * @date 2023/2/27 18:42
 */
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public Employee selectById(Long employeeId) {
        return (Employee) MybatisUtils.executeQuery(sqlSession -> {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            return employeeMapper.selectById(employeeId);
        });
    }

    @Override
    public Employee selectLeader(Long employeeId) {
        return (Employee) MybatisUtils.executeUpdate(sqlSession -> {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.selectById(employeeId);
            HashMap<String, Object> map = new HashMap<>();
            Employee leader=null;
            if(employee.getLevel() <7){
                map.put("level",7);
                map.put("departmentId",employee.getDepartmentId());
           List<Employee> employees=mapper.selectByParams(map);
           leader=employees.get(0);
            } else if (employee.getLevel() == 7) {
                map.put("level",8);
                List<Employee> employees= mapper.selectByParams(map);
                leader=employees.get(0);
            } else if (employee.getLevel() == 8) {
                leader=employee;
            }
            return leader;
        });
    }


}

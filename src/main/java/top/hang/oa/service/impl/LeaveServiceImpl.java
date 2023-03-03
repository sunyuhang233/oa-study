package top.hang.oa.service.impl;

import top.hang.oa.entity.Employee;
import top.hang.oa.entity.Leave;
import top.hang.oa.mapper.EmployeeMapper;
import top.hang.oa.mapper.LeaveMapper;
import top.hang.oa.service.LeaveService;
import top.hang.oa.utils.MybatisUtils;

import java.util.List;

/**
 * @author Ahang
 * @version 1.0
 * @description TODO
 * @date 2023/3/3 9:28
 */
public class LeaveServiceImpl implements LeaveService {


//    @Override
//    public Leave insetLeaveInfo(Leave leave) {
//      return (Leave)  MybatisUtils.executeUpdate(sqlSession -> {
//          LeaveMapper mapper = sqlSession.getMapper(LeaveMapper.class);
//          return mapper.insertLeave(leave);
//        });
//    }
}

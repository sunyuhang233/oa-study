package top.hang.oa.service.impl;

import top.hang.oa.entity.Employee;
import top.hang.oa.mapper.EmployeeMapper;
import top.hang.oa.service.EmployeeService;
import top.hang.oa.utils.MybatisUtils;

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
}

package top.flobby.oa.service.impl;

import top.flobby.oa.entity.Employee;
import top.flobby.oa.mapper.EmployeeMapper;
import top.flobby.oa.service.EmployeeService;
import top.flobby.oa.utils.MybatisUtils;

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

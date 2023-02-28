package top.flobby.oa.service;

import top.flobby.oa.entity.Employee;
import top.flobby.oa.mapper.EmployeeMapper;
import top.flobby.oa.utils.MybatisUtils;

/**
 * @author Ahang
 * @version 1.0
 * @description TODO
 * @date 2023/2/27 18:40
 */
public interface EmployeeService {
    public Employee selectById(Long employeeId);
}

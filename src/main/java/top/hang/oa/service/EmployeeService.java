package top.hang.oa.service;

import top.hang.oa.entity.Employee;

import java.util.List;

/**
 * @author Ahang
 * @version 1.0
 * @description TODO
 * @date 2023/2/27 18:40
 */
public interface EmployeeService {
    public Employee selectById(Long employeeId);

    Employee selectLeader(Long employeeId);
}

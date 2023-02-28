package top.flobby.oa.mapper;

import top.flobby.oa.entity.Employee;

/**
 * @author Ahang
 * @version 1.0
 * @description TODO
 * @date 2023/2/27 18:39
 */
public interface EmployeeMapper {
    Employee selectById(Long employeeId);
}

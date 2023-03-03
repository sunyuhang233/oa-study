package top.hang.oa.mapper;

import top.hang.oa.entity.Employee;

import java.util.List;
import java.util.Map;

/**
 * @author Ahang
 * @version 1.0
 * @description TODO
 * @date 2023/2/27 18:39
 */
public interface EmployeeMapper {
    Employee selectById(Long employeeId);

    List<Employee> selectEmployeeList(Long employeeId);

    List<Employee> selectByParams(Map<String,Object> map);
}

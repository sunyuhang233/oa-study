package top.hang.oa.service;

import top.hang.oa.entity.Department;

/**
 * @author Ahang
 * @version 1.0
 * @description TODO
 * @date 2023/2/28 14:30
 */
public interface DepartmentService {
    public Department selectById(Long departmentId);
}

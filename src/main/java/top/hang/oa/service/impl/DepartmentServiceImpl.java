package top.hang.oa.service.impl;

import top.hang.oa.entity.Department;
import top.hang.oa.mapper.DepartmentMapper;
import top.hang.oa.service.DepartmentService;

/**
 * @author Ahang
 * @version 1.0
 * @description TODO
 * @date 2023/2/28 14:30
 */
public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public Department selectById(Long departmentId) {
        DepartmentMapper departmentMapper = new DepartmentMapper();
        return departmentMapper.selectById(departmentId);
    }
}

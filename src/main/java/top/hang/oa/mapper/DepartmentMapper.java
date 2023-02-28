package top.hang.oa.mapper;

import top.hang.oa.entity.Department;
import top.hang.oa.utils.MybatisUtils;

/**
 * @author Ahang
 * @version 1.0
 * @description TODO
 * @date 2023/2/28 14:27
 */
public class DepartmentMapper {
    public Department selectById(Long departmentId) {
        return (Department) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("top.hang.oa.mapper" +
                ".DepartmentMapper.selectById", departmentId));
    }
}

package top.hang.oa.service.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceImplTest {

    @Test
    void selectById() {
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
        System.out.println(departmentService.selectById(1L));
    }
}
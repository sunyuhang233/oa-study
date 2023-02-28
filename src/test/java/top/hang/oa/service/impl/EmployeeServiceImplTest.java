package top.hang.oa.service.impl;

import org.junit.jupiter.api.Test;
import top.hang.oa.entity.Employee;

class EmployeeServiceImplTest {

    @Test
    void selectById() {
        Employee employee = new EmployeeServiceImpl().selectById(3L);
        System.out.println(employee);
    }

}
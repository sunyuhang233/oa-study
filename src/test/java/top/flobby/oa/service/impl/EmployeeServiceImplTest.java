package top.flobby.oa.service.impl;

import org.junit.jupiter.api.Test;
import top.flobby.oa.entity.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    @Test
    void selectById() {
        Employee employee = new EmployeeServiceImpl().selectById(3L);
        System.out.println(employee);
    }

}
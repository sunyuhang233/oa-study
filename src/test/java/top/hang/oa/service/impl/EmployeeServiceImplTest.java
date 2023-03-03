package top.hang.oa.service.impl;

import org.junit.jupiter.api.Test;
import top.hang.oa.entity.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    @Test
    void selectLeader() {
        Employee employee = new EmployeeServiceImpl().selectLeader(3L);
        System.out.println(employee);
    }
}
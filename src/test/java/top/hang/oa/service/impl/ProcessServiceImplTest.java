package top.hang.oa.service.impl;

import com.alibaba.druid.sql.visitor.functions.Lcase;
import org.junit.jupiter.api.Test;
import top.hang.oa.entity.Leave;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ProcessServiceImplTest {

    @Test
    void test() throws ParseException {
        ProcessServiceImpl processService = new ProcessServiceImpl();
        Leave leave = new Leave();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymmddhh");
        leave.setEmployeeId(1L);
        leave.setFormType(1);
        leave.setStartTime(dateFormat.parse("2023030303"));
        leave.setEndTime(dateFormat.parse("2023041008"));
        leave.setReason("123");
        leave.setCreateTime(new Date());
        leave.setState("approved");
        processService.createLeave(leave);
    }

}
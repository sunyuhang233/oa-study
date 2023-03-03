package top.hang.oa.mapper;

import org.junit.jupiter.api.Test;
import top.hang.oa.entity.Leave;
import top.hang.oa.utils.MybatisUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class LeaveMapperTest {

    @Test
    void insert() {
//        MybatisUtils.executeUpdate(sqlSession -> {
//            LeaveMapper mapper = sqlSession.getMapper(LeaveMapper.class);
//            Leave leave = new Leave();
//            leave.setEmployeeId(3L);
//            leave.setFormType(1);
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//            Date startTime=null;
//            Date endTime=null;
//            try {
//                startTime=simpleDateFormat.parse("2022-03-03 08:00:00");
//                endTime=simpleDateFormat.parse("2022-03-04 08:00:00");
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            leave.setStartTime(startTime);
//            leave.setEndTime(endTime);
//            leave.setReason("123");
//            leave.setCreateTime(new Date());
//            leave.setState("processing");
//            mapper.insert(leave);
//            return null;
//        });
    }
}
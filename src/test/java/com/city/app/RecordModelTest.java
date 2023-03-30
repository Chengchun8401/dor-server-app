package com.city.app;

import com.city.app.common.param.UserClockInParam;
import com.city.app.service.IRecordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * @version v1.0
 * @ClassName: RecordModelTest
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@SpringBootTest
public class RecordModelTest {

    @Autowired
    private IRecordService recordService;

    @Test
    public void getRecordInfo(){
        System.out.println(recordService.getUserClockInfo("2020211361"));
    }

    @Test
    public void ClockIn(){
        UserClockInParam param = new UserClockInParam();
        param.setAddress("D/MAP: 中国重庆市南岸区南山街道,29.537334,106.616391,在重庆邮电大学-16栋学生公寓附近");
    }

}

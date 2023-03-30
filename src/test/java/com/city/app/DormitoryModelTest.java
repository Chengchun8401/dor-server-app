package com.city.app;

import com.city.app.common.vo.DormitoryVo;
import com.city.app.common.vo.Result;
import com.city.app.service.IDormitoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @version v1.0
 * @ClassName: com.city.app.DormitoryModelTest
 * @Description: 寝室信息模块测试类
 * @Author: CitySpring
 */
@SpringBootTest
public class DormitoryModelTest {

    @Autowired
    private IDormitoryService dormitoryService;

    private String token = "eyJhbGciOiJIUzI1NiJ9.eyJsb2dpblVzZXJuYW1lIjoiMjAyMDIxMTM2MSIsImV4cCI6MTY4MDE0MjA3MCwiaWF0IjoxNjc5NTM3MjcwfQ.5nnFA9boX9b6U26uXB3gUpX4Ye_E4UWN-utVtIFuYig";

    @Test
    public void getDorInfoByUserId(){
        Result res = dormitoryService.getDorInfoByUserId(token);
        System.out.println(res);
    }

    @Test
    public void getDorWaterInfo(){
        Result res = dormitoryService.getDorWaterInfo(token);
        System.out.println(res);
    }

    @Test
    public void getDorPowerInfo(){
        Result res = dormitoryService.getDorPowerInfo(token);
        System.out.println(res);
    }

    @Test
    public void getDorGradeInfo(){
        Result res = dormitoryService.getDorGradeInfo(token);
        System.out.println(res);
    }


}

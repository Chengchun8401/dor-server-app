package com.city.app;

import com.city.app.utils.FaceAipUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @version v1.0
 * @ClassName: FaceAipTest
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@SpringBootTest
public class FaceAipTest {

    @Autowired
    private FaceAipUtils faceAipUtils;

    @Test
    public void deleteUser(){
        Boolean res = faceAipUtils.faceDelete("2020211362");
        System.out.println(res);
    }

}

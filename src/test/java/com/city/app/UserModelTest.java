package com.city.app;

import com.city.app.dao.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @version v1.0
 * @ClassName: UserModelTest
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@SpringBootTest
public class UserModelTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getUserInfo(){
        System.out.println(userMapper.getUserInfo(Long.parseLong("2020211372")));
    }

}

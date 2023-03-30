package com.city.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @version v1.0
 * @ClassName: DormitoryApplication
 * @Description: 启动类
 * @Author: CitySpring
 */
@MapperScan("com.city.app.dao.mapper")
@SpringBootApplication
public class DormitoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DormitoryApplication.class, args);
    }

}

package com.city.app;

import com.city.app.common.param.PageParam;
import com.city.app.common.vo.Result;
import com.city.app.service.IAnnouncementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @version v1.0
 * @ClassName: AnnouncementModelTest
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@SpringBootTest
public class AnnouncementModelTest {

    @Autowired
    private IAnnouncementService announcementService;

    @Test
    public void getAnnouncementList(){
        PageParam pageParam = new PageParam();
        pageParam.setPage(2);
        pageParam.setPageSize(8);

        Result res = announcementService.getAnnouncementList(pageParam);
        System.out.println(res);;
    }

    @Test
    public void getAnnouncementById(){
        Result res = announcementService.getAnnouncementById("1538329135912020309");
        System.out.println(res);
    }

}

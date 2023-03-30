package com.city.app;

import com.city.app.common.param.PageParam;
import com.city.app.common.vo.Result;
import com.city.app.service.IWorkOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @version v1.0
 * @ClassName: WorkOrderModelTest
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@SpringBootTest
public class WorkOrderModelTest {

    @Autowired
    private IWorkOrderService workOrderService;

    private String token = "eyJhbGciOiJIUzI1NiJ9.eyJsb2dpblVzZXJuYW1lIjoiMjAyMDIxMTM2MSIsImV4cCI6MTY4MDE0MjA3MCwiaWF0IjoxNjc5NTM3MjcwfQ.5nnFA9boX9b6U26uXB3gUpX4Ye_E4UWN-utVtIFuYig";

    @Test
    public void getWorkOrderList(){
        PageParam param = new PageParam();
        param.setPage(1);
        param.setPageSize(10);

        Result res = workOrderService.getWorkOrderList(param, token);
        System.out.println(res);
    }

    @Test
    public void getWorkOrderInfo(){
        Result res = workOrderService.getWorkOrderInfo("1538329135931705361");
        System.out.println(res);
    }

}

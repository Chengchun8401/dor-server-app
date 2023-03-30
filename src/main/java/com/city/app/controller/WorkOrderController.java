package com.city.app.controller;

import com.city.app.common.param.PageParam;
import com.city.app.common.param.WorkOrderParam;
import com.city.app.common.vo.Result;
import com.city.app.service.IWorkOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version v1.0
 * @ClassName: WorkOrderController
 * @Description: 工单报修模块
 * @Author: CitySpring
 */
@RestController
@RequestMapping("/dor/work")
@Api(tags = "API-工单报修模块")
public class WorkOrderController {

    @Autowired
    private IWorkOrderService workOrderService;

    @ApiOperation("拉取报修工单列表")
    @PostMapping("/info")
    public Result getWorkOrderList(@RequestBody PageParam param, @RequestHeader("Authorization") String token){
        return workOrderService.getWorkOrderList(param, token);
    }

    @ApiOperation("获取工单详情")
    @GetMapping("/{id}")
    public Result getWorkOrderInfo(@PathVariable String id){
        return workOrderService.getWorkOrderInfo(id);
    }

    @ApiOperation("提交工单")
    @PostMapping("")
    public Result commitWorkOrder(@RequestBody WorkOrderParam param, @RequestHeader("Authorization") String token){
        return workOrderService.commitWorkOrder(param, token);
    }

    @ApiOperation("撤销工单")
    @DeleteMapping("/{id}")
    public Result deleteWorkOrder(@PathVariable String id){
        return workOrderService.deleteWorkOrder(id);
    }

    @ApiOperation("获取报修类型")
    @GetMapping("/type")
    public Result getWorkOrderType(){
        return workOrderService.getWorkOrderType();
    }

}

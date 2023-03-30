package com.city.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.city.app.common.param.PageParam;
import com.city.app.common.param.WorkOrderParam;
import com.city.app.common.vo.Result;
import com.city.app.dao.entity.WorkOrder;

/**
 * @version v1.0
 * @InterfaceName: IWorkOrderService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
public interface IWorkOrderService extends IService<WorkOrder> {

    /**
     * 获取工单列表
     * @param param 分页参数
     * @param token token获取用户Id
     */
    Result getWorkOrderList(PageParam param, String token);

    /**
     * 获取工单详情
     * @param id 工单Id
     */
    Result getWorkOrderInfo(String id);

    /**
     * 提交工单
     * @param param 工单参数
     */
    Result commitWorkOrder(WorkOrderParam param, String token);

    /**
     * 用户撤销工单
     * @param id 工单ID
     */
    Result deleteWorkOrder(String id);

    /**
     * 拉取工单报修类型
     */
    Result getWorkOrderType();
}

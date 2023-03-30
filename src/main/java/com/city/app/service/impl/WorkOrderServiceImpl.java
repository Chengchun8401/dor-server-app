package com.city.app.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.city.app.common.param.PageParam;
import com.city.app.common.param.WorkOrderParam;
import com.city.app.common.vo.PageVo;
import com.city.app.common.vo.Result;
import com.city.app.dao.entity.OrderType;
import com.city.app.dao.entity.WorkOrder;
import com.city.app.dao.mapper.WorkOrderMapper;
import com.city.app.service.IWorkOrderService;
import com.city.app.utils.FaceAipUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @version v1.0
 * @ClassName: WorkOrderServiceImpl
 * @Description: 工单业务模块 错误码 11001 - 11999
 * @Author: CitySpring
 */
@Service
public class WorkOrderServiceImpl extends ServiceImpl<WorkOrderMapper, WorkOrder> implements IWorkOrderService {

    @Autowired
    private WorkOrderMapper workOrderMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private FaceAipUtils faceAipUtils;

    @Override
    public Result getWorkOrderList(PageParam param, String token) {
        String userId = getUserId(token);
        if(Strings.isBlank(userId)){
            return Result.fail("登录状态已过期", 10005);
        }

        PageVo pageVo = new PageVo();
        Page<WorkOrder> page = new Page<>(param.getPage(), param.getPageSize());

        IPage<WorkOrder> workOrderPage = workOrderMapper.getWorkOrderList(page, Long.parseLong(userId));
        pageVo.setTotal(workOrderPage.getTotal());
        pageVo.setData(workOrderPage.getRecords());

        return Result.success(null, pageVo);
    }

    @Override
    public Result getWorkOrderInfo(String id) {
        WorkOrder workOrder = workOrderMapper.selectById(id);
        if(workOrder == null){
            return Result.fail("工单信息获取失败", 11001);
        }

        return Result.success(null, workOrder);
    }

    @Override
    public Result commitWorkOrder(WorkOrderParam param, String token) {
        String userId = getUserId(token);
        if(Strings.isBlank(userId)){
            return Result.fail("登录状态已过期", 10005);
        }

        String[] faceData = param.getFace().split(",");
        String res = faceAipUtils.faceSearch(faceData[1]);

        if(res == null){
            return Result.fail("人脸校验失败，请稍后再试", 10006);
        }

        WorkOrder workOrder = new WorkOrder();
        BeanUtils.copyProperties(param, workOrder);
        workOrder.setUserId(Long.parseLong(userId));
        workOrder.setStatus(0);
        workOrder.setCommitTime(LocalDateTime.now());

        if(workOrderMapper.insert(workOrder) > 0){
            return Result.success("工单提交成功", null);
        }
        return Result.fail("工单提交失败", 11002);
    }

    @Override
    public Result deleteWorkOrder(String id) {
        WorkOrder workOrder = workOrderMapper.selectById(id);
        if(workOrder == null){
            return Result.fail("工单不存在", 11002);
        }

        workOrder.setStatus(-1);
        if(workOrderMapper.updateById(workOrder) > 0){
            return Result.success("工单撤销成功", null);
        }

        return Result.fail("工单撤销失败", 11003);
    }

    @Override
    public Result getWorkOrderType() {
        List<OrderType> types = workOrderMapper.getWorkOrderType();
        if(types.isEmpty()){
            return Result.fail("报修类型拉取失败", 11004);
        }
        return Result.success(null, types);
    }

    /**
     * 解析Token，获取userId
     * @param token 用户token
     */
    private String getUserId(String token){
        return stringRedisTemplate.opsForValue().get("TOKEN_" + token);
    }
}

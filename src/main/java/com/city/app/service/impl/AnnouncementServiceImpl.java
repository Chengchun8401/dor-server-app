package com.city.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.city.app.common.param.PageParam;
import com.city.app.common.vo.PageVo;
import com.city.app.common.vo.Result;
import com.city.app.dao.entity.Announcement;
import com.city.app.dao.mapper.AnnouncementMapper;
import com.city.app.service.IAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version v1.0
 * @ClassName: AnnouncementService
 * @Description: 公告信息业务模块 错误码 14001 - 14999
 * @Author: CitySpring
 */

@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements IAnnouncementService {

    @Autowired
    private AnnouncementMapper announcementMapper;

    @Override
    public Result getAnnouncementList(PageParam param) {
        PageVo pageVo = new PageVo();
        // 开启分页
        Page<Announcement> page = new Page<>(param.getPage(), param.getPageSize());
        IPage<Announcement> data = announcementMapper.selectPage(page, new QueryWrapper<>());

        pageVo.setTotal(data.getTotal());
        pageVo.setData(data.getRecords());

        return Result.success(null, pageVo);
    }

    @Override
    public Result getAnnouncementById(String id) {
        Announcement announcement = announcementMapper.selectById(id);
        if(announcement == null){
            return Result.fail("获取公告信息失败", 14001);
        }
        return Result.success(null, announcement);
    }
}

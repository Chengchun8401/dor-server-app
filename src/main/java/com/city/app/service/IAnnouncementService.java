package com.city.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.city.app.common.param.PageParam;
import com.city.app.common.vo.Result;
import com.city.app.dao.entity.Announcement;

/**
 * @version v1.0
 * @InterfaceName: IAnnouncementService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
public interface IAnnouncementService extends IService<Announcement> {
    /**
     * 分页拉取公告列表
     * @param param 分页参数
     */
    Result getAnnouncementList(PageParam param);

    /**
     * 根据id拉取指定公告
     * @param id 公告id
     */
    Result getAnnouncementById(String id);
}

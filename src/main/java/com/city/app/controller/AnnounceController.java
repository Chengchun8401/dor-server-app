package com.city.app.controller;

import com.city.app.common.param.PageParam;
import com.city.app.common.vo.Result;
import com.city.app.service.IAnnouncementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version v1.0
 * @ClassName: AnnounceController
 * @Description:
 * @Author: CitySpring
 */

@RestController
@RequestMapping("/dor/announce")
@Api(tags = "API-公告信息模块")
public class AnnounceController {

    @Autowired
    private IAnnouncementService announcementService;

    @ApiOperation("分页拉取公告列表")
    @PostMapping("")
    public Result getAnnouncementList(@RequestBody PageParam param){
        return announcementService.getAnnouncementList(param);
    }

    @ApiOperation("拉取指定公告")
    @GetMapping("/{id}")
    public Result getAnnouncementById(@PathVariable String id){
        return announcementService.getAnnouncementById(id);
    }

}

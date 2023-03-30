package com.city.app.controller;

import com.city.app.common.param.PayParam;
import com.city.app.service.IDormitoryService;
import com.city.app.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version v1.0
 * @ClassName: DormitoryController
 * @Description: 寝室信息模块
 * @Author: CitySpring
 */
@Api(tags = "API-寝室信息模块")
@RestController
@RequestMapping("/dor/info")
public class DormitoryController {

    @Autowired
    private IDormitoryService dormitoryService;

    @ApiOperation("获取寝室信息")
    @GetMapping("")
    public Result getDorInfoByUserId(@RequestHeader("Authorization") String token){
        return dormitoryService.getDorInfoByUserId(token);
    }

    @ApiOperation("获取寝室水费")
    @GetMapping("/water")
    public Result getDorWaterInfo(@RequestHeader("Authorization") String token){
        return dormitoryService.getDorWaterInfo(token);
    }

    @ApiOperation("缴纳水费")
    @PutMapping("/water")
    public Result UpdateDorWater(@RequestBody PayParam payParam){
        return dormitoryService.UpdateDorWater(payParam);
    }

    @ApiOperation("获取寝室电费")
    @GetMapping("/power")
    public Result getDorPowerInfo(@RequestHeader("Authorization") String token){
        return dormitoryService.getDorPowerInfo(token);
    }

    @ApiOperation("缴纳电费")
    @PutMapping("/power")
    public Result UpdateDorPower(@RequestBody PayParam payParam){
        return dormitoryService.UpdateDorPower(payParam);
    }

    @ApiOperation("获取寝室卫生得分")
    @GetMapping("/grade")
    public Result getDorGradeInfo(@RequestHeader("Authorization") String token){
        return dormitoryService.getDorGradeInfo(token);
    }

    @ApiOperation("获取楼栋信息")
    @GetMapping("/build")
    public Result getDorBuilding(){
        return dormitoryService.getDorBuilding();
    }

}

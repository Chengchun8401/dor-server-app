package com.city.app.controller;

import com.city.app.common.param.SuggestionParam;
import com.city.app.common.vo.Result;
import com.city.app.service.ISuggestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version v1.0
 * @ClassName: SuggestionController
 * @Description:
 * @Author: CitySpring
 */
@RestController
@RequestMapping("/dor/sug")
@Api(tags = "API-留言模块")
public class SuggestionController {

    @Autowired
    private ISuggestionService suggestionService;

    @ApiOperation("用户提交留言")
    @PostMapping("")
    public Result commitSuggestion(@RequestBody SuggestionParam suggestionParam, @RequestHeader("Authorization") String token){
        return suggestionService.commitSuggestion(suggestionParam, token);
    }

}

package com.city.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.city.app.common.param.SuggestionParam;
import com.city.app.common.vo.Result;
import com.city.app.dao.entity.Suggestion;
import com.city.app.dao.mapper.SuggestionMapper;
import com.city.app.service.ISuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;

/**
 * @version v1.0
 * @ClassName: SuggestionServiceImpl
 * @Description: 留言模块 错误代码 15001 - 15999
 * @Author: CitySpring
 */
@Service
public class SuggestionServiceImpl extends ServiceImpl<SuggestionMapper, Suggestion> implements ISuggestionService {

    @Autowired
    private SuggestionMapper suggestionMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result commitSuggestion(SuggestionParam suggestionParam, String token) {
        String userId = stringRedisTemplate.opsForValue().get("TOKEN_" + token);
        if(userId == null){
            return Result.fail("登录状态已过期", 10005);
        }

        Suggestion suggestion = new Suggestion();
        suggestion.setCommitTime(LocalDate.now());
        suggestion.setContent(suggestionParam.getContent());
        suggestion.setUserId(Long.parseLong(userId));

        if(suggestionMapper.insert(suggestion) > 0){
            return Result.success("留言成功", null);
        }
        return Result.fail("留言提交失败", 15001);
    }
}

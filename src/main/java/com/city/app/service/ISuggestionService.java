package com.city.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.city.app.common.param.SuggestionParam;
import com.city.app.common.vo.Result;
import com.city.app.dao.entity.Suggestion;

/**
 * @version v1.0
 * @InterfaceName: ISuggestionService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
public interface ISuggestionService extends IService<Suggestion> {
    /**
     * 添加用户留言
     * @param suggestionParam 留言参数
     */
    Result commitSuggestion(SuggestionParam suggestionParam, String token);
}

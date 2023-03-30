package com.city.app.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.city.app.dao.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @version v1.0
 * @InterfaceName: RecordMapper
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@Mapper
public interface RecordMapper extends BaseMapper<Record> {

    Record getUserClockInfo(@Param("userId") Long userId);

}

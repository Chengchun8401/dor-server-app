package com.city.app.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.city.app.common.vo.BuildingVo;
import com.city.app.common.vo.CostVo;
import com.city.app.common.vo.DormitoryVo;
import com.city.app.common.vo.GradeVo;
import com.city.app.dao.entity.Building;
import com.city.app.dao.entity.Dormitory;
import com.city.app.dao.entity.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version v1.0
 * @InterfaceName: DormitoryMapper
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@Mapper
public interface DormitoryMapper extends BaseMapper<Dormitory> {

    /**
     * 拉取完整寝室信息
     * @param userId 学生id
     */
    DormitoryVo getDorInfoByUserId(@Param("userId") Long userId);

    /**
     * 通过学号拉取居住楼栋信息
     * @param userId 用户id
     */
    String getBuildingByUserId(@Param("userId") Long userId);

    /**
     * 获取水费信息
     * @param userId 用户id
     */
    CostVo getDorWaterInfo(@Param("userId") Long userId);

    /**
     * 获取电费信息
     * @param userId 用户id
     */
    CostVo getDorPowerInfo(@Param("userId") Long userId);

    /**
     * 获取寝室卫生得分
     * @param userId 用户id
     */
    GradeVo getDorGradeInfo(@Param("userId") Long userId);

    /**
     * 拉取楼栋信息
     */
    List<BuildingVo> getDorBuilding();

    /**
     * 获取寝室信息
     */
    Long getDormitoryInfo(@Param("buildingId") Long buildingId, @Param("roomId") Long roomId);

    /**
     * 获取楼栋下的寝室信息
     */
    List<Room> getBuildingRooms(Long id);
}

package com.webproject.mapper;

import com.webproject.entity.Building;
import com.webproject.entity.BuildingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuildingMapper {
    int countByExample(BuildingExample example);

    int deleteByExample(BuildingExample example);

    int deleteByPrimaryKey(String id);

    int insert(Building record);

    int insertSelective(Building record);

    List<Building> selectByExample(BuildingExample example);

    Building selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Building record, @Param("example") BuildingExample example);

    int updateByExample(@Param("record") Building record, @Param("example") BuildingExample example);

    int updateByPrimaryKeySelective(Building record);

    int updateByPrimaryKey(Building record);
}
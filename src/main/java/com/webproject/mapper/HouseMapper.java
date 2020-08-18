package com.webproject.mapper;

import com.webproject.entity.House;
import com.webproject.entity.HouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HouseMapper {
    int countByExample(HouseExample example);

    int deleteByExample(HouseExample example);

    int deleteByPrimaryKey(String houseid);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String houseid);

    int updateByExampleSelective(@Param("record") House record, @Param("example") HouseExample example);

    int updateByExample(@Param("record") House record, @Param("example") HouseExample example);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);
}
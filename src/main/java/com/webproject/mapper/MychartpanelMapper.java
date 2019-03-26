package com.webproject.mapper;

import com.webproject.entity.Mychartpanel;
import com.webproject.entity.MychartpanelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MychartpanelMapper {
    int countByExample(MychartpanelExample example);

    int deleteByExample(MychartpanelExample example);

    int deleteByPrimaryKey(Long panelid);

    int insert(Mychartpanel record);

    int insertSelective(Mychartpanel record);

    List<Mychartpanel> selectByExample(MychartpanelExample example);

    Mychartpanel selectByPrimaryKey(Long panelid);

    int updateByExampleSelective(@Param("record") Mychartpanel record, @Param("example") MychartpanelExample example);

    int updateByExample(@Param("record") Mychartpanel record, @Param("example") MychartpanelExample example);

    int updateByPrimaryKeySelective(Mychartpanel record);

    int updateByPrimaryKey(Mychartpanel record);
}
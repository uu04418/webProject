package com.webproject.mapper;

import com.webproject.entity.Montherchartpanel;
import com.webproject.entity.MontherchartpanelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MontherchartpanelMapper {
    int countByExample(MontherchartpanelExample example);

    int deleteByExample(MontherchartpanelExample example);

    int deleteByPrimaryKey(Long monthid);

    int insert(Montherchartpanel record);

    int insertSelective(Montherchartpanel record);

    List<Montherchartpanel> selectByExample(MontherchartpanelExample example);

    Montherchartpanel selectByPrimaryKey(Long monthid);

    int updateByExampleSelective(@Param("record") Montherchartpanel record, @Param("example") MontherchartpanelExample example);

    int updateByExample(@Param("record") Montherchartpanel record, @Param("example") MontherchartpanelExample example);

    int updateByPrimaryKeySelective(Montherchartpanel record);

    int updateByPrimaryKey(Montherchartpanel record);
}
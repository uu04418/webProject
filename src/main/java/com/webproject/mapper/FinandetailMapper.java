package com.webproject.mapper;

import com.webproject.entity.Finandetail;
import com.webproject.entity.FinandetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FinandetailMapper {
    int countByExample(FinandetailExample example);

    int deleteByExample(FinandetailExample example);

    int deleteByPrimaryKey(Long finandetailid);

    int insert(Finandetail record);

    int insertSelective(Finandetail record);

    List<Finandetail> selectByExample(FinandetailExample example);

    Finandetail selectByPrimaryKey(Long finandetailid);

    int updateByExampleSelective(@Param("record") Finandetail record, @Param("example") FinandetailExample example);

    int updateByExample(@Param("record") Finandetail record, @Param("example") FinandetailExample example);

    int updateByPrimaryKeySelective(Finandetail record);

    int updateByPrimaryKey(Finandetail record);
}
package com.webproject.mapper;

import com.webproject.entity.Financial;
import com.webproject.entity.FinancialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FinancialMapper {
    int countByExample(FinancialExample example);

    int deleteByExample(FinancialExample example);

    int deleteByPrimaryKey(String financialid);

    int insert(Financial record);

    int insertSelective(Financial record);

    List<Financial> selectByExample(FinancialExample example);

    Financial selectByPrimaryKey(String financialid);

    int updateByExampleSelective(@Param("record") Financial record, @Param("example") FinancialExample example);

    int updateByExample(@Param("record") Financial record, @Param("example") FinancialExample example);

    int updateByPrimaryKeySelective(Financial record);

    int updateByPrimaryKey(Financial record);
}
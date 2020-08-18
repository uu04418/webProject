package com.webproject.mapper;

import com.webproject.entity.Payexpert;
import com.webproject.entity.PayexpertExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayexpertMapper {
    int countByExample(PayexpertExample example);

    int deleteByExample(PayexpertExample example);

    int deleteByPrimaryKey(String payexpertid);

    int insert(Payexpert record);

    int insertSelective(Payexpert record);

    List<Payexpert> selectByExample(PayexpertExample example);

    Payexpert selectByPrimaryKey(String payexpertid);

    int updateByExampleSelective(@Param("record") Payexpert record, @Param("example") PayexpertExample example);

    int updateByExample(@Param("record") Payexpert record, @Param("example") PayexpertExample example);

    int updateByPrimaryKeySelective(Payexpert record);

    int updateByPrimaryKey(Payexpert record);
}
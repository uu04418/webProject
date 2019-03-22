package com.webproject.mapper;

import com.webproject.entity.Loginuser;
import com.webproject.entity.LoginuserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginuserMapper {
    int countByExample(LoginuserExample example);

    int deleteByExample(LoginuserExample example);

    int deleteByPrimaryKey(String userid);

    int insert(Loginuser record);

    int insertSelective(Loginuser record);

    List<Loginuser> selectByExample(LoginuserExample example);

    Loginuser selectByPrimaryKey(String userid);

    int updateByExampleSelective(@Param("record") Loginuser record, @Param("example") LoginuserExample example);

    int updateByExample(@Param("record") Loginuser record, @Param("example") LoginuserExample example);

    int updateByPrimaryKeySelective(Loginuser record);

    int updateByPrimaryKey(Loginuser record);
}
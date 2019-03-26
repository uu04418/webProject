package com.webproject.mapper;

import com.webproject.entity.Backimageurl;
import com.webproject.entity.BackimageurlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BackimageurlMapper {
    int countByExample(BackimageurlExample example);

    int deleteByExample(BackimageurlExample example);

    int deleteByPrimaryKey(Long imageid);

    int insert(Backimageurl record);

    int insertSelective(Backimageurl record);

    List<Backimageurl> selectByExample(BackimageurlExample example);

    Backimageurl selectByPrimaryKey(Long imageid);

    int updateByExampleSelective(@Param("record") Backimageurl record, @Param("example") BackimageurlExample example);

    int updateByExample(@Param("record") Backimageurl record, @Param("example") BackimageurlExample example);

    int updateByPrimaryKeySelective(Backimageurl record);

    int updateByPrimaryKey(Backimageurl record);
}
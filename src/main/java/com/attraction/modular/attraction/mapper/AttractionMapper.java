package com.attraction.modular.attraction.mapper;

import com.attraction.modular.attraction.entity.Attraction;
import com.attraction.modular.attraction.entity.AttractionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttractionMapper {
    int countByExample(AttractionExample example);

    int deleteByExample(AttractionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Attraction record);

    int insertSelective(Attraction record);

    List<Attraction> selectByExample(AttractionExample example);

    Attraction selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Attraction record, @Param("example") AttractionExample example);

    int updateByExample(@Param("record") Attraction record, @Param("example") AttractionExample example);

    int updateByPrimaryKeySelective(Attraction record);

    int updateByPrimaryKey(Attraction record);
}
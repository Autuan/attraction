package com.attraction.modular.attraction.mapper;

import com.attraction.modular.attraction.entity.Attraction;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DIYAttractionMapper {
    List<Attraction> search(@Param("keyword") String keyword);

    List<Attraction> list(@Param("pageNo") Integer pageNo,
                          @Param("pageSize") Integer pageSize);
}
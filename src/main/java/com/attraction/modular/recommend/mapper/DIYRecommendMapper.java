package com.attraction.modular.recommend.mapper;

import com.attraction.modular.recommend.entity.Recommend;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DIYRecommendMapper {
    void insertBatch(List<Recommend> recommends);

    void updateBatch(List<Recommend> recommends);
}

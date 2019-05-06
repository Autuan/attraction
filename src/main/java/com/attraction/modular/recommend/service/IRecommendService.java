package com.attraction.modular.recommend.service;

import com.attraction.modular.attraction.entity.Attraction;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import java.io.IOException;
import java.util.List;

public interface IRecommendService {
    /**
     * 修改用户的喜好城市
     * @param attractions
     * @param memberId
     * @param score
     */
    void updateUserAttraction(List<Attraction> attractions, Integer memberId, Integer score);

    void updateAttraction(List<Integer> attractionIds,Integer memberId,Integer score);

    List<Attraction> attractionRecommend(Integer memberId);
}

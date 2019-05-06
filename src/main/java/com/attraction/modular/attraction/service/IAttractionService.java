package com.attraction.modular.attraction.service;

import com.attraction.modular.attraction.entity.Attraction;
import com.attraction.modular.attraction.entity.AttractionExample;
import org.apache.mahout.cf.taste.common.TasteException;

import java.io.IOException;
import java.util.List;

public interface IAttractionService {
    void insert(Attraction attraction);

    void update(Attraction attraction);

    void delete(Integer id);

    List<Attraction> list();

    List<Attraction> list(Integer pageNo,Integer pageSize);

    Attraction selectById(Integer id);

    List<Attraction> search(String keyword);

    List<Attraction> selectByIds(List<Integer> ids);
}

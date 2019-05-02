package com.attraction.modular.attraction.service;

import com.attraction.modular.attraction.entity.Attraction;

import java.util.List;

public interface IAttractionService {
    void insert(Attraction attraction);

    void update(Attraction attraction);

    void delete(Integer id);

    List<Attraction> list();

    Attraction selectById(Integer id);
}

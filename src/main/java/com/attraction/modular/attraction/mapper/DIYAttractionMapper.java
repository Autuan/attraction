package com.attraction.modular.attraction.mapper;

import com.attraction.modular.attraction.entity.Attraction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DIYAttractionMapper {
    List<Attraction> list();
}
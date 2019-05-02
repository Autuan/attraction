package com.attraction.modular.attraction.service.impl;

import com.attraction.modular.attraction.entity.Attraction;
import com.attraction.modular.attraction.mapper.AttractionMapper;
import com.attraction.modular.attraction.mapper.DIYAttractionMapper;
import com.attraction.modular.attraction.service.IAttractionService;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AttractionServiceImpl implements IAttractionService {
    @Autowired
    private AttractionMapper attractionMapper;
    @Autowired
    private DIYAttractionMapper diyAttractionMapper;

    @Override
    public void insert(Attraction attraction) {
        attraction.setId(null);
        attractionMapper.insert(attraction);
    }

    @Override
    public void update(Attraction attraction) {
        attractionMapper.updateByPrimaryKey(attraction);
    }

    @Override
    public void delete(Integer id) {
        attractionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Attraction> list() {
        return diyAttractionMapper.list();
    }

    @Override
    public Attraction selectById(Integer id) {
        return attractionMapper.selectByPrimaryKey(id);
    }
}

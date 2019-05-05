package com.attraction.modular.attraction.service.impl;

import com.attraction.modular.attraction.entity.Attraction;
import com.attraction.modular.attraction.entity.AttractionExample;
import com.attraction.modular.attraction.mapper.AttractionMapper;
import com.attraction.modular.attraction.mapper.DIYAttractionMapper;
import com.attraction.modular.attraction.service.IAttractionService;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import groovy.util.logging.Slf4j;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
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
        return diyAttractionMapper.list(null,null);
    }

    @Override
    public List<Attraction> list(Integer pageNo, Integer pageSize) {
        return diyAttractionMapper.list(pageNo,pageSize);
    }

    @Override
    public Attraction selectById(Integer id) {
        return attractionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Attraction> search(String keyword) {
        return diyAttractionMapper.search(keyword);
    }

    @Override
    public List<Attraction> selectByExample(List<Integer> ids) {
        AttractionExample example = new AttractionExample();
        example.createCriteria()
                .andIdIn(ids);
        return attractionMapper.selectByExample(example);
    }
}

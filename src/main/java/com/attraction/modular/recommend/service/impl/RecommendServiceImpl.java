package com.attraction.modular.recommend.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.attraction.modular.attraction.entity.Attraction;
import com.attraction.modular.attraction.service.IAttractionService;
import com.attraction.modular.recommend.entity.Recommend;
import com.attraction.modular.recommend.entity.RecommendExample;
import com.attraction.modular.recommend.mapper.DIYRecommendMapper;
import com.attraction.modular.recommend.mapper.RecommendMapper;
import com.attraction.modular.recommend.service.IRecommendService;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import groovy.util.logging.Slf4j;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.collect;

@Service
@Slf4j
public class RecommendServiceImpl implements IRecommendService {
    @Autowired
    private RecommendMapper recommendMapper;
    @Autowired
    private DIYRecommendMapper diyRecommendMapper;
    @Autowired
    private IAttractionService attractionService;

    @Override
    public void updateUserAttraction(List<Attraction> attractions, Integer memberId, Integer score) {
        List<Integer> attractionIds = attractions.stream().map(Attraction::getId).collect(toList());
        updateAttraction(attractionIds,memberId,score);
    }

    @Override
    public void updateAttraction(List<Integer> attractionIds, Integer memberId, Integer score) {
        // 删除之前保存的记录,保证同一景点同一用户只有一条记录
//        RecommendExample example = new RecommendExample();
//        example.createCriteria()
//                .andMemberIdEqualTo(memberId)
//                .andAttractionIdIn(attractionIds);
//        recommendMapper.deleteByExample(example);

        for (Integer attractionId : attractionIds) {
            Recommend recommend = new Recommend();
            recommend.setAttractionId(attractionId);
            recommend.setMemberId(memberId);
            recommend.setScore(score);
            recommend.setRecordTime(new Date());
            recommendMapper.insertSelective(recommend);
        }
    }

    @Override
    public List<Attraction> attractionRecommend(Integer memberId) {
        try {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUser("root");
            dataSource.setPassword("root");
            dataSource.setUseSSL(true);
            dataSource.setServerName("localhost");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("attraction");

            // 基于JDBC构建模型
            JDBCDataModel jdbcDataModel = new MySQLJDBCDataModel(
                    dataSource, "recommend_tab", "member_id",
                    "attraction_id", "score", "record_time");

            // 相似度计算（皮尔森相似度）
            UserSimilarity similarity = new PearsonCorrelationSimilarity(jdbcDataModel);

            // 设置相似用户阈值（或使用NearestNUserNeighborhood）
            UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, jdbcDataModel);

            // 基于以上数据创建推荐器（这里使用的是基于用户的推荐，还有GenericItemBasedRecommender等推荐器）
            Recommender recommender = new GenericUserBasedRecommender(jdbcDataModel, neighborhood, similarity);

            // 给用户推荐物品（这里是给用户推荐5个物品）
            List<RecommendedItem> recommendItems = recommender.recommend(Long.valueOf(memberId), 5);
            List<Integer> itemIds = recommendItems.stream()
                    .map(RecommendedItem::getItemID)
                    .map(Long::intValue)
                    .collect(toList());
            if (CollUtil.isNotEmpty(itemIds)) {
                return attractionService.selectByIds(itemIds);
            }
            return null;
        } catch (TasteException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void updateOrInsert(List<Recommend> list) {
        Map<Boolean, List<Recommend>> collect
                = list.stream()
                .collect(partitioningBy(recommend -> null != recommend.getId()));
        diyRecommendMapper.insertBatch(collect.get(false));
        diyRecommendMapper.updateBatch(collect.get(true));
    }
}

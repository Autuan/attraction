package com.attraction.modular.user.mapper;

import com.attraction.modular.user.entity.LoginTable;
import com.attraction.modular.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Integer haveThisUser(String logname);

    LoginTable tryLog(@Param("logname") String logname,
                      @Param("password")String password);

    List<User> getActiveList();

    String getNameById(Integer userId);

    List<User> getUserList(@Param("pageNum") int pageNum,
                           @Param("pageSize") int pageSize);

    List<User> getPushMan();

    List<User> getAdminAndTechnology();

    User getUserByName(String name);

    int countAll();
}
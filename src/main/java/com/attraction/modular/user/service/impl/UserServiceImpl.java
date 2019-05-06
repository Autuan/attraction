package com.attraction.modular.user.service.impl;

import com.attraction.common.util.LoginUtil;
import com.attraction.modular.user.entity.LoginTable;
import com.attraction.modular.user.entity.User;
import com.attraction.modular.user.mapper.UserMapper;
import com.attraction.modular.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer haveThisUser(String logname) {
        return userMapper.haveThisUser(logname);
    }

    @Override
    public LoginTable tryLog(String logname, String password) {
        return userMapper.tryLog(logname,password);
    }

    @Override
    public List<User> getActiveList() {
        return userMapper.getActiveList();
    }

    @Override
    public String getNameById(Integer userId) {
        return userMapper.getNameById(userId);
    }

    @Override
    public void insertUser(User user) {
        String password =  LoginUtil.getSHA256Str(user.getUserPassword());
        user.setUserPassword(password);
        userMapper.insertSelective(user);
    }

    @Override
    public List<User> getUserList(Integer page,Integer rows) {
        page = (page - 1 ) * rows;
        List<User> users = userMapper.getUserList(page,rows);
        return users;
    }

    @Override
    public void updateUser(User user) {
        if ( null != user.getUserPassword() ) {
            String password =  LoginUtil.getSHA256Str(user.getUserPassword());
            user.setUserPassword(password);
        }
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    @Transactional
    public void deleteUser(Integer userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public List<User> getAdminAndTechnology() {
        return userMapper.getAdminAndTechnology();
    }

    @Override
    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public int countAll() {
        return userMapper.countAll();
    }
}

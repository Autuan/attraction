package com.attraction.modular.user.service;

import com.attraction.modular.user.entity.LoginTable;
import com.attraction.modular.user.entity.User;

import java.util.List;

public interface IUserService {
    /**
     * 检查是否拥有此用户
     * @param logname
     * @return
     */
    Integer haveThisUser(String logname);

    /**
     * 尝试登陆
     * @param logname
     * @param password
     * @return
     */
    LoginTable tryLog(String logname, String password);

    /**
     * 获取可执行人员列表
     * @return
     */
    List<User> getActiveList();

    /**
     * 根据Id获取名字
     * @param userId
     * @return
     */
    String getNameById(Integer userId);

    /**
     * 创建用户
     * @param user
     */
    void insertUser(User user);

    /**
     * 查询用户列表
     * @return
     */
    List<User> getUserList(Integer page,Integer rows);

    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 取主管和技术人员
     * @return
     */
    List<User> getAdminAndTechnology();

    /**
     * 根据用户主键查找用户
     * @param userId 主键
     * @return 用户
     */
    User getUserById(Integer userId);

    /**
     * 根据用户名取用户
     * @param name 用户姓名
     * @return
     */
    User getUserByName(String name);

    /**
     * 统计所有条数
     * @return
     */
    int countAll();
}

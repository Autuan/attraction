package com.attraction.modular.member.service;

import com.attraction.modular.member.entity.Member;

public interface IMemberService {
    /**
     * 新增
     * @param member
     */
    int insertMember(Member member);

    /**
     * 修改
     * @param member
     */
    void updateMember(Member member);

    /**
     * 删除
     * @param memberId
     */
    void deleteMember(Integer memberId);

    /**
     * 用户登录
     * @param username @NotBlank : 用户名
     * @param password  密码
     * @return
     */
    Member userLogin(String username, String password);
    /**
     * 检查用户
     * @param username @NotBlank : 用户名
     * @param password  密码
     * @return
     */
    int checkUser(String username, String password);
    /**
     * 检查用户
     * @param username @NotBlank : 用户名
     * @return
     */
    int checkUser(String username);
}

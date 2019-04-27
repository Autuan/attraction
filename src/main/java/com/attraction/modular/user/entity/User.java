package com.attraction.modular.user.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

public class User implements Serializable {
    @Excel(name = "用户ID")
    private Integer userId;

    @Excel(name = "用户登陆名")
    private String userLogname;

    @Excel(name="用户密码")
    private String userPassword;

    @Excel(name = "用户姓名")
    private String userUsername;

    @Excel(name="用户权限",replace = {"工作人员_0","主管_1","技术人员_2"})
    private Integer userRole;

    @Excel(name = "部门编号")
    private Integer deptId;

    private String roleName;

    private String deptName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserLogname() {
        return userLogname;
    }

    public void setUserLogname(String userLogname) {
        this.userLogname = userLogname == null ? null : userLogname.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername == null ? null : userUsername.trim();
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userLogname='" + userLogname + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userUsername='" + userUsername + '\'' +
                ", userRole=" + userRole +
                ", deptId=" + deptId +
                '}';
    }
}
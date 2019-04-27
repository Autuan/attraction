package com.attraction.modular.user.entity;

public class LoginTable {

    private Integer loginId;

    private Integer loginRoleId;

    private String loginEmail;

    private String loginPassword;

    private String loginName;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getLoginRoleId() {
        return loginRoleId;
    }

    public void setLoginRoleId(Integer loginRoleId) {
        this.loginRoleId = loginRoleId;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
}
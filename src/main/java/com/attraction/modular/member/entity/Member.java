package com.attraction.modular.member.entity;

import java.io.Serializable;

public class Member implements Serializable {
    private Integer id;

    private String account;

    private String password;

    private String hobby;

    private String name;

    private String summary;

    private String headImg;

    private Integer gender;

    private String birthday;

    private static final long serialVersionUID = 1L;

    public Member(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public Member() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby == null ? null : hobby.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", hobby=").append(hobby);
        sb.append(", name=").append(name);
        sb.append(", summary=").append(summary);
        sb.append(", headImg=").append(headImg);
        sb.append(", gender=").append(gender);
        sb.append(", birthday=").append(birthday);
        sb.append("]");
        return sb.toString();
    }
}
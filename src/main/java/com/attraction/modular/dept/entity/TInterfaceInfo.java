package com.attraction.modular.dept.entity;

import java.io.Serializable;
import java.util.Date;

public class TInterfaceInfo implements Serializable {
    private Integer interfaceId;

    private String interfaceName;

    private String interfaceContent;

    private String interfaceProvider;

    private String interfaceConsumer;

    private String interfaceType;

    private Integer sysNodeId;

    private String reqUrl;

    private String reqClass;

    private String retClass;

    private Integer reserve1;

    private String reserve2;

    private String reserve3;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    private String isValid;

    private String retDataModel;

    private static final long serialVersionUID = 1L;

    public Integer getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Integer interfaceId) {
        this.interfaceId = interfaceId;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName == null ? null : interfaceName.trim();
    }

    public String getInterfaceContent() {
        return interfaceContent;
    }

    public void setInterfaceContent(String interfaceContent) {
        this.interfaceContent = interfaceContent == null ? null : interfaceContent.trim();
    }

    public String getInterfaceProvider() {
        return interfaceProvider;
    }

    public void setInterfaceProvider(String interfaceProvider) {
        this.interfaceProvider = interfaceProvider == null ? null : interfaceProvider.trim();
    }

    public String getInterfaceConsumer() {
        return interfaceConsumer;
    }

    public void setInterfaceConsumer(String interfaceConsumer) {
        this.interfaceConsumer = interfaceConsumer == null ? null : interfaceConsumer.trim();
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType == null ? null : interfaceType.trim();
    }

    public Integer getSysNodeId() {
        return sysNodeId;
    }

    public void setSysNodeId(Integer sysNodeId) {
        this.sysNodeId = sysNodeId;
    }

    public String getReqUrl() {
        return reqUrl;
    }

    public void setReqUrl(String reqUrl) {
        this.reqUrl = reqUrl == null ? null : reqUrl.trim();
    }

    public String getReqClass() {
        return reqClass;
    }

    public void setReqClass(String reqClass) {
        this.reqClass = reqClass == null ? null : reqClass.trim();
    }

    public String getRetClass() {
        return retClass;
    }

    public void setRetClass(String retClass) {
        this.retClass = retClass == null ? null : retClass.trim();
    }

    public Integer getReserve1() {
        return reserve1;
    }

    public void setReserve1(Integer reserve1) {
        this.reserve1 = reserve1;
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2 == null ? null : reserve2.trim();
    }

    public String getReserve3() {
        return reserve3;
    }

    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3 == null ? null : reserve3.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid == null ? null : isValid.trim();
    }

    public String getRetDataModel() {
        return retDataModel;
    }

    public void setRetDataModel(String retDataModel) {
        this.retDataModel = retDataModel == null ? null : retDataModel.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", interfaceId=").append(interfaceId);
        sb.append(", interfaceName=").append(interfaceName);
        sb.append(", interfaceContent=").append(interfaceContent);
        sb.append(", interfaceProvider=").append(interfaceProvider);
        sb.append(", interfaceConsumer=").append(interfaceConsumer);
        sb.append(", interfaceType=").append(interfaceType);
        sb.append(", sysNodeId=").append(sysNodeId);
        sb.append(", reqUrl=").append(reqUrl);
        sb.append(", reqClass=").append(reqClass);
        sb.append(", retClass=").append(retClass);
        sb.append(", reserve1=").append(reserve1);
        sb.append(", reserve2=").append(reserve2);
        sb.append(", reserve3=").append(reserve3);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isValid=").append(isValid);
        sb.append(", retDataModel=").append(retDataModel);
        sb.append("]");
        return sb.toString();
    }
}
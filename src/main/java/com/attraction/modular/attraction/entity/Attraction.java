package com.attraction.modular.attraction.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Attraction implements Serializable {
    private Integer id;

    private String attractionName;

    private Integer attractionStar;

    private String attractionAddress;

    private String attractionSummary;

    private BigDecimal attractionPrice;

    private String attractionDetail;

    private String attractionImg;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName == null ? null : attractionName.trim();
    }

    public Integer getAttractionStar() {
        return attractionStar;
    }

    public void setAttractionStar(Integer attractionStar) {
        this.attractionStar = attractionStar;
    }

    public String getAttractionAddress() {
        return attractionAddress;
    }

    public void setAttractionAddress(String attractionAddress) {
        this.attractionAddress = attractionAddress == null ? null : attractionAddress.trim();
    }

    public String getAttractionSummary() {
        return attractionSummary;
    }

    public void setAttractionSummary(String attractionSummary) {
        this.attractionSummary = attractionSummary == null ? null : attractionSummary.trim();
    }

    public BigDecimal getAttractionPrice() {
        return attractionPrice;
    }

    public void setAttractionPrice(BigDecimal attractionPrice) {
        this.attractionPrice = attractionPrice;
    }

    public String getAttractionDetail() {
        return attractionDetail;
    }

    public void setAttractionDetail(String attractionDetail) {
        this.attractionDetail = attractionDetail == null ? null : attractionDetail.trim();
    }

    public String getAttractionImg() {
        return attractionImg;
    }

    public void setAttractionImg(String attractionImg) {
        this.attractionImg = attractionImg == null ? null : attractionImg.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", attractionName=").append(attractionName);
        sb.append(", attractionStar=").append(attractionStar);
        sb.append(", attractionAddress=").append(attractionAddress);
        sb.append(", attractionSummary=").append(attractionSummary);
        sb.append(", attractionPrice=").append(attractionPrice);
        sb.append(", attractionDetail=").append(attractionDetail);
        sb.append(", attractionImg=").append(attractionImg);
        sb.append("]");
        return sb.toString();
    }
}
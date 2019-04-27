package com.attraction.common.entity;

/**
 * Echart 图表 饼状图 返回数据类型 包装类
 */
public class EchartPieResult {
    private Integer value;
    private String name;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.attraction.common.entity;

/**
 * Echart 图表 柱状图 返回数据类型 包装类
 */
public class EchartBarResult {
    // ---------------------- 属性 ----------------------
    private String[] categories;
    private Object[] data;

    // ---------------------- Getter & Setter ----------------------
    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }
}

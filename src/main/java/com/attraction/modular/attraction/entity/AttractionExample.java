package com.attraction.modular.attraction.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AttractionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttractionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAttractionNameIsNull() {
            addCriterion("attraction_name is null");
            return (Criteria) this;
        }

        public Criteria andAttractionNameIsNotNull() {
            addCriterion("attraction_name is not null");
            return (Criteria) this;
        }

        public Criteria andAttractionNameEqualTo(String value) {
            addCriterion("attraction_name =", value, "attractionName");
            return (Criteria) this;
        }

        public Criteria andAttractionNameNotEqualTo(String value) {
            addCriterion("attraction_name <>", value, "attractionName");
            return (Criteria) this;
        }

        public Criteria andAttractionNameGreaterThan(String value) {
            addCriterion("attraction_name >", value, "attractionName");
            return (Criteria) this;
        }

        public Criteria andAttractionNameGreaterThanOrEqualTo(String value) {
            addCriterion("attraction_name >=", value, "attractionName");
            return (Criteria) this;
        }

        public Criteria andAttractionNameLessThan(String value) {
            addCriterion("attraction_name <", value, "attractionName");
            return (Criteria) this;
        }

        public Criteria andAttractionNameLessThanOrEqualTo(String value) {
            addCriterion("attraction_name <=", value, "attractionName");
            return (Criteria) this;
        }

        public Criteria andAttractionNameLike(String value) {
            addCriterion("attraction_name like", value, "attractionName");
            return (Criteria) this;
        }

        public Criteria andAttractionNameNotLike(String value) {
            addCriterion("attraction_name not like", value, "attractionName");
            return (Criteria) this;
        }

        public Criteria andAttractionNameIn(List<String> values) {
            addCriterion("attraction_name in", values, "attractionName");
            return (Criteria) this;
        }

        public Criteria andAttractionNameNotIn(List<String> values) {
            addCriterion("attraction_name not in", values, "attractionName");
            return (Criteria) this;
        }

        public Criteria andAttractionNameBetween(String value1, String value2) {
            addCriterion("attraction_name between", value1, value2, "attractionName");
            return (Criteria) this;
        }

        public Criteria andAttractionNameNotBetween(String value1, String value2) {
            addCriterion("attraction_name not between", value1, value2, "attractionName");
            return (Criteria) this;
        }

        public Criteria andAttractionStarIsNull() {
            addCriterion("attraction_star is null");
            return (Criteria) this;
        }

        public Criteria andAttractionStarIsNotNull() {
            addCriterion("attraction_star is not null");
            return (Criteria) this;
        }

        public Criteria andAttractionStarEqualTo(Integer value) {
            addCriterion("attraction_star =", value, "attractionStar");
            return (Criteria) this;
        }

        public Criteria andAttractionStarNotEqualTo(Integer value) {
            addCriterion("attraction_star <>", value, "attractionStar");
            return (Criteria) this;
        }

        public Criteria andAttractionStarGreaterThan(Integer value) {
            addCriterion("attraction_star >", value, "attractionStar");
            return (Criteria) this;
        }

        public Criteria andAttractionStarGreaterThanOrEqualTo(Integer value) {
            addCriterion("attraction_star >=", value, "attractionStar");
            return (Criteria) this;
        }

        public Criteria andAttractionStarLessThan(Integer value) {
            addCriterion("attraction_star <", value, "attractionStar");
            return (Criteria) this;
        }

        public Criteria andAttractionStarLessThanOrEqualTo(Integer value) {
            addCriterion("attraction_star <=", value, "attractionStar");
            return (Criteria) this;
        }

        public Criteria andAttractionStarIn(List<Integer> values) {
            addCriterion("attraction_star in", values, "attractionStar");
            return (Criteria) this;
        }

        public Criteria andAttractionStarNotIn(List<Integer> values) {
            addCriterion("attraction_star not in", values, "attractionStar");
            return (Criteria) this;
        }

        public Criteria andAttractionStarBetween(Integer value1, Integer value2) {
            addCriterion("attraction_star between", value1, value2, "attractionStar");
            return (Criteria) this;
        }

        public Criteria andAttractionStarNotBetween(Integer value1, Integer value2) {
            addCriterion("attraction_star not between", value1, value2, "attractionStar");
            return (Criteria) this;
        }

        public Criteria andAttractionAddressIsNull() {
            addCriterion("attraction_address is null");
            return (Criteria) this;
        }

        public Criteria andAttractionAddressIsNotNull() {
            addCriterion("attraction_address is not null");
            return (Criteria) this;
        }

        public Criteria andAttractionAddressEqualTo(String value) {
            addCriterion("attraction_address =", value, "attractionAddress");
            return (Criteria) this;
        }

        public Criteria andAttractionAddressNotEqualTo(String value) {
            addCriterion("attraction_address <>", value, "attractionAddress");
            return (Criteria) this;
        }

        public Criteria andAttractionAddressGreaterThan(String value) {
            addCriterion("attraction_address >", value, "attractionAddress");
            return (Criteria) this;
        }

        public Criteria andAttractionAddressGreaterThanOrEqualTo(String value) {
            addCriterion("attraction_address >=", value, "attractionAddress");
            return (Criteria) this;
        }

        public Criteria andAttractionAddressLessThan(String value) {
            addCriterion("attraction_address <", value, "attractionAddress");
            return (Criteria) this;
        }

        public Criteria andAttractionAddressLessThanOrEqualTo(String value) {
            addCriterion("attraction_address <=", value, "attractionAddress");
            return (Criteria) this;
        }

        public Criteria andAttractionAddressLike(String value) {
            addCriterion("attraction_address like", value, "attractionAddress");
            return (Criteria) this;
        }

        public Criteria andAttractionAddressNotLike(String value) {
            addCriterion("attraction_address not like", value, "attractionAddress");
            return (Criteria) this;
        }

        public Criteria andAttractionAddressIn(List<String> values) {
            addCriterion("attraction_address in", values, "attractionAddress");
            return (Criteria) this;
        }

        public Criteria andAttractionAddressNotIn(List<String> values) {
            addCriterion("attraction_address not in", values, "attractionAddress");
            return (Criteria) this;
        }

        public Criteria andAttractionAddressBetween(String value1, String value2) {
            addCriterion("attraction_address between", value1, value2, "attractionAddress");
            return (Criteria) this;
        }

        public Criteria andAttractionAddressNotBetween(String value1, String value2) {
            addCriterion("attraction_address not between", value1, value2, "attractionAddress");
            return (Criteria) this;
        }

        public Criteria andAttractionSummaryIsNull() {
            addCriterion("attraction_summary is null");
            return (Criteria) this;
        }

        public Criteria andAttractionSummaryIsNotNull() {
            addCriterion("attraction_summary is not null");
            return (Criteria) this;
        }

        public Criteria andAttractionSummaryEqualTo(String value) {
            addCriterion("attraction_summary =", value, "attractionSummary");
            return (Criteria) this;
        }

        public Criteria andAttractionSummaryNotEqualTo(String value) {
            addCriterion("attraction_summary <>", value, "attractionSummary");
            return (Criteria) this;
        }

        public Criteria andAttractionSummaryGreaterThan(String value) {
            addCriterion("attraction_summary >", value, "attractionSummary");
            return (Criteria) this;
        }

        public Criteria andAttractionSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("attraction_summary >=", value, "attractionSummary");
            return (Criteria) this;
        }

        public Criteria andAttractionSummaryLessThan(String value) {
            addCriterion("attraction_summary <", value, "attractionSummary");
            return (Criteria) this;
        }

        public Criteria andAttractionSummaryLessThanOrEqualTo(String value) {
            addCriterion("attraction_summary <=", value, "attractionSummary");
            return (Criteria) this;
        }

        public Criteria andAttractionSummaryLike(String value) {
            addCriterion("attraction_summary like", value, "attractionSummary");
            return (Criteria) this;
        }

        public Criteria andAttractionSummaryNotLike(String value) {
            addCriterion("attraction_summary not like", value, "attractionSummary");
            return (Criteria) this;
        }

        public Criteria andAttractionSummaryIn(List<String> values) {
            addCriterion("attraction_summary in", values, "attractionSummary");
            return (Criteria) this;
        }

        public Criteria andAttractionSummaryNotIn(List<String> values) {
            addCriterion("attraction_summary not in", values, "attractionSummary");
            return (Criteria) this;
        }

        public Criteria andAttractionSummaryBetween(String value1, String value2) {
            addCriterion("attraction_summary between", value1, value2, "attractionSummary");
            return (Criteria) this;
        }

        public Criteria andAttractionSummaryNotBetween(String value1, String value2) {
            addCriterion("attraction_summary not between", value1, value2, "attractionSummary");
            return (Criteria) this;
        }

        public Criteria andAttractionPriceIsNull() {
            addCriterion("attraction_price is null");
            return (Criteria) this;
        }

        public Criteria andAttractionPriceIsNotNull() {
            addCriterion("attraction_price is not null");
            return (Criteria) this;
        }

        public Criteria andAttractionPriceEqualTo(BigDecimal value) {
            addCriterion("attraction_price =", value, "attractionPrice");
            return (Criteria) this;
        }

        public Criteria andAttractionPriceNotEqualTo(BigDecimal value) {
            addCriterion("attraction_price <>", value, "attractionPrice");
            return (Criteria) this;
        }

        public Criteria andAttractionPriceGreaterThan(BigDecimal value) {
            addCriterion("attraction_price >", value, "attractionPrice");
            return (Criteria) this;
        }

        public Criteria andAttractionPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("attraction_price >=", value, "attractionPrice");
            return (Criteria) this;
        }

        public Criteria andAttractionPriceLessThan(BigDecimal value) {
            addCriterion("attraction_price <", value, "attractionPrice");
            return (Criteria) this;
        }

        public Criteria andAttractionPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("attraction_price <=", value, "attractionPrice");
            return (Criteria) this;
        }

        public Criteria andAttractionPriceIn(List<BigDecimal> values) {
            addCriterion("attraction_price in", values, "attractionPrice");
            return (Criteria) this;
        }

        public Criteria andAttractionPriceNotIn(List<BigDecimal> values) {
            addCriterion("attraction_price not in", values, "attractionPrice");
            return (Criteria) this;
        }

        public Criteria andAttractionPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("attraction_price between", value1, value2, "attractionPrice");
            return (Criteria) this;
        }

        public Criteria andAttractionPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("attraction_price not between", value1, value2, "attractionPrice");
            return (Criteria) this;
        }

        public Criteria andAttractionDetailIsNull() {
            addCriterion("attraction_detail is null");
            return (Criteria) this;
        }

        public Criteria andAttractionDetailIsNotNull() {
            addCriterion("attraction_detail is not null");
            return (Criteria) this;
        }

        public Criteria andAttractionDetailEqualTo(String value) {
            addCriterion("attraction_detail =", value, "attractionDetail");
            return (Criteria) this;
        }

        public Criteria andAttractionDetailNotEqualTo(String value) {
            addCriterion("attraction_detail <>", value, "attractionDetail");
            return (Criteria) this;
        }

        public Criteria andAttractionDetailGreaterThan(String value) {
            addCriterion("attraction_detail >", value, "attractionDetail");
            return (Criteria) this;
        }

        public Criteria andAttractionDetailGreaterThanOrEqualTo(String value) {
            addCriterion("attraction_detail >=", value, "attractionDetail");
            return (Criteria) this;
        }

        public Criteria andAttractionDetailLessThan(String value) {
            addCriterion("attraction_detail <", value, "attractionDetail");
            return (Criteria) this;
        }

        public Criteria andAttractionDetailLessThanOrEqualTo(String value) {
            addCriterion("attraction_detail <=", value, "attractionDetail");
            return (Criteria) this;
        }

        public Criteria andAttractionDetailLike(String value) {
            addCriterion("attraction_detail like", value, "attractionDetail");
            return (Criteria) this;
        }

        public Criteria andAttractionDetailNotLike(String value) {
            addCriterion("attraction_detail not like", value, "attractionDetail");
            return (Criteria) this;
        }

        public Criteria andAttractionDetailIn(List<String> values) {
            addCriterion("attraction_detail in", values, "attractionDetail");
            return (Criteria) this;
        }

        public Criteria andAttractionDetailNotIn(List<String> values) {
            addCriterion("attraction_detail not in", values, "attractionDetail");
            return (Criteria) this;
        }

        public Criteria andAttractionDetailBetween(String value1, String value2) {
            addCriterion("attraction_detail between", value1, value2, "attractionDetail");
            return (Criteria) this;
        }

        public Criteria andAttractionDetailNotBetween(String value1, String value2) {
            addCriterion("attraction_detail not between", value1, value2, "attractionDetail");
            return (Criteria) this;
        }

        public Criteria andAttractionOpenTimeIsNull() {
            addCriterion("attraction_open_time is null");
            return (Criteria) this;
        }

        public Criteria andAttractionOpenTimeIsNotNull() {
            addCriterion("attraction_open_time is not null");
            return (Criteria) this;
        }

        public Criteria andAttractionOpenTimeEqualTo(String value) {
            addCriterion("attraction_open_time =", value, "attractionOpenTime");
            return (Criteria) this;
        }

        public Criteria andAttractionOpenTimeNotEqualTo(String value) {
            addCriterion("attraction_open_time <>", value, "attractionOpenTime");
            return (Criteria) this;
        }

        public Criteria andAttractionOpenTimeGreaterThan(String value) {
            addCriterion("attraction_open_time >", value, "attractionOpenTime");
            return (Criteria) this;
        }

        public Criteria andAttractionOpenTimeGreaterThanOrEqualTo(String value) {
            addCriterion("attraction_open_time >=", value, "attractionOpenTime");
            return (Criteria) this;
        }

        public Criteria andAttractionOpenTimeLessThan(String value) {
            addCriterion("attraction_open_time <", value, "attractionOpenTime");
            return (Criteria) this;
        }

        public Criteria andAttractionOpenTimeLessThanOrEqualTo(String value) {
            addCriterion("attraction_open_time <=", value, "attractionOpenTime");
            return (Criteria) this;
        }

        public Criteria andAttractionOpenTimeLike(String value) {
            addCriterion("attraction_open_time like", value, "attractionOpenTime");
            return (Criteria) this;
        }

        public Criteria andAttractionOpenTimeNotLike(String value) {
            addCriterion("attraction_open_time not like", value, "attractionOpenTime");
            return (Criteria) this;
        }

        public Criteria andAttractionOpenTimeIn(List<String> values) {
            addCriterion("attraction_open_time in", values, "attractionOpenTime");
            return (Criteria) this;
        }

        public Criteria andAttractionOpenTimeNotIn(List<String> values) {
            addCriterion("attraction_open_time not in", values, "attractionOpenTime");
            return (Criteria) this;
        }

        public Criteria andAttractionOpenTimeBetween(String value1, String value2) {
            addCriterion("attraction_open_time between", value1, value2, "attractionOpenTime");
            return (Criteria) this;
        }

        public Criteria andAttractionOpenTimeNotBetween(String value1, String value2) {
            addCriterion("attraction_open_time not between", value1, value2, "attractionOpenTime");
            return (Criteria) this;
        }

        public Criteria andAttractionEndTimeIsNull() {
            addCriterion("attraction_end_time is null");
            return (Criteria) this;
        }

        public Criteria andAttractionEndTimeIsNotNull() {
            addCriterion("attraction_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andAttractionEndTimeEqualTo(String value) {
            addCriterion("attraction_end_time =", value, "attractionEndTime");
            return (Criteria) this;
        }

        public Criteria andAttractionEndTimeNotEqualTo(String value) {
            addCriterion("attraction_end_time <>", value, "attractionEndTime");
            return (Criteria) this;
        }

        public Criteria andAttractionEndTimeGreaterThan(String value) {
            addCriterion("attraction_end_time >", value, "attractionEndTime");
            return (Criteria) this;
        }

        public Criteria andAttractionEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("attraction_end_time >=", value, "attractionEndTime");
            return (Criteria) this;
        }

        public Criteria andAttractionEndTimeLessThan(String value) {
            addCriterion("attraction_end_time <", value, "attractionEndTime");
            return (Criteria) this;
        }

        public Criteria andAttractionEndTimeLessThanOrEqualTo(String value) {
            addCriterion("attraction_end_time <=", value, "attractionEndTime");
            return (Criteria) this;
        }

        public Criteria andAttractionEndTimeLike(String value) {
            addCriterion("attraction_end_time like", value, "attractionEndTime");
            return (Criteria) this;
        }

        public Criteria andAttractionEndTimeNotLike(String value) {
            addCriterion("attraction_end_time not like", value, "attractionEndTime");
            return (Criteria) this;
        }

        public Criteria andAttractionEndTimeIn(List<String> values) {
            addCriterion("attraction_end_time in", values, "attractionEndTime");
            return (Criteria) this;
        }

        public Criteria andAttractionEndTimeNotIn(List<String> values) {
            addCriterion("attraction_end_time not in", values, "attractionEndTime");
            return (Criteria) this;
        }

        public Criteria andAttractionEndTimeBetween(String value1, String value2) {
            addCriterion("attraction_end_time between", value1, value2, "attractionEndTime");
            return (Criteria) this;
        }

        public Criteria andAttractionEndTimeNotBetween(String value1, String value2) {
            addCriterion("attraction_end_time not between", value1, value2, "attractionEndTime");
            return (Criteria) this;
        }

        public Criteria andAttractionImgIsNull() {
            addCriterion("attraction_img is null");
            return (Criteria) this;
        }

        public Criteria andAttractionImgIsNotNull() {
            addCriterion("attraction_img is not null");
            return (Criteria) this;
        }

        public Criteria andAttractionImgEqualTo(String value) {
            addCriterion("attraction_img =", value, "attractionImg");
            return (Criteria) this;
        }

        public Criteria andAttractionImgNotEqualTo(String value) {
            addCriterion("attraction_img <>", value, "attractionImg");
            return (Criteria) this;
        }

        public Criteria andAttractionImgGreaterThan(String value) {
            addCriterion("attraction_img >", value, "attractionImg");
            return (Criteria) this;
        }

        public Criteria andAttractionImgGreaterThanOrEqualTo(String value) {
            addCriterion("attraction_img >=", value, "attractionImg");
            return (Criteria) this;
        }

        public Criteria andAttractionImgLessThan(String value) {
            addCriterion("attraction_img <", value, "attractionImg");
            return (Criteria) this;
        }

        public Criteria andAttractionImgLessThanOrEqualTo(String value) {
            addCriterion("attraction_img <=", value, "attractionImg");
            return (Criteria) this;
        }

        public Criteria andAttractionImgLike(String value) {
            addCriterion("attraction_img like", value, "attractionImg");
            return (Criteria) this;
        }

        public Criteria andAttractionImgNotLike(String value) {
            addCriterion("attraction_img not like", value, "attractionImg");
            return (Criteria) this;
        }

        public Criteria andAttractionImgIn(List<String> values) {
            addCriterion("attraction_img in", values, "attractionImg");
            return (Criteria) this;
        }

        public Criteria andAttractionImgNotIn(List<String> values) {
            addCriterion("attraction_img not in", values, "attractionImg");
            return (Criteria) this;
        }

        public Criteria andAttractionImgBetween(String value1, String value2) {
            addCriterion("attraction_img between", value1, value2, "attractionImg");
            return (Criteria) this;
        }

        public Criteria andAttractionImgNotBetween(String value1, String value2) {
            addCriterion("attraction_img not between", value1, value2, "attractionImg");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
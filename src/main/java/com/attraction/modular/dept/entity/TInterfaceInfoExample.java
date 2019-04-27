package com.attraction.modular.dept.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TInterfaceInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TInterfaceInfoExample() {
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

        public Criteria andInterfaceIdIsNull() {
            addCriterion("interface_id is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdIsNotNull() {
            addCriterion("interface_id is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdEqualTo(Integer value) {
            addCriterion("interface_id =", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdNotEqualTo(Integer value) {
            addCriterion("interface_id <>", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdGreaterThan(Integer value) {
            addCriterion("interface_id >", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("interface_id >=", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdLessThan(Integer value) {
            addCriterion("interface_id <", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdLessThanOrEqualTo(Integer value) {
            addCriterion("interface_id <=", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdIn(List<Integer> values) {
            addCriterion("interface_id in", values, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdNotIn(List<Integer> values) {
            addCriterion("interface_id not in", values, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdBetween(Integer value1, Integer value2) {
            addCriterion("interface_id between", value1, value2, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("interface_id not between", value1, value2, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameIsNull() {
            addCriterion("interface_name is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameIsNotNull() {
            addCriterion("interface_name is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameEqualTo(String value) {
            addCriterion("interface_name =", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotEqualTo(String value) {
            addCriterion("interface_name <>", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameGreaterThan(String value) {
            addCriterion("interface_name >", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameGreaterThanOrEqualTo(String value) {
            addCriterion("interface_name >=", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameLessThan(String value) {
            addCriterion("interface_name <", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameLessThanOrEqualTo(String value) {
            addCriterion("interface_name <=", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameLike(String value) {
            addCriterion("interface_name like", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotLike(String value) {
            addCriterion("interface_name not like", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameIn(List<String> values) {
            addCriterion("interface_name in", values, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotIn(List<String> values) {
            addCriterion("interface_name not in", values, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameBetween(String value1, String value2) {
            addCriterion("interface_name between", value1, value2, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotBetween(String value1, String value2) {
            addCriterion("interface_name not between", value1, value2, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceContentIsNull() {
            addCriterion("interface_content is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceContentIsNotNull() {
            addCriterion("interface_content is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceContentEqualTo(String value) {
            addCriterion("interface_content =", value, "interfaceContent");
            return (Criteria) this;
        }

        public Criteria andInterfaceContentNotEqualTo(String value) {
            addCriterion("interface_content <>", value, "interfaceContent");
            return (Criteria) this;
        }

        public Criteria andInterfaceContentGreaterThan(String value) {
            addCriterion("interface_content >", value, "interfaceContent");
            return (Criteria) this;
        }

        public Criteria andInterfaceContentGreaterThanOrEqualTo(String value) {
            addCriterion("interface_content >=", value, "interfaceContent");
            return (Criteria) this;
        }

        public Criteria andInterfaceContentLessThan(String value) {
            addCriterion("interface_content <", value, "interfaceContent");
            return (Criteria) this;
        }

        public Criteria andInterfaceContentLessThanOrEqualTo(String value) {
            addCriterion("interface_content <=", value, "interfaceContent");
            return (Criteria) this;
        }

        public Criteria andInterfaceContentLike(String value) {
            addCriterion("interface_content like", value, "interfaceContent");
            return (Criteria) this;
        }

        public Criteria andInterfaceContentNotLike(String value) {
            addCriterion("interface_content not like", value, "interfaceContent");
            return (Criteria) this;
        }

        public Criteria andInterfaceContentIn(List<String> values) {
            addCriterion("interface_content in", values, "interfaceContent");
            return (Criteria) this;
        }

        public Criteria andInterfaceContentNotIn(List<String> values) {
            addCriterion("interface_content not in", values, "interfaceContent");
            return (Criteria) this;
        }

        public Criteria andInterfaceContentBetween(String value1, String value2) {
            addCriterion("interface_content between", value1, value2, "interfaceContent");
            return (Criteria) this;
        }

        public Criteria andInterfaceContentNotBetween(String value1, String value2) {
            addCriterion("interface_content not between", value1, value2, "interfaceContent");
            return (Criteria) this;
        }

        public Criteria andInterfaceProviderIsNull() {
            addCriterion("interface_provider is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceProviderIsNotNull() {
            addCriterion("interface_provider is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceProviderEqualTo(String value) {
            addCriterion("interface_provider =", value, "interfaceProvider");
            return (Criteria) this;
        }

        public Criteria andInterfaceProviderNotEqualTo(String value) {
            addCriterion("interface_provider <>", value, "interfaceProvider");
            return (Criteria) this;
        }

        public Criteria andInterfaceProviderGreaterThan(String value) {
            addCriterion("interface_provider >", value, "interfaceProvider");
            return (Criteria) this;
        }

        public Criteria andInterfaceProviderGreaterThanOrEqualTo(String value) {
            addCriterion("interface_provider >=", value, "interfaceProvider");
            return (Criteria) this;
        }

        public Criteria andInterfaceProviderLessThan(String value) {
            addCriterion("interface_provider <", value, "interfaceProvider");
            return (Criteria) this;
        }

        public Criteria andInterfaceProviderLessThanOrEqualTo(String value) {
            addCriterion("interface_provider <=", value, "interfaceProvider");
            return (Criteria) this;
        }

        public Criteria andInterfaceProviderLike(String value) {
            addCriterion("interface_provider like", value, "interfaceProvider");
            return (Criteria) this;
        }

        public Criteria andInterfaceProviderNotLike(String value) {
            addCriterion("interface_provider not like", value, "interfaceProvider");
            return (Criteria) this;
        }

        public Criteria andInterfaceProviderIn(List<String> values) {
            addCriterion("interface_provider in", values, "interfaceProvider");
            return (Criteria) this;
        }

        public Criteria andInterfaceProviderNotIn(List<String> values) {
            addCriterion("interface_provider not in", values, "interfaceProvider");
            return (Criteria) this;
        }

        public Criteria andInterfaceProviderBetween(String value1, String value2) {
            addCriterion("interface_provider between", value1, value2, "interfaceProvider");
            return (Criteria) this;
        }

        public Criteria andInterfaceProviderNotBetween(String value1, String value2) {
            addCriterion("interface_provider not between", value1, value2, "interfaceProvider");
            return (Criteria) this;
        }

        public Criteria andInterfaceConsumerIsNull() {
            addCriterion("interface_consumer is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceConsumerIsNotNull() {
            addCriterion("interface_consumer is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceConsumerEqualTo(String value) {
            addCriterion("interface_consumer =", value, "interfaceConsumer");
            return (Criteria) this;
        }

        public Criteria andInterfaceConsumerNotEqualTo(String value) {
            addCriterion("interface_consumer <>", value, "interfaceConsumer");
            return (Criteria) this;
        }

        public Criteria andInterfaceConsumerGreaterThan(String value) {
            addCriterion("interface_consumer >", value, "interfaceConsumer");
            return (Criteria) this;
        }

        public Criteria andInterfaceConsumerGreaterThanOrEqualTo(String value) {
            addCriterion("interface_consumer >=", value, "interfaceConsumer");
            return (Criteria) this;
        }

        public Criteria andInterfaceConsumerLessThan(String value) {
            addCriterion("interface_consumer <", value, "interfaceConsumer");
            return (Criteria) this;
        }

        public Criteria andInterfaceConsumerLessThanOrEqualTo(String value) {
            addCriterion("interface_consumer <=", value, "interfaceConsumer");
            return (Criteria) this;
        }

        public Criteria andInterfaceConsumerLike(String value) {
            addCriterion("interface_consumer like", value, "interfaceConsumer");
            return (Criteria) this;
        }

        public Criteria andInterfaceConsumerNotLike(String value) {
            addCriterion("interface_consumer not like", value, "interfaceConsumer");
            return (Criteria) this;
        }

        public Criteria andInterfaceConsumerIn(List<String> values) {
            addCriterion("interface_consumer in", values, "interfaceConsumer");
            return (Criteria) this;
        }

        public Criteria andInterfaceConsumerNotIn(List<String> values) {
            addCriterion("interface_consumer not in", values, "interfaceConsumer");
            return (Criteria) this;
        }

        public Criteria andInterfaceConsumerBetween(String value1, String value2) {
            addCriterion("interface_consumer between", value1, value2, "interfaceConsumer");
            return (Criteria) this;
        }

        public Criteria andInterfaceConsumerNotBetween(String value1, String value2) {
            addCriterion("interface_consumer not between", value1, value2, "interfaceConsumer");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeIsNull() {
            addCriterion("interface_type is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeIsNotNull() {
            addCriterion("interface_type is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeEqualTo(String value) {
            addCriterion("interface_type =", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeNotEqualTo(String value) {
            addCriterion("interface_type <>", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeGreaterThan(String value) {
            addCriterion("interface_type >", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("interface_type >=", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeLessThan(String value) {
            addCriterion("interface_type <", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeLessThanOrEqualTo(String value) {
            addCriterion("interface_type <=", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeLike(String value) {
            addCriterion("interface_type like", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeNotLike(String value) {
            addCriterion("interface_type not like", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeIn(List<String> values) {
            addCriterion("interface_type in", values, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeNotIn(List<String> values) {
            addCriterion("interface_type not in", values, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeBetween(String value1, String value2) {
            addCriterion("interface_type between", value1, value2, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeNotBetween(String value1, String value2) {
            addCriterion("interface_type not between", value1, value2, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andSysNodeIdIsNull() {
            addCriterion("sys_node_id is null");
            return (Criteria) this;
        }

        public Criteria andSysNodeIdIsNotNull() {
            addCriterion("sys_node_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysNodeIdEqualTo(Integer value) {
            addCriterion("sys_node_id =", value, "sysNodeId");
            return (Criteria) this;
        }

        public Criteria andSysNodeIdNotEqualTo(Integer value) {
            addCriterion("sys_node_id <>", value, "sysNodeId");
            return (Criteria) this;
        }

        public Criteria andSysNodeIdGreaterThan(Integer value) {
            addCriterion("sys_node_id >", value, "sysNodeId");
            return (Criteria) this;
        }

        public Criteria andSysNodeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_node_id >=", value, "sysNodeId");
            return (Criteria) this;
        }

        public Criteria andSysNodeIdLessThan(Integer value) {
            addCriterion("sys_node_id <", value, "sysNodeId");
            return (Criteria) this;
        }

        public Criteria andSysNodeIdLessThanOrEqualTo(Integer value) {
            addCriterion("sys_node_id <=", value, "sysNodeId");
            return (Criteria) this;
        }

        public Criteria andSysNodeIdIn(List<Integer> values) {
            addCriterion("sys_node_id in", values, "sysNodeId");
            return (Criteria) this;
        }

        public Criteria andSysNodeIdNotIn(List<Integer> values) {
            addCriterion("sys_node_id not in", values, "sysNodeId");
            return (Criteria) this;
        }

        public Criteria andSysNodeIdBetween(Integer value1, Integer value2) {
            addCriterion("sys_node_id between", value1, value2, "sysNodeId");
            return (Criteria) this;
        }

        public Criteria andSysNodeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_node_id not between", value1, value2, "sysNodeId");
            return (Criteria) this;
        }

        public Criteria andReqUrlIsNull() {
            addCriterion("req_url is null");
            return (Criteria) this;
        }

        public Criteria andReqUrlIsNotNull() {
            addCriterion("req_url is not null");
            return (Criteria) this;
        }

        public Criteria andReqUrlEqualTo(String value) {
            addCriterion("req_url =", value, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqUrlNotEqualTo(String value) {
            addCriterion("req_url <>", value, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqUrlGreaterThan(String value) {
            addCriterion("req_url >", value, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqUrlGreaterThanOrEqualTo(String value) {
            addCriterion("req_url >=", value, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqUrlLessThan(String value) {
            addCriterion("req_url <", value, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqUrlLessThanOrEqualTo(String value) {
            addCriterion("req_url <=", value, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqUrlLike(String value) {
            addCriterion("req_url like", value, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqUrlNotLike(String value) {
            addCriterion("req_url not like", value, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqUrlIn(List<String> values) {
            addCriterion("req_url in", values, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqUrlNotIn(List<String> values) {
            addCriterion("req_url not in", values, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqUrlBetween(String value1, String value2) {
            addCriterion("req_url between", value1, value2, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqUrlNotBetween(String value1, String value2) {
            addCriterion("req_url not between", value1, value2, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqClassIsNull() {
            addCriterion("req_class is null");
            return (Criteria) this;
        }

        public Criteria andReqClassIsNotNull() {
            addCriterion("req_class is not null");
            return (Criteria) this;
        }

        public Criteria andReqClassEqualTo(String value) {
            addCriterion("req_class =", value, "reqClass");
            return (Criteria) this;
        }

        public Criteria andReqClassNotEqualTo(String value) {
            addCriterion("req_class <>", value, "reqClass");
            return (Criteria) this;
        }

        public Criteria andReqClassGreaterThan(String value) {
            addCriterion("req_class >", value, "reqClass");
            return (Criteria) this;
        }

        public Criteria andReqClassGreaterThanOrEqualTo(String value) {
            addCriterion("req_class >=", value, "reqClass");
            return (Criteria) this;
        }

        public Criteria andReqClassLessThan(String value) {
            addCriterion("req_class <", value, "reqClass");
            return (Criteria) this;
        }

        public Criteria andReqClassLessThanOrEqualTo(String value) {
            addCriterion("req_class <=", value, "reqClass");
            return (Criteria) this;
        }

        public Criteria andReqClassLike(String value) {
            addCriterion("req_class like", value, "reqClass");
            return (Criteria) this;
        }

        public Criteria andReqClassNotLike(String value) {
            addCriterion("req_class not like", value, "reqClass");
            return (Criteria) this;
        }

        public Criteria andReqClassIn(List<String> values) {
            addCriterion("req_class in", values, "reqClass");
            return (Criteria) this;
        }

        public Criteria andReqClassNotIn(List<String> values) {
            addCriterion("req_class not in", values, "reqClass");
            return (Criteria) this;
        }

        public Criteria andReqClassBetween(String value1, String value2) {
            addCriterion("req_class between", value1, value2, "reqClass");
            return (Criteria) this;
        }

        public Criteria andReqClassNotBetween(String value1, String value2) {
            addCriterion("req_class not between", value1, value2, "reqClass");
            return (Criteria) this;
        }

        public Criteria andRetClassIsNull() {
            addCriterion("ret_class is null");
            return (Criteria) this;
        }

        public Criteria andRetClassIsNotNull() {
            addCriterion("ret_class is not null");
            return (Criteria) this;
        }

        public Criteria andRetClassEqualTo(String value) {
            addCriterion("ret_class =", value, "retClass");
            return (Criteria) this;
        }

        public Criteria andRetClassNotEqualTo(String value) {
            addCriterion("ret_class <>", value, "retClass");
            return (Criteria) this;
        }

        public Criteria andRetClassGreaterThan(String value) {
            addCriterion("ret_class >", value, "retClass");
            return (Criteria) this;
        }

        public Criteria andRetClassGreaterThanOrEqualTo(String value) {
            addCriterion("ret_class >=", value, "retClass");
            return (Criteria) this;
        }

        public Criteria andRetClassLessThan(String value) {
            addCriterion("ret_class <", value, "retClass");
            return (Criteria) this;
        }

        public Criteria andRetClassLessThanOrEqualTo(String value) {
            addCriterion("ret_class <=", value, "retClass");
            return (Criteria) this;
        }

        public Criteria andRetClassLike(String value) {
            addCriterion("ret_class like", value, "retClass");
            return (Criteria) this;
        }

        public Criteria andRetClassNotLike(String value) {
            addCriterion("ret_class not like", value, "retClass");
            return (Criteria) this;
        }

        public Criteria andRetClassIn(List<String> values) {
            addCriterion("ret_class in", values, "retClass");
            return (Criteria) this;
        }

        public Criteria andRetClassNotIn(List<String> values) {
            addCriterion("ret_class not in", values, "retClass");
            return (Criteria) this;
        }

        public Criteria andRetClassBetween(String value1, String value2) {
            addCriterion("ret_class between", value1, value2, "retClass");
            return (Criteria) this;
        }

        public Criteria andRetClassNotBetween(String value1, String value2) {
            addCriterion("ret_class not between", value1, value2, "retClass");
            return (Criteria) this;
        }

        public Criteria andReserve1IsNull() {
            addCriterion("reserve1 is null");
            return (Criteria) this;
        }

        public Criteria andReserve1IsNotNull() {
            addCriterion("reserve1 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve1EqualTo(Integer value) {
            addCriterion("reserve1 =", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotEqualTo(Integer value) {
            addCriterion("reserve1 <>", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1GreaterThan(Integer value) {
            addCriterion("reserve1 >", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1GreaterThanOrEqualTo(Integer value) {
            addCriterion("reserve1 >=", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1LessThan(Integer value) {
            addCriterion("reserve1 <", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1LessThanOrEqualTo(Integer value) {
            addCriterion("reserve1 <=", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1In(List<Integer> values) {
            addCriterion("reserve1 in", values, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotIn(List<Integer> values) {
            addCriterion("reserve1 not in", values, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1Between(Integer value1, Integer value2) {
            addCriterion("reserve1 between", value1, value2, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotBetween(Integer value1, Integer value2) {
            addCriterion("reserve1 not between", value1, value2, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve2IsNull() {
            addCriterion("reserve2 is null");
            return (Criteria) this;
        }

        public Criteria andReserve2IsNotNull() {
            addCriterion("reserve2 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve2EqualTo(String value) {
            addCriterion("reserve2 =", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotEqualTo(String value) {
            addCriterion("reserve2 <>", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2GreaterThan(String value) {
            addCriterion("reserve2 >", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2GreaterThanOrEqualTo(String value) {
            addCriterion("reserve2 >=", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2LessThan(String value) {
            addCriterion("reserve2 <", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2LessThanOrEqualTo(String value) {
            addCriterion("reserve2 <=", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2Like(String value) {
            addCriterion("reserve2 like", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotLike(String value) {
            addCriterion("reserve2 not like", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2In(List<String> values) {
            addCriterion("reserve2 in", values, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotIn(List<String> values) {
            addCriterion("reserve2 not in", values, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2Between(String value1, String value2) {
            addCriterion("reserve2 between", value1, value2, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotBetween(String value1, String value2) {
            addCriterion("reserve2 not between", value1, value2, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve3IsNull() {
            addCriterion("reserve3 is null");
            return (Criteria) this;
        }

        public Criteria andReserve3IsNotNull() {
            addCriterion("reserve3 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve3EqualTo(String value) {
            addCriterion("reserve3 =", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotEqualTo(String value) {
            addCriterion("reserve3 <>", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3GreaterThan(String value) {
            addCriterion("reserve3 >", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3GreaterThanOrEqualTo(String value) {
            addCriterion("reserve3 >=", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3LessThan(String value) {
            addCriterion("reserve3 <", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3LessThanOrEqualTo(String value) {
            addCriterion("reserve3 <=", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3Like(String value) {
            addCriterion("reserve3 like", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotLike(String value) {
            addCriterion("reserve3 not like", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3In(List<String> values) {
            addCriterion("reserve3 in", values, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotIn(List<String> values) {
            addCriterion("reserve3 not in", values, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3Between(String value1, String value2) {
            addCriterion("reserve3 between", value1, value2, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotBetween(String value1, String value2) {
            addCriterion("reserve3 not between", value1, value2, "reserve3");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andIsValidIsNull() {
            addCriterion("is_valid is null");
            return (Criteria) this;
        }

        public Criteria andIsValidIsNotNull() {
            addCriterion("is_valid is not null");
            return (Criteria) this;
        }

        public Criteria andIsValidEqualTo(String value) {
            addCriterion("is_valid =", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotEqualTo(String value) {
            addCriterion("is_valid <>", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidGreaterThan(String value) {
            addCriterion("is_valid >", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidGreaterThanOrEqualTo(String value) {
            addCriterion("is_valid >=", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLessThan(String value) {
            addCriterion("is_valid <", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLessThanOrEqualTo(String value) {
            addCriterion("is_valid <=", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLike(String value) {
            addCriterion("is_valid like", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotLike(String value) {
            addCriterion("is_valid not like", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidIn(List<String> values) {
            addCriterion("is_valid in", values, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotIn(List<String> values) {
            addCriterion("is_valid not in", values, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidBetween(String value1, String value2) {
            addCriterion("is_valid between", value1, value2, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotBetween(String value1, String value2) {
            addCriterion("is_valid not between", value1, value2, "isValid");
            return (Criteria) this;
        }

        public Criteria andRetDataModelIsNull() {
            addCriterion("ret_data_model is null");
            return (Criteria) this;
        }

        public Criteria andRetDataModelIsNotNull() {
            addCriterion("ret_data_model is not null");
            return (Criteria) this;
        }

        public Criteria andRetDataModelEqualTo(String value) {
            addCriterion("ret_data_model =", value, "retDataModel");
            return (Criteria) this;
        }

        public Criteria andRetDataModelNotEqualTo(String value) {
            addCriterion("ret_data_model <>", value, "retDataModel");
            return (Criteria) this;
        }

        public Criteria andRetDataModelGreaterThan(String value) {
            addCriterion("ret_data_model >", value, "retDataModel");
            return (Criteria) this;
        }

        public Criteria andRetDataModelGreaterThanOrEqualTo(String value) {
            addCriterion("ret_data_model >=", value, "retDataModel");
            return (Criteria) this;
        }

        public Criteria andRetDataModelLessThan(String value) {
            addCriterion("ret_data_model <", value, "retDataModel");
            return (Criteria) this;
        }

        public Criteria andRetDataModelLessThanOrEqualTo(String value) {
            addCriterion("ret_data_model <=", value, "retDataModel");
            return (Criteria) this;
        }

        public Criteria andRetDataModelLike(String value) {
            addCriterion("ret_data_model like", value, "retDataModel");
            return (Criteria) this;
        }

        public Criteria andRetDataModelNotLike(String value) {
            addCriterion("ret_data_model not like", value, "retDataModel");
            return (Criteria) this;
        }

        public Criteria andRetDataModelIn(List<String> values) {
            addCriterion("ret_data_model in", values, "retDataModel");
            return (Criteria) this;
        }

        public Criteria andRetDataModelNotIn(List<String> values) {
            addCriterion("ret_data_model not in", values, "retDataModel");
            return (Criteria) this;
        }

        public Criteria andRetDataModelBetween(String value1, String value2) {
            addCriterion("ret_data_model between", value1, value2, "retDataModel");
            return (Criteria) this;
        }

        public Criteria andRetDataModelNotBetween(String value1, String value2) {
            addCriterion("ret_data_model not between", value1, value2, "retDataModel");
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
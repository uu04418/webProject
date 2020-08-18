package com.webproject.entity;

import java.util.ArrayList;
import java.util.List;

public class HouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HouseExample() {
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

        public Criteria andHouseidIsNull() {
            addCriterion("houseid is null");
            return (Criteria) this;
        }

        public Criteria andHouseidIsNotNull() {
            addCriterion("houseid is not null");
            return (Criteria) this;
        }

        public Criteria andHouseidEqualTo(String value) {
            addCriterion("houseid =", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidNotEqualTo(String value) {
            addCriterion("houseid <>", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidGreaterThan(String value) {
            addCriterion("houseid >", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidGreaterThanOrEqualTo(String value) {
            addCriterion("houseid >=", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidLessThan(String value) {
            addCriterion("houseid <", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidLessThanOrEqualTo(String value) {
            addCriterion("houseid <=", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidLike(String value) {
            addCriterion("houseid like", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidNotLike(String value) {
            addCriterion("houseid not like", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidIn(List<String> values) {
            addCriterion("houseid in", values, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidNotIn(List<String> values) {
            addCriterion("houseid not in", values, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidBetween(String value1, String value2) {
            addCriterion("houseid between", value1, value2, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidNotBetween(String value1, String value2) {
            addCriterion("houseid not between", value1, value2, "houseid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSinglewaterIsNull() {
            addCriterion("singlewater is null");
            return (Criteria) this;
        }

        public Criteria andSinglewaterIsNotNull() {
            addCriterion("singlewater is not null");
            return (Criteria) this;
        }

        public Criteria andSinglewaterEqualTo(Double value) {
            addCriterion("singlewater =", value, "singlewater");
            return (Criteria) this;
        }

        public Criteria andSinglewaterNotEqualTo(Double value) {
            addCriterion("singlewater <>", value, "singlewater");
            return (Criteria) this;
        }

        public Criteria andSinglewaterGreaterThan(Double value) {
            addCriterion("singlewater >", value, "singlewater");
            return (Criteria) this;
        }

        public Criteria andSinglewaterGreaterThanOrEqualTo(Double value) {
            addCriterion("singlewater >=", value, "singlewater");
            return (Criteria) this;
        }

        public Criteria andSinglewaterLessThan(Double value) {
            addCriterion("singlewater <", value, "singlewater");
            return (Criteria) this;
        }

        public Criteria andSinglewaterLessThanOrEqualTo(Double value) {
            addCriterion("singlewater <=", value, "singlewater");
            return (Criteria) this;
        }

        public Criteria andSinglewaterIn(List<Double> values) {
            addCriterion("singlewater in", values, "singlewater");
            return (Criteria) this;
        }

        public Criteria andSinglewaterNotIn(List<Double> values) {
            addCriterion("singlewater not in", values, "singlewater");
            return (Criteria) this;
        }

        public Criteria andSinglewaterBetween(Double value1, Double value2) {
            addCriterion("singlewater between", value1, value2, "singlewater");
            return (Criteria) this;
        }

        public Criteria andSinglewaterNotBetween(Double value1, Double value2) {
            addCriterion("singlewater not between", value1, value2, "singlewater");
            return (Criteria) this;
        }

        public Criteria andSinglelightIsNull() {
            addCriterion("singlelight is null");
            return (Criteria) this;
        }

        public Criteria andSinglelightIsNotNull() {
            addCriterion("singlelight is not null");
            return (Criteria) this;
        }

        public Criteria andSinglelightEqualTo(Double value) {
            addCriterion("singlelight =", value, "singlelight");
            return (Criteria) this;
        }

        public Criteria andSinglelightNotEqualTo(Double value) {
            addCriterion("singlelight <>", value, "singlelight");
            return (Criteria) this;
        }

        public Criteria andSinglelightGreaterThan(Double value) {
            addCriterion("singlelight >", value, "singlelight");
            return (Criteria) this;
        }

        public Criteria andSinglelightGreaterThanOrEqualTo(Double value) {
            addCriterion("singlelight >=", value, "singlelight");
            return (Criteria) this;
        }

        public Criteria andSinglelightLessThan(Double value) {
            addCriterion("singlelight <", value, "singlelight");
            return (Criteria) this;
        }

        public Criteria andSinglelightLessThanOrEqualTo(Double value) {
            addCriterion("singlelight <=", value, "singlelight");
            return (Criteria) this;
        }

        public Criteria andSinglelightIn(List<Double> values) {
            addCriterion("singlelight in", values, "singlelight");
            return (Criteria) this;
        }

        public Criteria andSinglelightNotIn(List<Double> values) {
            addCriterion("singlelight not in", values, "singlelight");
            return (Criteria) this;
        }

        public Criteria andSinglelightBetween(Double value1, Double value2) {
            addCriterion("singlelight between", value1, value2, "singlelight");
            return (Criteria) this;
        }

        public Criteria andSinglelightNotBetween(Double value1, Double value2) {
            addCriterion("singlelight not between", value1, value2, "singlelight");
            return (Criteria) this;
        }

        public Criteria andBuildingidIsNull() {
            addCriterion("buildingid is null");
            return (Criteria) this;
        }

        public Criteria andBuildingidIsNotNull() {
            addCriterion("buildingid is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingidEqualTo(String value) {
            addCriterion("buildingid =", value, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidNotEqualTo(String value) {
            addCriterion("buildingid <>", value, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidGreaterThan(String value) {
            addCriterion("buildingid >", value, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidGreaterThanOrEqualTo(String value) {
            addCriterion("buildingid >=", value, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidLessThan(String value) {
            addCriterion("buildingid <", value, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidLessThanOrEqualTo(String value) {
            addCriterion("buildingid <=", value, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidLike(String value) {
            addCriterion("buildingid like", value, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidNotLike(String value) {
            addCriterion("buildingid not like", value, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidIn(List<String> values) {
            addCriterion("buildingid in", values, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidNotIn(List<String> values) {
            addCriterion("buildingid not in", values, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidBetween(String value1, String value2) {
            addCriterion("buildingid between", value1, value2, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidNotBetween(String value1, String value2) {
            addCriterion("buildingid not between", value1, value2, "buildingid");
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
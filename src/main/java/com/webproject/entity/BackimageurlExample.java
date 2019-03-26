package com.webproject.entity;

import java.util.ArrayList;
import java.util.List;

public class BackimageurlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BackimageurlExample() {
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

        public Criteria andImageidIsNull() {
            addCriterion("imageid is null");
            return (Criteria) this;
        }

        public Criteria andImageidIsNotNull() {
            addCriterion("imageid is not null");
            return (Criteria) this;
        }

        public Criteria andImageidEqualTo(Long value) {
            addCriterion("imageid =", value, "imageid");
            return (Criteria) this;
        }

        public Criteria andImageidNotEqualTo(Long value) {
            addCriterion("imageid <>", value, "imageid");
            return (Criteria) this;
        }

        public Criteria andImageidGreaterThan(Long value) {
            addCriterion("imageid >", value, "imageid");
            return (Criteria) this;
        }

        public Criteria andImageidGreaterThanOrEqualTo(Long value) {
            addCriterion("imageid >=", value, "imageid");
            return (Criteria) this;
        }

        public Criteria andImageidLessThan(Long value) {
            addCriterion("imageid <", value, "imageid");
            return (Criteria) this;
        }

        public Criteria andImageidLessThanOrEqualTo(Long value) {
            addCriterion("imageid <=", value, "imageid");
            return (Criteria) this;
        }

        public Criteria andImageidIn(List<Long> values) {
            addCriterion("imageid in", values, "imageid");
            return (Criteria) this;
        }

        public Criteria andImageidNotIn(List<Long> values) {
            addCriterion("imageid not in", values, "imageid");
            return (Criteria) this;
        }

        public Criteria andImageidBetween(Long value1, Long value2) {
            addCriterion("imageid between", value1, value2, "imageid");
            return (Criteria) this;
        }

        public Criteria andImageidNotBetween(Long value1, Long value2) {
            addCriterion("imageid not between", value1, value2, "imageid");
            return (Criteria) this;
        }

        public Criteria andIamgenameIsNull() {
            addCriterion("iamgename is null");
            return (Criteria) this;
        }

        public Criteria andIamgenameIsNotNull() {
            addCriterion("iamgename is not null");
            return (Criteria) this;
        }

        public Criteria andIamgenameEqualTo(String value) {
            addCriterion("iamgename =", value, "iamgename");
            return (Criteria) this;
        }

        public Criteria andIamgenameNotEqualTo(String value) {
            addCriterion("iamgename <>", value, "iamgename");
            return (Criteria) this;
        }

        public Criteria andIamgenameGreaterThan(String value) {
            addCriterion("iamgename >", value, "iamgename");
            return (Criteria) this;
        }

        public Criteria andIamgenameGreaterThanOrEqualTo(String value) {
            addCriterion("iamgename >=", value, "iamgename");
            return (Criteria) this;
        }

        public Criteria andIamgenameLessThan(String value) {
            addCriterion("iamgename <", value, "iamgename");
            return (Criteria) this;
        }

        public Criteria andIamgenameLessThanOrEqualTo(String value) {
            addCriterion("iamgename <=", value, "iamgename");
            return (Criteria) this;
        }

        public Criteria andIamgenameLike(String value) {
            addCriterion("iamgename like", value, "iamgename");
            return (Criteria) this;
        }

        public Criteria andIamgenameNotLike(String value) {
            addCriterion("iamgename not like", value, "iamgename");
            return (Criteria) this;
        }

        public Criteria andIamgenameIn(List<String> values) {
            addCriterion("iamgename in", values, "iamgename");
            return (Criteria) this;
        }

        public Criteria andIamgenameNotIn(List<String> values) {
            addCriterion("iamgename not in", values, "iamgename");
            return (Criteria) this;
        }

        public Criteria andIamgenameBetween(String value1, String value2) {
            addCriterion("iamgename between", value1, value2, "iamgename");
            return (Criteria) this;
        }

        public Criteria andIamgenameNotBetween(String value1, String value2) {
            addCriterion("iamgename not between", value1, value2, "iamgename");
            return (Criteria) this;
        }

        public Criteria andDescnameIsNull() {
            addCriterion("descname is null");
            return (Criteria) this;
        }

        public Criteria andDescnameIsNotNull() {
            addCriterion("descname is not null");
            return (Criteria) this;
        }

        public Criteria andDescnameEqualTo(String value) {
            addCriterion("descname =", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameNotEqualTo(String value) {
            addCriterion("descname <>", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameGreaterThan(String value) {
            addCriterion("descname >", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameGreaterThanOrEqualTo(String value) {
            addCriterion("descname >=", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameLessThan(String value) {
            addCriterion("descname <", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameLessThanOrEqualTo(String value) {
            addCriterion("descname <=", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameLike(String value) {
            addCriterion("descname like", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameNotLike(String value) {
            addCriterion("descname not like", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameIn(List<String> values) {
            addCriterion("descname in", values, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameNotIn(List<String> values) {
            addCriterion("descname not in", values, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameBetween(String value1, String value2) {
            addCriterion("descname between", value1, value2, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameNotBetween(String value1, String value2) {
            addCriterion("descname not between", value1, value2, "descname");
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
package com.webproject.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayexpertExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PayexpertExample() {
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

        public Criteria andPayexpertidIsNull() {
            addCriterion("payexpertid is null");
            return (Criteria) this;
        }

        public Criteria andPayexpertidIsNotNull() {
            addCriterion("payexpertid is not null");
            return (Criteria) this;
        }

        public Criteria andPayexpertidEqualTo(String value) {
            addCriterion("payexpertid =", value, "payexpertid");
            return (Criteria) this;
        }

        public Criteria andPayexpertidNotEqualTo(String value) {
            addCriterion("payexpertid <>", value, "payexpertid");
            return (Criteria) this;
        }

        public Criteria andPayexpertidGreaterThan(String value) {
            addCriterion("payexpertid >", value, "payexpertid");
            return (Criteria) this;
        }

        public Criteria andPayexpertidGreaterThanOrEqualTo(String value) {
            addCriterion("payexpertid >=", value, "payexpertid");
            return (Criteria) this;
        }

        public Criteria andPayexpertidLessThan(String value) {
            addCriterion("payexpertid <", value, "payexpertid");
            return (Criteria) this;
        }

        public Criteria andPayexpertidLessThanOrEqualTo(String value) {
            addCriterion("payexpertid <=", value, "payexpertid");
            return (Criteria) this;
        }

        public Criteria andPayexpertidLike(String value) {
            addCriterion("payexpertid like", value, "payexpertid");
            return (Criteria) this;
        }

        public Criteria andPayexpertidNotLike(String value) {
            addCriterion("payexpertid not like", value, "payexpertid");
            return (Criteria) this;
        }

        public Criteria andPayexpertidIn(List<String> values) {
            addCriterion("payexpertid in", values, "payexpertid");
            return (Criteria) this;
        }

        public Criteria andPayexpertidNotIn(List<String> values) {
            addCriterion("payexpertid not in", values, "payexpertid");
            return (Criteria) this;
        }

        public Criteria andPayexpertidBetween(String value1, String value2) {
            addCriterion("payexpertid between", value1, value2, "payexpertid");
            return (Criteria) this;
        }

        public Criteria andPayexpertidNotBetween(String value1, String value2) {
            addCriterion("payexpertid not between", value1, value2, "payexpertid");
            return (Criteria) this;
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

        public Criteria andPayexpertnameIsNull() {
            addCriterion("payexpertname is null");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameIsNotNull() {
            addCriterion("payexpertname is not null");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameEqualTo(String value) {
            addCriterion("payexpertname =", value, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameNotEqualTo(String value) {
            addCriterion("payexpertname <>", value, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameGreaterThan(String value) {
            addCriterion("payexpertname >", value, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameGreaterThanOrEqualTo(String value) {
            addCriterion("payexpertname >=", value, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameLessThan(String value) {
            addCriterion("payexpertname <", value, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameLessThanOrEqualTo(String value) {
            addCriterion("payexpertname <=", value, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameLike(String value) {
            addCriterion("payexpertname like", value, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameNotLike(String value) {
            addCriterion("payexpertname not like", value, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameIn(List<String> values) {
            addCriterion("payexpertname in", values, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameNotIn(List<String> values) {
            addCriterion("payexpertname not in", values, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameBetween(String value1, String value2) {
            addCriterion("payexpertname between", value1, value2, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameNotBetween(String value1, String value2) {
            addCriterion("payexpertname not between", value1, value2, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andStart_timeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStart_timeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStart_timeEqualTo(Date value) {
            addCriterion("start_time =", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeGreaterThan(Date value) {
            addCriterion("start_time >", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeLessThan(Date value) {
            addCriterion("start_time <", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeIn(List<Date> values) {
            addCriterion("start_time in", values, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "start_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEnd_timeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEnd_timeEqualTo(Date value) {
            addCriterion("end_time =", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeGreaterThan(Date value) {
            addCriterion("end_time >", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeLessThan(Date value) {
            addCriterion("end_time <", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeIn(List<Date> values) {
            addCriterion("end_time in", values, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "end_time");
            return (Criteria) this;
        }

        public Criteria andRealmoneryIsNull() {
            addCriterion("realmonery is null");
            return (Criteria) this;
        }

        public Criteria andRealmoneryIsNotNull() {
            addCriterion("realmonery is not null");
            return (Criteria) this;
        }

        public Criteria andRealmoneryEqualTo(Double value) {
            addCriterion("realmonery =", value, "realmonery");
            return (Criteria) this;
        }

        public Criteria andRealmoneryNotEqualTo(Double value) {
            addCriterion("realmonery <>", value, "realmonery");
            return (Criteria) this;
        }

        public Criteria andRealmoneryGreaterThan(Double value) {
            addCriterion("realmonery >", value, "realmonery");
            return (Criteria) this;
        }

        public Criteria andRealmoneryGreaterThanOrEqualTo(Double value) {
            addCriterion("realmonery >=", value, "realmonery");
            return (Criteria) this;
        }

        public Criteria andRealmoneryLessThan(Double value) {
            addCriterion("realmonery <", value, "realmonery");
            return (Criteria) this;
        }

        public Criteria andRealmoneryLessThanOrEqualTo(Double value) {
            addCriterion("realmonery <=", value, "realmonery");
            return (Criteria) this;
        }

        public Criteria andRealmoneryIn(List<Double> values) {
            addCriterion("realmonery in", values, "realmonery");
            return (Criteria) this;
        }

        public Criteria andRealmoneryNotIn(List<Double> values) {
            addCriterion("realmonery not in", values, "realmonery");
            return (Criteria) this;
        }

        public Criteria andRealmoneryBetween(Double value1, Double value2) {
            addCriterion("realmonery between", value1, value2, "realmonery");
            return (Criteria) this;
        }

        public Criteria andRealmoneryNotBetween(Double value1, Double value2) {
            addCriterion("realmonery not between", value1, value2, "realmonery");
            return (Criteria) this;
        }

        public Criteria andWaterstartIsNull() {
            addCriterion("waterstart is null");
            return (Criteria) this;
        }

        public Criteria andWaterstartIsNotNull() {
            addCriterion("waterstart is not null");
            return (Criteria) this;
        }

        public Criteria andWaterstartEqualTo(Double value) {
            addCriterion("waterstart =", value, "waterstart");
            return (Criteria) this;
        }

        public Criteria andWaterstartNotEqualTo(Double value) {
            addCriterion("waterstart <>", value, "waterstart");
            return (Criteria) this;
        }

        public Criteria andWaterstartGreaterThan(Double value) {
            addCriterion("waterstart >", value, "waterstart");
            return (Criteria) this;
        }

        public Criteria andWaterstartGreaterThanOrEqualTo(Double value) {
            addCriterion("waterstart >=", value, "waterstart");
            return (Criteria) this;
        }

        public Criteria andWaterstartLessThan(Double value) {
            addCriterion("waterstart <", value, "waterstart");
            return (Criteria) this;
        }

        public Criteria andWaterstartLessThanOrEqualTo(Double value) {
            addCriterion("waterstart <=", value, "waterstart");
            return (Criteria) this;
        }

        public Criteria andWaterstartIn(List<Double> values) {
            addCriterion("waterstart in", values, "waterstart");
            return (Criteria) this;
        }

        public Criteria andWaterstartNotIn(List<Double> values) {
            addCriterion("waterstart not in", values, "waterstart");
            return (Criteria) this;
        }

        public Criteria andWaterstartBetween(Double value1, Double value2) {
            addCriterion("waterstart between", value1, value2, "waterstart");
            return (Criteria) this;
        }

        public Criteria andWaterstartNotBetween(Double value1, Double value2) {
            addCriterion("waterstart not between", value1, value2, "waterstart");
            return (Criteria) this;
        }

        public Criteria andWaterendIsNull() {
            addCriterion("waterend is null");
            return (Criteria) this;
        }

        public Criteria andWaterendIsNotNull() {
            addCriterion("waterend is not null");
            return (Criteria) this;
        }

        public Criteria andWaterendEqualTo(Double value) {
            addCriterion("waterend =", value, "waterend");
            return (Criteria) this;
        }

        public Criteria andWaterendNotEqualTo(Double value) {
            addCriterion("waterend <>", value, "waterend");
            return (Criteria) this;
        }

        public Criteria andWaterendGreaterThan(Double value) {
            addCriterion("waterend >", value, "waterend");
            return (Criteria) this;
        }

        public Criteria andWaterendGreaterThanOrEqualTo(Double value) {
            addCriterion("waterend >=", value, "waterend");
            return (Criteria) this;
        }

        public Criteria andWaterendLessThan(Double value) {
            addCriterion("waterend <", value, "waterend");
            return (Criteria) this;
        }

        public Criteria andWaterendLessThanOrEqualTo(Double value) {
            addCriterion("waterend <=", value, "waterend");
            return (Criteria) this;
        }

        public Criteria andWaterendIn(List<Double> values) {
            addCriterion("waterend in", values, "waterend");
            return (Criteria) this;
        }

        public Criteria andWaterendNotIn(List<Double> values) {
            addCriterion("waterend not in", values, "waterend");
            return (Criteria) this;
        }

        public Criteria andWaterendBetween(Double value1, Double value2) {
            addCriterion("waterend between", value1, value2, "waterend");
            return (Criteria) this;
        }

        public Criteria andWaterendNotBetween(Double value1, Double value2) {
            addCriterion("waterend not between", value1, value2, "waterend");
            return (Criteria) this;
        }

        public Criteria andLightstartIsNull() {
            addCriterion("lightstart is null");
            return (Criteria) this;
        }

        public Criteria andLightstartIsNotNull() {
            addCriterion("lightstart is not null");
            return (Criteria) this;
        }

        public Criteria andLightstartEqualTo(Double value) {
            addCriterion("lightstart =", value, "lightstart");
            return (Criteria) this;
        }

        public Criteria andLightstartNotEqualTo(Double value) {
            addCriterion("lightstart <>", value, "lightstart");
            return (Criteria) this;
        }

        public Criteria andLightstartGreaterThan(Double value) {
            addCriterion("lightstart >", value, "lightstart");
            return (Criteria) this;
        }

        public Criteria andLightstartGreaterThanOrEqualTo(Double value) {
            addCriterion("lightstart >=", value, "lightstart");
            return (Criteria) this;
        }

        public Criteria andLightstartLessThan(Double value) {
            addCriterion("lightstart <", value, "lightstart");
            return (Criteria) this;
        }

        public Criteria andLightstartLessThanOrEqualTo(Double value) {
            addCriterion("lightstart <=", value, "lightstart");
            return (Criteria) this;
        }

        public Criteria andLightstartIn(List<Double> values) {
            addCriterion("lightstart in", values, "lightstart");
            return (Criteria) this;
        }

        public Criteria andLightstartNotIn(List<Double> values) {
            addCriterion("lightstart not in", values, "lightstart");
            return (Criteria) this;
        }

        public Criteria andLightstartBetween(Double value1, Double value2) {
            addCriterion("lightstart between", value1, value2, "lightstart");
            return (Criteria) this;
        }

        public Criteria andLightstartNotBetween(Double value1, Double value2) {
            addCriterion("lightstart not between", value1, value2, "lightstart");
            return (Criteria) this;
        }

        public Criteria andLightendIsNull() {
            addCriterion("lightend is null");
            return (Criteria) this;
        }

        public Criteria andLightendIsNotNull() {
            addCriterion("lightend is not null");
            return (Criteria) this;
        }

        public Criteria andLightendEqualTo(Double value) {
            addCriterion("lightend =", value, "lightend");
            return (Criteria) this;
        }

        public Criteria andLightendNotEqualTo(Double value) {
            addCriterion("lightend <>", value, "lightend");
            return (Criteria) this;
        }

        public Criteria andLightendGreaterThan(Double value) {
            addCriterion("lightend >", value, "lightend");
            return (Criteria) this;
        }

        public Criteria andLightendGreaterThanOrEqualTo(Double value) {
            addCriterion("lightend >=", value, "lightend");
            return (Criteria) this;
        }

        public Criteria andLightendLessThan(Double value) {
            addCriterion("lightend <", value, "lightend");
            return (Criteria) this;
        }

        public Criteria andLightendLessThanOrEqualTo(Double value) {
            addCriterion("lightend <=", value, "lightend");
            return (Criteria) this;
        }

        public Criteria andLightendIn(List<Double> values) {
            addCriterion("lightend in", values, "lightend");
            return (Criteria) this;
        }

        public Criteria andLightendNotIn(List<Double> values) {
            addCriterion("lightend not in", values, "lightend");
            return (Criteria) this;
        }

        public Criteria andLightendBetween(Double value1, Double value2) {
            addCriterion("lightend between", value1, value2, "lightend");
            return (Criteria) this;
        }

        public Criteria andLightendNotBetween(Double value1, Double value2) {
            addCriterion("lightend not between", value1, value2, "lightend");
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
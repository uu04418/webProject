package com.webproject.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MychartpanelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MychartpanelExample() {
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

        public Criteria andPanelidIsNull() {
            addCriterion("panelid is null");
            return (Criteria) this;
        }

        public Criteria andPanelidIsNotNull() {
            addCriterion("panelid is not null");
            return (Criteria) this;
        }

        public Criteria andPanelidEqualTo(Long value) {
            addCriterion("panelid =", value, "panelid");
            return (Criteria) this;
        }

        public Criteria andPanelidNotEqualTo(Long value) {
            addCriterion("panelid <>", value, "panelid");
            return (Criteria) this;
        }

        public Criteria andPanelidGreaterThan(Long value) {
            addCriterion("panelid >", value, "panelid");
            return (Criteria) this;
        }

        public Criteria andPanelidGreaterThanOrEqualTo(Long value) {
            addCriterion("panelid >=", value, "panelid");
            return (Criteria) this;
        }

        public Criteria andPanelidLessThan(Long value) {
            addCriterion("panelid <", value, "panelid");
            return (Criteria) this;
        }

        public Criteria andPanelidLessThanOrEqualTo(Long value) {
            addCriterion("panelid <=", value, "panelid");
            return (Criteria) this;
        }

        public Criteria andPanelidIn(List<Long> values) {
            addCriterion("panelid in", values, "panelid");
            return (Criteria) this;
        }

        public Criteria andPanelidNotIn(List<Long> values) {
            addCriterion("panelid not in", values, "panelid");
            return (Criteria) this;
        }

        public Criteria andPanelidBetween(Long value1, Long value2) {
            addCriterion("panelid between", value1, value2, "panelid");
            return (Criteria) this;
        }

        public Criteria andPanelidNotBetween(Long value1, Long value2) {
            addCriterion("panelid not between", value1, value2, "panelid");
            return (Criteria) this;
        }

        public Criteria andYearstringIsNull() {
            addCriterion("yearstring is null");
            return (Criteria) this;
        }

        public Criteria andYearstringIsNotNull() {
            addCriterion("yearstring is not null");
            return (Criteria) this;
        }

        public Criteria andYearstringEqualTo(String value) {
            addCriterion("yearstring =", value, "yearstring");
            return (Criteria) this;
        }

        public Criteria andYearstringNotEqualTo(String value) {
            addCriterion("yearstring <>", value, "yearstring");
            return (Criteria) this;
        }

        public Criteria andYearstringGreaterThan(String value) {
            addCriterion("yearstring >", value, "yearstring");
            return (Criteria) this;
        }

        public Criteria andYearstringGreaterThanOrEqualTo(String value) {
            addCriterion("yearstring >=", value, "yearstring");
            return (Criteria) this;
        }

        public Criteria andYearstringLessThan(String value) {
            addCriterion("yearstring <", value, "yearstring");
            return (Criteria) this;
        }

        public Criteria andYearstringLessThanOrEqualTo(String value) {
            addCriterion("yearstring <=", value, "yearstring");
            return (Criteria) this;
        }

        public Criteria andYearstringLike(String value) {
            addCriterion("yearstring like", value, "yearstring");
            return (Criteria) this;
        }

        public Criteria andYearstringNotLike(String value) {
            addCriterion("yearstring not like", value, "yearstring");
            return (Criteria) this;
        }

        public Criteria andYearstringIn(List<String> values) {
            addCriterion("yearstring in", values, "yearstring");
            return (Criteria) this;
        }

        public Criteria andYearstringNotIn(List<String> values) {
            addCriterion("yearstring not in", values, "yearstring");
            return (Criteria) this;
        }

        public Criteria andYearstringBetween(String value1, String value2) {
            addCriterion("yearstring between", value1, value2, "yearstring");
            return (Criteria) this;
        }

        public Criteria andYearstringNotBetween(String value1, String value2) {
            addCriterion("yearstring not between", value1, value2, "yearstring");
            return (Criteria) this;
        }

        public Criteria andCharturlIsNull() {
            addCriterion("charturl is null");
            return (Criteria) this;
        }

        public Criteria andCharturlIsNotNull() {
            addCriterion("charturl is not null");
            return (Criteria) this;
        }

        public Criteria andCharturlEqualTo(String value) {
            addCriterion("charturl =", value, "charturl");
            return (Criteria) this;
        }

        public Criteria andCharturlNotEqualTo(String value) {
            addCriterion("charturl <>", value, "charturl");
            return (Criteria) this;
        }

        public Criteria andCharturlGreaterThan(String value) {
            addCriterion("charturl >", value, "charturl");
            return (Criteria) this;
        }

        public Criteria andCharturlGreaterThanOrEqualTo(String value) {
            addCriterion("charturl >=", value, "charturl");
            return (Criteria) this;
        }

        public Criteria andCharturlLessThan(String value) {
            addCriterion("charturl <", value, "charturl");
            return (Criteria) this;
        }

        public Criteria andCharturlLessThanOrEqualTo(String value) {
            addCriterion("charturl <=", value, "charturl");
            return (Criteria) this;
        }

        public Criteria andCharturlLike(String value) {
            addCriterion("charturl like", value, "charturl");
            return (Criteria) this;
        }

        public Criteria andCharturlNotLike(String value) {
            addCriterion("charturl not like", value, "charturl");
            return (Criteria) this;
        }

        public Criteria andCharturlIn(List<String> values) {
            addCriterion("charturl in", values, "charturl");
            return (Criteria) this;
        }

        public Criteria andCharturlNotIn(List<String> values) {
            addCriterion("charturl not in", values, "charturl");
            return (Criteria) this;
        }

        public Criteria andCharturlBetween(String value1, String value2) {
            addCriterion("charturl between", value1, value2, "charturl");
            return (Criteria) this;
        }

        public Criteria andCharturlNotBetween(String value1, String value2) {
            addCriterion("charturl not between", value1, value2, "charturl");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Long value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Long value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Long value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Long value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Long value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Long> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Long> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Long value1, Long value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Long value1, Long value2) {
            addCriterion("userid not between", value1, value2, "userid");
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
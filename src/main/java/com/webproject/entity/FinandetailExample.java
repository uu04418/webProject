package com.webproject.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FinandetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinandetailExample() {
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

        public Criteria andFinandetailidIsNull() {
            addCriterion("finandetailid is null");
            return (Criteria) this;
        }

        public Criteria andFinandetailidIsNotNull() {
            addCriterion("finandetailid is not null");
            return (Criteria) this;
        }

        public Criteria andFinandetailidEqualTo(String value) {
            addCriterion("finandetailid =", value, "finandetailid");
            return (Criteria) this;
        }

        public Criteria andFinandetailidNotEqualTo(String value) {
            addCriterion("finandetailid <>", value, "finandetailid");
            return (Criteria) this;
        }

        public Criteria andFinandetailidGreaterThan(String value) {
            addCriterion("finandetailid >", value, "finandetailid");
            return (Criteria) this;
        }

        public Criteria andFinandetailidGreaterThanOrEqualTo(String value) {
            addCriterion("finandetailid >=", value, "finandetailid");
            return (Criteria) this;
        }

        public Criteria andFinandetailidLessThan(String value) {
            addCriterion("finandetailid <", value, "finandetailid");
            return (Criteria) this;
        }

        public Criteria andFinandetailidLessThanOrEqualTo(String value) {
            addCriterion("finandetailid <=", value, "finandetailid");
            return (Criteria) this;
        }

        public Criteria andFinandetailidLike(String value) {
            addCriterion("finandetailid like", value, "finandetailid");
            return (Criteria) this;
        }

        public Criteria andFinandetailidNotLike(String value) {
            addCriterion("finandetailid not like", value, "finandetailid");
            return (Criteria) this;
        }

        public Criteria andFinandetailidIn(List<String> values) {
            addCriterion("finandetailid in", values, "finandetailid");
            return (Criteria) this;
        }

        public Criteria andFinandetailidNotIn(List<String> values) {
            addCriterion("finandetailid not in", values, "finandetailid");
            return (Criteria) this;
        }

        public Criteria andFinandetailidBetween(String value1, String value2) {
            addCriterion("finandetailid between", value1, value2, "finandetailid");
            return (Criteria) this;
        }

        public Criteria andFinandetailidNotBetween(String value1, String value2) {
            addCriterion("finandetailid not between", value1, value2, "finandetailid");
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

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andFinancialidIsNull() {
            addCriterion("financialid is null");
            return (Criteria) this;
        }

        public Criteria andFinancialidIsNotNull() {
            addCriterion("financialid is not null");
            return (Criteria) this;
        }

        public Criteria andFinancialidEqualTo(String value) {
            addCriterion("financialid =", value, "financialid");
            return (Criteria) this;
        }

        public Criteria andFinancialidNotEqualTo(String value) {
            addCriterion("financialid <>", value, "financialid");
            return (Criteria) this;
        }

        public Criteria andFinancialidGreaterThan(String value) {
            addCriterion("financialid >", value, "financialid");
            return (Criteria) this;
        }

        public Criteria andFinancialidGreaterThanOrEqualTo(String value) {
            addCriterion("financialid >=", value, "financialid");
            return (Criteria) this;
        }

        public Criteria andFinancialidLessThan(String value) {
            addCriterion("financialid <", value, "financialid");
            return (Criteria) this;
        }

        public Criteria andFinancialidLessThanOrEqualTo(String value) {
            addCriterion("financialid <=", value, "financialid");
            return (Criteria) this;
        }

        public Criteria andFinancialidLike(String value) {
            addCriterion("financialid like", value, "financialid");
            return (Criteria) this;
        }

        public Criteria andFinancialidNotLike(String value) {
            addCriterion("financialid not like", value, "financialid");
            return (Criteria) this;
        }

        public Criteria andFinancialidIn(List<String> values) {
            addCriterion("financialid in", values, "financialid");
            return (Criteria) this;
        }

        public Criteria andFinancialidNotIn(List<String> values) {
            addCriterion("financialid not in", values, "financialid");
            return (Criteria) this;
        }

        public Criteria andFinancialidBetween(String value1, String value2) {
            addCriterion("financialid between", value1, value2, "financialid");
            return (Criteria) this;
        }

        public Criteria andFinancialidNotBetween(String value1, String value2) {
            addCriterion("financialid not between", value1, value2, "financialid");
            return (Criteria) this;
        }

        public Criteria andMoneryIsNull() {
            addCriterion("monery is null");
            return (Criteria) this;
        }

        public Criteria andMoneryIsNotNull() {
            addCriterion("monery is not null");
            return (Criteria) this;
        }

        public Criteria andMoneryEqualTo(Integer value) {
            addCriterion("monery =", value, "monery");
            return (Criteria) this;
        }

        public Criteria andMoneryNotEqualTo(Integer value) {
            addCriterion("monery <>", value, "monery");
            return (Criteria) this;
        }

        public Criteria andMoneryGreaterThan(Integer value) {
            addCriterion("monery >", value, "monery");
            return (Criteria) this;
        }

        public Criteria andMoneryGreaterThanOrEqualTo(Integer value) {
            addCriterion("monery >=", value, "monery");
            return (Criteria) this;
        }

        public Criteria andMoneryLessThan(Integer value) {
            addCriterion("monery <", value, "monery");
            return (Criteria) this;
        }

        public Criteria andMoneryLessThanOrEqualTo(Integer value) {
            addCriterion("monery <=", value, "monery");
            return (Criteria) this;
        }

        public Criteria andMoneryIn(List<Integer> values) {
            addCriterion("monery in", values, "monery");
            return (Criteria) this;
        }

        public Criteria andMoneryNotIn(List<Integer> values) {
            addCriterion("monery not in", values, "monery");
            return (Criteria) this;
        }

        public Criteria andMoneryBetween(Integer value1, Integer value2) {
            addCriterion("monery between", value1, value2, "monery");
            return (Criteria) this;
        }

        public Criteria andMoneryNotBetween(Integer value1, Integer value2) {
            addCriterion("monery not between", value1, value2, "monery");
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

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
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
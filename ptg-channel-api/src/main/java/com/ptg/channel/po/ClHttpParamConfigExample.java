package com.ptg.channel.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClHttpParamConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClHttpParamConfigExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andHttpParamIdIsNull() {
            addCriterion("HTTP_PARAM_ID is null");
            return (Criteria) this;
        }

        public Criteria andHttpParamIdIsNotNull() {
            addCriterion("HTTP_PARAM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andHttpParamIdEqualTo(String value) {
            addCriterion("HTTP_PARAM_ID =", value, "httpParamId");
            return (Criteria) this;
        }

        public Criteria andHttpParamIdNotEqualTo(String value) {
            addCriterion("HTTP_PARAM_ID <>", value, "httpParamId");
            return (Criteria) this;
        }

        public Criteria andHttpParamIdGreaterThan(String value) {
            addCriterion("HTTP_PARAM_ID >", value, "httpParamId");
            return (Criteria) this;
        }

        public Criteria andHttpParamIdGreaterThanOrEqualTo(String value) {
            addCriterion("HTTP_PARAM_ID >=", value, "httpParamId");
            return (Criteria) this;
        }

        public Criteria andHttpParamIdLessThan(String value) {
            addCriterion("HTTP_PARAM_ID <", value, "httpParamId");
            return (Criteria) this;
        }

        public Criteria andHttpParamIdLessThanOrEqualTo(String value) {
            addCriterion("HTTP_PARAM_ID <=", value, "httpParamId");
            return (Criteria) this;
        }

        public Criteria andHttpParamIdLike(String value) {
            addCriterion("HTTP_PARAM_ID like", value, "httpParamId");
            return (Criteria) this;
        }

        public Criteria andHttpParamIdNotLike(String value) {
            addCriterion("HTTP_PARAM_ID not like", value, "httpParamId");
            return (Criteria) this;
        }

        public Criteria andHttpParamIdIn(List<String> values) {
            addCriterion("HTTP_PARAM_ID in", values, "httpParamId");
            return (Criteria) this;
        }

        public Criteria andHttpParamIdNotIn(List<String> values) {
            addCriterion("HTTP_PARAM_ID not in", values, "httpParamId");
            return (Criteria) this;
        }

        public Criteria andHttpParamIdBetween(String value1, String value2) {
            addCriterion("HTTP_PARAM_ID between", value1, value2, "httpParamId");
            return (Criteria) this;
        }

        public Criteria andHttpParamIdNotBetween(String value1, String value2) {
            addCriterion("HTTP_PARAM_ID not between", value1, value2, "httpParamId");
            return (Criteria) this;
        }

        public Criteria andHttpParamNameIsNull() {
            addCriterion("HTTP_PARAM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andHttpParamNameIsNotNull() {
            addCriterion("HTTP_PARAM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andHttpParamNameEqualTo(String value) {
            addCriterion("HTTP_PARAM_NAME =", value, "httpParamName");
            return (Criteria) this;
        }

        public Criteria andHttpParamNameNotEqualTo(String value) {
            addCriterion("HTTP_PARAM_NAME <>", value, "httpParamName");
            return (Criteria) this;
        }

        public Criteria andHttpParamNameGreaterThan(String value) {
            addCriterion("HTTP_PARAM_NAME >", value, "httpParamName");
            return (Criteria) this;
        }

        public Criteria andHttpParamNameGreaterThanOrEqualTo(String value) {
            addCriterion("HTTP_PARAM_NAME >=", value, "httpParamName");
            return (Criteria) this;
        }

        public Criteria andHttpParamNameLessThan(String value) {
            addCriterion("HTTP_PARAM_NAME <", value, "httpParamName");
            return (Criteria) this;
        }

        public Criteria andHttpParamNameLessThanOrEqualTo(String value) {
            addCriterion("HTTP_PARAM_NAME <=", value, "httpParamName");
            return (Criteria) this;
        }

        public Criteria andHttpParamNameLike(String value) {
            addCriterion("HTTP_PARAM_NAME like", value, "httpParamName");
            return (Criteria) this;
        }

        public Criteria andHttpParamNameNotLike(String value) {
            addCriterion("HTTP_PARAM_NAME not like", value, "httpParamName");
            return (Criteria) this;
        }

        public Criteria andHttpParamNameIn(List<String> values) {
            addCriterion("HTTP_PARAM_NAME in", values, "httpParamName");
            return (Criteria) this;
        }

        public Criteria andHttpParamNameNotIn(List<String> values) {
            addCriterion("HTTP_PARAM_NAME not in", values, "httpParamName");
            return (Criteria) this;
        }

        public Criteria andHttpParamNameBetween(String value1, String value2) {
            addCriterion("HTTP_PARAM_NAME between", value1, value2, "httpParamName");
            return (Criteria) this;
        }

        public Criteria andHttpParamNameNotBetween(String value1, String value2) {
            addCriterion("HTTP_PARAM_NAME not between", value1, value2, "httpParamName");
            return (Criteria) this;
        }

        public Criteria andHttpParamValueIsNull() {
            addCriterion("HTTP_PARAM_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andHttpParamValueIsNotNull() {
            addCriterion("HTTP_PARAM_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andHttpParamValueEqualTo(String value) {
            addCriterion("HTTP_PARAM_VALUE =", value, "httpParamValue");
            return (Criteria) this;
        }

        public Criteria andHttpParamValueNotEqualTo(String value) {
            addCriterion("HTTP_PARAM_VALUE <>", value, "httpParamValue");
            return (Criteria) this;
        }

        public Criteria andHttpParamValueGreaterThan(String value) {
            addCriterion("HTTP_PARAM_VALUE >", value, "httpParamValue");
            return (Criteria) this;
        }

        public Criteria andHttpParamValueGreaterThanOrEqualTo(String value) {
            addCriterion("HTTP_PARAM_VALUE >=", value, "httpParamValue");
            return (Criteria) this;
        }

        public Criteria andHttpParamValueLessThan(String value) {
            addCriterion("HTTP_PARAM_VALUE <", value, "httpParamValue");
            return (Criteria) this;
        }

        public Criteria andHttpParamValueLessThanOrEqualTo(String value) {
            addCriterion("HTTP_PARAM_VALUE <=", value, "httpParamValue");
            return (Criteria) this;
        }

        public Criteria andHttpParamValueLike(String value) {
            addCriterion("HTTP_PARAM_VALUE like", value, "httpParamValue");
            return (Criteria) this;
        }

        public Criteria andHttpParamValueNotLike(String value) {
            addCriterion("HTTP_PARAM_VALUE not like", value, "httpParamValue");
            return (Criteria) this;
        }

        public Criteria andHttpParamValueIn(List<String> values) {
            addCriterion("HTTP_PARAM_VALUE in", values, "httpParamValue");
            return (Criteria) this;
        }

        public Criteria andHttpParamValueNotIn(List<String> values) {
            addCriterion("HTTP_PARAM_VALUE not in", values, "httpParamValue");
            return (Criteria) this;
        }

        public Criteria andHttpParamValueBetween(String value1, String value2) {
            addCriterion("HTTP_PARAM_VALUE between", value1, value2, "httpParamValue");
            return (Criteria) this;
        }

        public Criteria andHttpParamValueNotBetween(String value1, String value2) {
            addCriterion("HTTP_PARAM_VALUE not between", value1, value2, "httpParamValue");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("DEL_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("DEL_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(String value) {
            addCriterion("DEL_FLAG =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(String value) {
            addCriterion("DEL_FLAG <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(String value) {
            addCriterion("DEL_FLAG >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("DEL_FLAG >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(String value) {
            addCriterion("DEL_FLAG <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(String value) {
            addCriterion("DEL_FLAG <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLike(String value) {
            addCriterion("DEL_FLAG like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotLike(String value) {
            addCriterion("DEL_FLAG not like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<String> values) {
            addCriterion("DEL_FLAG in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<String> values) {
            addCriterion("DEL_FLAG not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(String value1, String value2) {
            addCriterion("DEL_FLAG between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(String value1, String value2) {
            addCriterion("DEL_FLAG not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("UPDATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("UPDATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("UPDATE_DATE =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("UPDATE_DATE <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("UPDATE_DATE >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATE >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("UPDATE_DATE <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATE <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("UPDATE_DATE in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("UPDATE_DATE not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATE between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATE not between", value1, value2, "updateDate");
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
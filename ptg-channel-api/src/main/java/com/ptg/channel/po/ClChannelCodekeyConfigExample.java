package com.ptg.channel.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClChannelCodekeyConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClChannelCodekeyConfigExample() {
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

        public Criteria andCodeKeyIdIsNull() {
            addCriterion("CODE_KEY_ID is null");
            return (Criteria) this;
        }

        public Criteria andCodeKeyIdIsNotNull() {
            addCriterion("CODE_KEY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCodeKeyIdEqualTo(String value) {
            addCriterion("CODE_KEY_ID =", value, "codeKeyId");
            return (Criteria) this;
        }

        public Criteria andCodeKeyIdNotEqualTo(String value) {
            addCriterion("CODE_KEY_ID <>", value, "codeKeyId");
            return (Criteria) this;
        }

        public Criteria andCodeKeyIdGreaterThan(String value) {
            addCriterion("CODE_KEY_ID >", value, "codeKeyId");
            return (Criteria) this;
        }

        public Criteria andCodeKeyIdGreaterThanOrEqualTo(String value) {
            addCriterion("CODE_KEY_ID >=", value, "codeKeyId");
            return (Criteria) this;
        }

        public Criteria andCodeKeyIdLessThan(String value) {
            addCriterion("CODE_KEY_ID <", value, "codeKeyId");
            return (Criteria) this;
        }

        public Criteria andCodeKeyIdLessThanOrEqualTo(String value) {
            addCriterion("CODE_KEY_ID <=", value, "codeKeyId");
            return (Criteria) this;
        }

        public Criteria andCodeKeyIdLike(String value) {
            addCriterion("CODE_KEY_ID like", value, "codeKeyId");
            return (Criteria) this;
        }

        public Criteria andCodeKeyIdNotLike(String value) {
            addCriterion("CODE_KEY_ID not like", value, "codeKeyId");
            return (Criteria) this;
        }

        public Criteria andCodeKeyIdIn(List<String> values) {
            addCriterion("CODE_KEY_ID in", values, "codeKeyId");
            return (Criteria) this;
        }

        public Criteria andCodeKeyIdNotIn(List<String> values) {
            addCriterion("CODE_KEY_ID not in", values, "codeKeyId");
            return (Criteria) this;
        }

        public Criteria andCodeKeyIdBetween(String value1, String value2) {
            addCriterion("CODE_KEY_ID between", value1, value2, "codeKeyId");
            return (Criteria) this;
        }

        public Criteria andCodeKeyIdNotBetween(String value1, String value2) {
            addCriterion("CODE_KEY_ID not between", value1, value2, "codeKeyId");
            return (Criteria) this;
        }

        public Criteria andChannelCodeKeyIsNull() {
            addCriterion("CHANNEL_CODE_KEY is null");
            return (Criteria) this;
        }

        public Criteria andChannelCodeKeyIsNotNull() {
            addCriterion("CHANNEL_CODE_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andChannelCodeKeyEqualTo(String value) {
            addCriterion("CHANNEL_CODE_KEY =", value, "channelCodeKey");
            return (Criteria) this;
        }

        public Criteria andChannelCodeKeyNotEqualTo(String value) {
            addCriterion("CHANNEL_CODE_KEY <>", value, "channelCodeKey");
            return (Criteria) this;
        }

        public Criteria andChannelCodeKeyGreaterThan(String value) {
            addCriterion("CHANNEL_CODE_KEY >", value, "channelCodeKey");
            return (Criteria) this;
        }

        public Criteria andChannelCodeKeyGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNEL_CODE_KEY >=", value, "channelCodeKey");
            return (Criteria) this;
        }

        public Criteria andChannelCodeKeyLessThan(String value) {
            addCriterion("CHANNEL_CODE_KEY <", value, "channelCodeKey");
            return (Criteria) this;
        }

        public Criteria andChannelCodeKeyLessThanOrEqualTo(String value) {
            addCriterion("CHANNEL_CODE_KEY <=", value, "channelCodeKey");
            return (Criteria) this;
        }

        public Criteria andChannelCodeKeyLike(String value) {
            addCriterion("CHANNEL_CODE_KEY like", value, "channelCodeKey");
            return (Criteria) this;
        }

        public Criteria andChannelCodeKeyNotLike(String value) {
            addCriterion("CHANNEL_CODE_KEY not like", value, "channelCodeKey");
            return (Criteria) this;
        }

        public Criteria andChannelCodeKeyIn(List<String> values) {
            addCriterion("CHANNEL_CODE_KEY in", values, "channelCodeKey");
            return (Criteria) this;
        }

        public Criteria andChannelCodeKeyNotIn(List<String> values) {
            addCriterion("CHANNEL_CODE_KEY not in", values, "channelCodeKey");
            return (Criteria) this;
        }

        public Criteria andChannelCodeKeyBetween(String value1, String value2) {
            addCriterion("CHANNEL_CODE_KEY between", value1, value2, "channelCodeKey");
            return (Criteria) this;
        }

        public Criteria andChannelCodeKeyNotBetween(String value1, String value2) {
            addCriterion("CHANNEL_CODE_KEY not between", value1, value2, "channelCodeKey");
            return (Criteria) this;
        }

        public Criteria andCodeKeyIsNull() {
            addCriterion("CODE_KEY is null");
            return (Criteria) this;
        }

        public Criteria andCodeKeyIsNotNull() {
            addCriterion("CODE_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andCodeKeyEqualTo(String value) {
            addCriterion("CODE_KEY =", value, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeKeyNotEqualTo(String value) {
            addCriterion("CODE_KEY <>", value, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeKeyGreaterThan(String value) {
            addCriterion("CODE_KEY >", value, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeKeyGreaterThanOrEqualTo(String value) {
            addCriterion("CODE_KEY >=", value, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeKeyLessThan(String value) {
            addCriterion("CODE_KEY <", value, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeKeyLessThanOrEqualTo(String value) {
            addCriterion("CODE_KEY <=", value, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeKeyLike(String value) {
            addCriterion("CODE_KEY like", value, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeKeyNotLike(String value) {
            addCriterion("CODE_KEY not like", value, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeKeyIn(List<String> values) {
            addCriterion("CODE_KEY in", values, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeKeyNotIn(List<String> values) {
            addCriterion("CODE_KEY not in", values, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeKeyBetween(String value1, String value2) {
            addCriterion("CODE_KEY between", value1, value2, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeKeyNotBetween(String value1, String value2) {
            addCriterion("CODE_KEY not between", value1, value2, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeValueIdIsNull() {
            addCriterion("CODE_VALUE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCodeValueIdIsNotNull() {
            addCriterion("CODE_VALUE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCodeValueIdEqualTo(String value) {
            addCriterion("CODE_VALUE_ID =", value, "codeValueId");
            return (Criteria) this;
        }

        public Criteria andCodeValueIdNotEqualTo(String value) {
            addCriterion("CODE_VALUE_ID <>", value, "codeValueId");
            return (Criteria) this;
        }

        public Criteria andCodeValueIdGreaterThan(String value) {
            addCriterion("CODE_VALUE_ID >", value, "codeValueId");
            return (Criteria) this;
        }

        public Criteria andCodeValueIdGreaterThanOrEqualTo(String value) {
            addCriterion("CODE_VALUE_ID >=", value, "codeValueId");
            return (Criteria) this;
        }

        public Criteria andCodeValueIdLessThan(String value) {
            addCriterion("CODE_VALUE_ID <", value, "codeValueId");
            return (Criteria) this;
        }

        public Criteria andCodeValueIdLessThanOrEqualTo(String value) {
            addCriterion("CODE_VALUE_ID <=", value, "codeValueId");
            return (Criteria) this;
        }

        public Criteria andCodeValueIdLike(String value) {
            addCriterion("CODE_VALUE_ID like", value, "codeValueId");
            return (Criteria) this;
        }

        public Criteria andCodeValueIdNotLike(String value) {
            addCriterion("CODE_VALUE_ID not like", value, "codeValueId");
            return (Criteria) this;
        }

        public Criteria andCodeValueIdIn(List<String> values) {
            addCriterion("CODE_VALUE_ID in", values, "codeValueId");
            return (Criteria) this;
        }

        public Criteria andCodeValueIdNotIn(List<String> values) {
            addCriterion("CODE_VALUE_ID not in", values, "codeValueId");
            return (Criteria) this;
        }

        public Criteria andCodeValueIdBetween(String value1, String value2) {
            addCriterion("CODE_VALUE_ID between", value1, value2, "codeValueId");
            return (Criteria) this;
        }

        public Criteria andCodeValueIdNotBetween(String value1, String value2) {
            addCriterion("CODE_VALUE_ID not between", value1, value2, "codeValueId");
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
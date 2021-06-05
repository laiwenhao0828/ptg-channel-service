package com.ptg.channel.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClChannelInterfaceConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClChannelInterfaceConfigExample() {
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

        public Criteria andInterfaceNameIsNull() {
            addCriterion("INTERFACE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameIsNotNull() {
            addCriterion("INTERFACE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameEqualTo(String value) {
            addCriterion("INTERFACE_NAME =", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotEqualTo(String value) {
            addCriterion("INTERFACE_NAME <>", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameGreaterThan(String value) {
            addCriterion("INTERFACE_NAME >", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameGreaterThanOrEqualTo(String value) {
            addCriterion("INTERFACE_NAME >=", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameLessThan(String value) {
            addCriterion("INTERFACE_NAME <", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameLessThanOrEqualTo(String value) {
            addCriterion("INTERFACE_NAME <=", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameLike(String value) {
            addCriterion("INTERFACE_NAME like", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotLike(String value) {
            addCriterion("INTERFACE_NAME not like", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameIn(List<String> values) {
            addCriterion("INTERFACE_NAME in", values, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotIn(List<String> values) {
            addCriterion("INTERFACE_NAME not in", values, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameBetween(String value1, String value2) {
            addCriterion("INTERFACE_NAME between", value1, value2, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotBetween(String value1, String value2) {
            addCriterion("INTERFACE_NAME not between", value1, value2, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andHttpIdIsNull() {
            addCriterion("HTTP_ID is null");
            return (Criteria) this;
        }

        public Criteria andHttpIdIsNotNull() {
            addCriterion("HTTP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andHttpIdEqualTo(String value) {
            addCriterion("HTTP_ID =", value, "httpId");
            return (Criteria) this;
        }

        public Criteria andHttpIdNotEqualTo(String value) {
            addCriterion("HTTP_ID <>", value, "httpId");
            return (Criteria) this;
        }

        public Criteria andHttpIdGreaterThan(String value) {
            addCriterion("HTTP_ID >", value, "httpId");
            return (Criteria) this;
        }

        public Criteria andHttpIdGreaterThanOrEqualTo(String value) {
            addCriterion("HTTP_ID >=", value, "httpId");
            return (Criteria) this;
        }

        public Criteria andHttpIdLessThan(String value) {
            addCriterion("HTTP_ID <", value, "httpId");
            return (Criteria) this;
        }

        public Criteria andHttpIdLessThanOrEqualTo(String value) {
            addCriterion("HTTP_ID <=", value, "httpId");
            return (Criteria) this;
        }

        public Criteria andHttpIdLike(String value) {
            addCriterion("HTTP_ID like", value, "httpId");
            return (Criteria) this;
        }

        public Criteria andHttpIdNotLike(String value) {
            addCriterion("HTTP_ID not like", value, "httpId");
            return (Criteria) this;
        }

        public Criteria andHttpIdIn(List<String> values) {
            addCriterion("HTTP_ID in", values, "httpId");
            return (Criteria) this;
        }

        public Criteria andHttpIdNotIn(List<String> values) {
            addCriterion("HTTP_ID not in", values, "httpId");
            return (Criteria) this;
        }

        public Criteria andHttpIdBetween(String value1, String value2) {
            addCriterion("HTTP_ID between", value1, value2, "httpId");
            return (Criteria) this;
        }

        public Criteria andHttpIdNotBetween(String value1, String value2) {
            addCriterion("HTTP_ID not between", value1, value2, "httpId");
            return (Criteria) this;
        }

        public Criteria andTemplateReqIsNull() {
            addCriterion("TEMPLATE_REQ is null");
            return (Criteria) this;
        }

        public Criteria andTemplateReqIsNotNull() {
            addCriterion("TEMPLATE_REQ is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateReqEqualTo(String value) {
            addCriterion("TEMPLATE_REQ =", value, "templateReq");
            return (Criteria) this;
        }

        public Criteria andTemplateReqNotEqualTo(String value) {
            addCriterion("TEMPLATE_REQ <>", value, "templateReq");
            return (Criteria) this;
        }

        public Criteria andTemplateReqGreaterThan(String value) {
            addCriterion("TEMPLATE_REQ >", value, "templateReq");
            return (Criteria) this;
        }

        public Criteria andTemplateReqGreaterThanOrEqualTo(String value) {
            addCriterion("TEMPLATE_REQ >=", value, "templateReq");
            return (Criteria) this;
        }

        public Criteria andTemplateReqLessThan(String value) {
            addCriterion("TEMPLATE_REQ <", value, "templateReq");
            return (Criteria) this;
        }

        public Criteria andTemplateReqLessThanOrEqualTo(String value) {
            addCriterion("TEMPLATE_REQ <=", value, "templateReq");
            return (Criteria) this;
        }

        public Criteria andTemplateReqLike(String value) {
            addCriterion("TEMPLATE_REQ like", value, "templateReq");
            return (Criteria) this;
        }

        public Criteria andTemplateReqNotLike(String value) {
            addCriterion("TEMPLATE_REQ not like", value, "templateReq");
            return (Criteria) this;
        }

        public Criteria andTemplateReqIn(List<String> values) {
            addCriterion("TEMPLATE_REQ in", values, "templateReq");
            return (Criteria) this;
        }

        public Criteria andTemplateReqNotIn(List<String> values) {
            addCriterion("TEMPLATE_REQ not in", values, "templateReq");
            return (Criteria) this;
        }

        public Criteria andTemplateReqBetween(String value1, String value2) {
            addCriterion("TEMPLATE_REQ between", value1, value2, "templateReq");
            return (Criteria) this;
        }

        public Criteria andTemplateReqNotBetween(String value1, String value2) {
            addCriterion("TEMPLATE_REQ not between", value1, value2, "templateReq");
            return (Criteria) this;
        }

        public Criteria andTemplateRespIsNull() {
            addCriterion("TEMPLATE_RESP is null");
            return (Criteria) this;
        }

        public Criteria andTemplateRespIsNotNull() {
            addCriterion("TEMPLATE_RESP is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateRespEqualTo(String value) {
            addCriterion("TEMPLATE_RESP =", value, "templateResp");
            return (Criteria) this;
        }

        public Criteria andTemplateRespNotEqualTo(String value) {
            addCriterion("TEMPLATE_RESP <>", value, "templateResp");
            return (Criteria) this;
        }

        public Criteria andTemplateRespGreaterThan(String value) {
            addCriterion("TEMPLATE_RESP >", value, "templateResp");
            return (Criteria) this;
        }

        public Criteria andTemplateRespGreaterThanOrEqualTo(String value) {
            addCriterion("TEMPLATE_RESP >=", value, "templateResp");
            return (Criteria) this;
        }

        public Criteria andTemplateRespLessThan(String value) {
            addCriterion("TEMPLATE_RESP <", value, "templateResp");
            return (Criteria) this;
        }

        public Criteria andTemplateRespLessThanOrEqualTo(String value) {
            addCriterion("TEMPLATE_RESP <=", value, "templateResp");
            return (Criteria) this;
        }

        public Criteria andTemplateRespLike(String value) {
            addCriterion("TEMPLATE_RESP like", value, "templateResp");
            return (Criteria) this;
        }

        public Criteria andTemplateRespNotLike(String value) {
            addCriterion("TEMPLATE_RESP not like", value, "templateResp");
            return (Criteria) this;
        }

        public Criteria andTemplateRespIn(List<String> values) {
            addCriterion("TEMPLATE_RESP in", values, "templateResp");
            return (Criteria) this;
        }

        public Criteria andTemplateRespNotIn(List<String> values) {
            addCriterion("TEMPLATE_RESP not in", values, "templateResp");
            return (Criteria) this;
        }

        public Criteria andTemplateRespBetween(String value1, String value2) {
            addCriterion("TEMPLATE_RESP between", value1, value2, "templateResp");
            return (Criteria) this;
        }

        public Criteria andTemplateRespNotBetween(String value1, String value2) {
            addCriterion("TEMPLATE_RESP not between", value1, value2, "templateResp");
            return (Criteria) this;
        }

        public Criteria andPubKeyIdIsNull() {
            addCriterion("PUB_KEY_ID is null");
            return (Criteria) this;
        }

        public Criteria andPubKeyIdIsNotNull() {
            addCriterion("PUB_KEY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPubKeyIdEqualTo(String value) {
            addCriterion("PUB_KEY_ID =", value, "pubKeyId");
            return (Criteria) this;
        }

        public Criteria andPubKeyIdNotEqualTo(String value) {
            addCriterion("PUB_KEY_ID <>", value, "pubKeyId");
            return (Criteria) this;
        }

        public Criteria andPubKeyIdGreaterThan(String value) {
            addCriterion("PUB_KEY_ID >", value, "pubKeyId");
            return (Criteria) this;
        }

        public Criteria andPubKeyIdGreaterThanOrEqualTo(String value) {
            addCriterion("PUB_KEY_ID >=", value, "pubKeyId");
            return (Criteria) this;
        }

        public Criteria andPubKeyIdLessThan(String value) {
            addCriterion("PUB_KEY_ID <", value, "pubKeyId");
            return (Criteria) this;
        }

        public Criteria andPubKeyIdLessThanOrEqualTo(String value) {
            addCriterion("PUB_KEY_ID <=", value, "pubKeyId");
            return (Criteria) this;
        }

        public Criteria andPubKeyIdLike(String value) {
            addCriterion("PUB_KEY_ID like", value, "pubKeyId");
            return (Criteria) this;
        }

        public Criteria andPubKeyIdNotLike(String value) {
            addCriterion("PUB_KEY_ID not like", value, "pubKeyId");
            return (Criteria) this;
        }

        public Criteria andPubKeyIdIn(List<String> values) {
            addCriterion("PUB_KEY_ID in", values, "pubKeyId");
            return (Criteria) this;
        }

        public Criteria andPubKeyIdNotIn(List<String> values) {
            addCriterion("PUB_KEY_ID not in", values, "pubKeyId");
            return (Criteria) this;
        }

        public Criteria andPubKeyIdBetween(String value1, String value2) {
            addCriterion("PUB_KEY_ID between", value1, value2, "pubKeyId");
            return (Criteria) this;
        }

        public Criteria andPubKeyIdNotBetween(String value1, String value2) {
            addCriterion("PUB_KEY_ID not between", value1, value2, "pubKeyId");
            return (Criteria) this;
        }

        public Criteria andPriKeyIdIsNull() {
            addCriterion("PRI_KEY_ID is null");
            return (Criteria) this;
        }

        public Criteria andPriKeyIdIsNotNull() {
            addCriterion("PRI_KEY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPriKeyIdEqualTo(String value) {
            addCriterion("PRI_KEY_ID =", value, "priKeyId");
            return (Criteria) this;
        }

        public Criteria andPriKeyIdNotEqualTo(String value) {
            addCriterion("PRI_KEY_ID <>", value, "priKeyId");
            return (Criteria) this;
        }

        public Criteria andPriKeyIdGreaterThan(String value) {
            addCriterion("PRI_KEY_ID >", value, "priKeyId");
            return (Criteria) this;
        }

        public Criteria andPriKeyIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRI_KEY_ID >=", value, "priKeyId");
            return (Criteria) this;
        }

        public Criteria andPriKeyIdLessThan(String value) {
            addCriterion("PRI_KEY_ID <", value, "priKeyId");
            return (Criteria) this;
        }

        public Criteria andPriKeyIdLessThanOrEqualTo(String value) {
            addCriterion("PRI_KEY_ID <=", value, "priKeyId");
            return (Criteria) this;
        }

        public Criteria andPriKeyIdLike(String value) {
            addCriterion("PRI_KEY_ID like", value, "priKeyId");
            return (Criteria) this;
        }

        public Criteria andPriKeyIdNotLike(String value) {
            addCriterion("PRI_KEY_ID not like", value, "priKeyId");
            return (Criteria) this;
        }

        public Criteria andPriKeyIdIn(List<String> values) {
            addCriterion("PRI_KEY_ID in", values, "priKeyId");
            return (Criteria) this;
        }

        public Criteria andPriKeyIdNotIn(List<String> values) {
            addCriterion("PRI_KEY_ID not in", values, "priKeyId");
            return (Criteria) this;
        }

        public Criteria andPriKeyIdBetween(String value1, String value2) {
            addCriterion("PRI_KEY_ID between", value1, value2, "priKeyId");
            return (Criteria) this;
        }

        public Criteria andPriKeyIdNotBetween(String value1, String value2) {
            addCriterion("PRI_KEY_ID not between", value1, value2, "priKeyId");
            return (Criteria) this;
        }

        public Criteria andEncryFilterIsNull() {
            addCriterion("ENCRY_FILTER is null");
            return (Criteria) this;
        }

        public Criteria andEncryFilterIsNotNull() {
            addCriterion("ENCRY_FILTER is not null");
            return (Criteria) this;
        }

        public Criteria andEncryFilterEqualTo(String value) {
            addCriterion("ENCRY_FILTER =", value, "encryFilter");
            return (Criteria) this;
        }

        public Criteria andEncryFilterNotEqualTo(String value) {
            addCriterion("ENCRY_FILTER <>", value, "encryFilter");
            return (Criteria) this;
        }

        public Criteria andEncryFilterGreaterThan(String value) {
            addCriterion("ENCRY_FILTER >", value, "encryFilter");
            return (Criteria) this;
        }

        public Criteria andEncryFilterGreaterThanOrEqualTo(String value) {
            addCriterion("ENCRY_FILTER >=", value, "encryFilter");
            return (Criteria) this;
        }

        public Criteria andEncryFilterLessThan(String value) {
            addCriterion("ENCRY_FILTER <", value, "encryFilter");
            return (Criteria) this;
        }

        public Criteria andEncryFilterLessThanOrEqualTo(String value) {
            addCriterion("ENCRY_FILTER <=", value, "encryFilter");
            return (Criteria) this;
        }

        public Criteria andEncryFilterLike(String value) {
            addCriterion("ENCRY_FILTER like", value, "encryFilter");
            return (Criteria) this;
        }

        public Criteria andEncryFilterNotLike(String value) {
            addCriterion("ENCRY_FILTER not like", value, "encryFilter");
            return (Criteria) this;
        }

        public Criteria andEncryFilterIn(List<String> values) {
            addCriterion("ENCRY_FILTER in", values, "encryFilter");
            return (Criteria) this;
        }

        public Criteria andEncryFilterNotIn(List<String> values) {
            addCriterion("ENCRY_FILTER not in", values, "encryFilter");
            return (Criteria) this;
        }

        public Criteria andEncryFilterBetween(String value1, String value2) {
            addCriterion("ENCRY_FILTER between", value1, value2, "encryFilter");
            return (Criteria) this;
        }

        public Criteria andEncryFilterNotBetween(String value1, String value2) {
            addCriterion("ENCRY_FILTER not between", value1, value2, "encryFilter");
            return (Criteria) this;
        }

        public Criteria andIsTestIsNull() {
            addCriterion("IS_TEST is null");
            return (Criteria) this;
        }

        public Criteria andIsTestIsNotNull() {
            addCriterion("IS_TEST is not null");
            return (Criteria) this;
        }

        public Criteria andIsTestEqualTo(String value) {
            addCriterion("IS_TEST =", value, "isTest");
            return (Criteria) this;
        }

        public Criteria andIsTestNotEqualTo(String value) {
            addCriterion("IS_TEST <>", value, "isTest");
            return (Criteria) this;
        }

        public Criteria andIsTestGreaterThan(String value) {
            addCriterion("IS_TEST >", value, "isTest");
            return (Criteria) this;
        }

        public Criteria andIsTestGreaterThanOrEqualTo(String value) {
            addCriterion("IS_TEST >=", value, "isTest");
            return (Criteria) this;
        }

        public Criteria andIsTestLessThan(String value) {
            addCriterion("IS_TEST <", value, "isTest");
            return (Criteria) this;
        }

        public Criteria andIsTestLessThanOrEqualTo(String value) {
            addCriterion("IS_TEST <=", value, "isTest");
            return (Criteria) this;
        }

        public Criteria andIsTestLike(String value) {
            addCriterion("IS_TEST like", value, "isTest");
            return (Criteria) this;
        }

        public Criteria andIsTestNotLike(String value) {
            addCriterion("IS_TEST not like", value, "isTest");
            return (Criteria) this;
        }

        public Criteria andIsTestIn(List<String> values) {
            addCriterion("IS_TEST in", values, "isTest");
            return (Criteria) this;
        }

        public Criteria andIsTestNotIn(List<String> values) {
            addCriterion("IS_TEST not in", values, "isTest");
            return (Criteria) this;
        }

        public Criteria andIsTestBetween(String value1, String value2) {
            addCriterion("IS_TEST between", value1, value2, "isTest");
            return (Criteria) this;
        }

        public Criteria andIsTestNotBetween(String value1, String value2) {
            addCriterion("IS_TEST not between", value1, value2, "isTest");
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
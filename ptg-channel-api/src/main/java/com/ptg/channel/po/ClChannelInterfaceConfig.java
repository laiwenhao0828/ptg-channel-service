package com.ptg.channel.po;

import java.util.Date;

public class ClChannelInterfaceConfig {
    private String id;

    private String interfaceName;

    private String httpId;

    private String templateReq;

    private String templateResp;

    private String pubKeyId;

    private String priKeyId;

    private String encryFilter;

    private String isTest;

    private String delFlag;

    private Date createDate;

    private Date updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName == null ? null : interfaceName.trim();
    }

    public String getHttpId() {
        return httpId;
    }

    public void setHttpId(String httpId) {
        this.httpId = httpId == null ? null : httpId.trim();
    }

    public String getTemplateReq() {
        return templateReq;
    }

    public void setTemplateReq(String templateReq) {
        this.templateReq = templateReq == null ? null : templateReq.trim();
    }

    public String getTemplateResp() {
        return templateResp;
    }

    public void setTemplateResp(String templateResp) {
        this.templateResp = templateResp == null ? null : templateResp.trim();
    }

    public String getPubKeyId() {
        return pubKeyId;
    }

    public void setPubKeyId(String pubKeyId) {
        this.pubKeyId = pubKeyId == null ? null : pubKeyId.trim();
    }

    public String getPriKeyId() {
        return priKeyId;
    }

    public void setPriKeyId(String priKeyId) {
        this.priKeyId = priKeyId == null ? null : priKeyId.trim();
    }

    public String getEncryFilter() {
        return encryFilter;
    }

    public void setEncryFilter(String encryFilter) {
        this.encryFilter = encryFilter == null ? null : encryFilter.trim();
    }

    public String getIsTest() {
        return isTest;
    }

    public void setIsTest(String isTest) {
        this.isTest = isTest == null ? null : isTest.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
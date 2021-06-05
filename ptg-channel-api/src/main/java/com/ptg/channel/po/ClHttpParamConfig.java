package com.ptg.channel.po;

import java.util.Date;

public class ClHttpParamConfig {
    private String id;

    private String httpParamId;

    private String httpParamName;

    private String httpParamValue;

    private String delFlag;

    private Date createDate;

    private Date updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getHttpParamId() {
        return httpParamId;
    }

    public void setHttpParamId(String httpParamId) {
        this.httpParamId = httpParamId == null ? null : httpParamId.trim();
    }

    public String getHttpParamName() {
        return httpParamName;
    }

    public void setHttpParamName(String httpParamName) {
        this.httpParamName = httpParamName == null ? null : httpParamName.trim();
    }

    public String getHttpParamValue() {
        return httpParamValue;
    }

    public void setHttpParamValue(String httpParamValue) {
        this.httpParamValue = httpParamValue == null ? null : httpParamValue.trim();
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
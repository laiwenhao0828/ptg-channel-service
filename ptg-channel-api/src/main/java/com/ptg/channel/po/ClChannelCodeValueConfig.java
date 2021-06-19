package com.ptg.channel.po;

import java.util.Date;

public class ClChannelCodeValueConfig {
    private String id;

    private String codeValueId;

    private String channelCodeValue;

    private String codeValue;

    private String delFlag;

    private Date createDate;

    private Date updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodeValueId() {
        return codeValueId;
    }

    public void setCodeValueId(String codeValueId) {
        this.codeValueId = codeValueId;
    }

    public String getChannelCodeValue() {
        return channelCodeValue;
    }

    public void setChannelCodeValue(String channelCodeValue) {
        this.channelCodeValue = channelCodeValue;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
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
package com.ptg.channel.po;

import java.util.Date;

public class ClChannelCodekeyConfig {
    private String id;

    private String codeKeyId;

    private String channelCodeKey;

    private String codeKey;

    private String codeValueId;

    private String delFlag;

    private Date createDate;

    private Date updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodeKeyId() {
        return codeKeyId;
    }

    public void setCodeKeyId(String codeKeyId) {
        this.codeKeyId = codeKeyId;
    }

    public String getChannelCodeKey() {
        return channelCodeKey;
    }

    public void setChannelCodeKey(String channelCodeKey) {
        this.channelCodeKey = channelCodeKey;
    }

    public String getCodeKey() {
        return codeKey;
    }

    public void setCodeKey(String codeKey) {
        this.codeKey = codeKey;
    }

    public String getCodeValueId() {
        return codeValueId;
    }

    public void setCodeValueId(String codeValueId) {
        this.codeValueId = codeValueId;
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
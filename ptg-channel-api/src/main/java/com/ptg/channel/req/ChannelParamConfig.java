package com.ptg.channel.req;

import lombok.Data;

import java.util.List;

/**
 * @Author xch
 * @Date 2021/6/2 11:22
 * @Version 1.0
 **/
@Data
public class ChannelParamConfig {
    private String interfaceName;

    private String templateReq;

    private String templateResp;

    private String pubKeyId;

    private String priKeyId;

    private String encryFilter;

    private String isTest;

    private String httpHost;

    private String httpParamId;

    private String httpMethod;

    private String pubKey;

    private String priKey;

    private List<ChannelHttpParamConfig> clHttpParamConfigs;
}

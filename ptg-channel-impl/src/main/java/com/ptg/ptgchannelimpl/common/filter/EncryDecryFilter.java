package com.ptg.ptgchannelimpl.common.filter;


import com.ptg.channel.req.ChannelParamConfig;
import com.ptg.channel.req.ChannelSecretReq;
import com.ptg.channel.resp.BaseResp;

/**
 * @Author xch
 * @Date 2021/6/2 11:44
 * @Version 1.0
 * @desc 加密的类需要继承该方法且在当前包下
 **/
public abstract class EncryDecryFilter {
    /**
     * 加密参数
     * */
    public abstract BaseResp<ChannelSecretReq> encryParam(String params, ChannelParamConfig channelParamConfig);
    /**
     * 解密参数
     * */
    public abstract BaseResp<String> decryParam(String params, ChannelParamConfig channelParamConfig);
}

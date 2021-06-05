package com.ptg.ptgchannelimpl.common;


import com.ptg.channel.req.ChannelParamConfig;
import com.ptg.channel.req.ChannelSecretReq;
import com.ptg.channel.resp.BaseResp;

/**
 * @Author xch
 * @Date 2021/6/1 19:36
 * @Version 1.0
 **/
public interface ChannelProcessService {
    /**
     * 根据接口名获取接口配置
     * */
    public BaseResp<ChannelParamConfig> getInterfaceConfig(String interfaceName);
    /**
     * 获取密文
     * */
    public  BaseResp getCiphertext(String params, ChannelParamConfig channelParamConfig);
    /**
     * 组织参数
     * */
    public  BaseResp handleParam(ChannelSecretReq channelSecretReq, ChannelParamConfig interfaceConfig);
    /**
     * http调用通道
     * */
    public  BaseResp<String> httpInvoke(ChannelParamConfig interfaceConfig);
    /**
     * 返回明文信息
     * */
    public  BaseResp<String> getPlaintext(String ciphertext, ChannelParamConfig interfaceConfig);
}

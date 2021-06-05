package com.ptg.channel.api;


import com.ptg.channel.resp.BaseResp;

/**
 * @Author xch
 * @Date 2021/6/2 16:19
 * @Version 1.0
 * @desc 对外提供统一的渠道对接，新的渠道对接：1.配置相关参数2.是否有适用的加密类，没有则在相应目录下编写3.http 发送接口是否有适用没有则编写
 **/
public interface ChannelInvokeService {
    BaseResp<String> invoke(String interfaceName, String params);
}

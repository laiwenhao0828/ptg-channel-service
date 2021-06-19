package com.ptg.ptgchannelimpl.impl;

import com.alibaba.fastjson.JSON;
import com.ptg.channel.api.ChannelInvokeService;
import com.ptg.channel.req.ChannelParamConfig;
import com.ptg.channel.req.ChannelSecretReq;
import com.ptg.channel.resp.BaseResp;
import com.ptg.channel.resp.RespCodeEnum;
import com.ptg.ptgchannelimpl.common.ChannelProcessService;
import com.ptg.ptgchannelimpl.util.ServiceTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author xch
 * @Date 2021/6/2 16:19
 * @Version 1.0
 **/

@Service(value = "channelInvokeService")
@Slf4j
public class ChannelInvokeServiceImpl implements ChannelInvokeService {
    @Autowired
    private ChannelProcessService channelProcessService;
    @Override
    public BaseResp<Map<String,Object>> invoke(String interfaceName, Map<String,Object> paramMap) {
        return ServiceTemplate.service(() -> {
            BaseResp<ChannelParamConfig> interfaceConfig = channelProcessService.getInterfaceConfig(interfaceName);
            if(!RespCodeEnum.SUCC.getCode().equals(interfaceConfig.getCode())){
                return BaseResp.error(interfaceConfig.getMessage());
            }else{
                ChannelParamConfig channelParamConfig = interfaceConfig.getData();
                BaseResp<String> channelReqBaseResp = channelProcessService.getChannelReq(channelParamConfig.getTemplateReq(), paramMap);
                if(!RespCodeEnum.SUCC.getCode().equals(channelReqBaseResp.getCode())){
                    return BaseResp.error(channelReqBaseResp.getMessage());
                }else{
                    String params = channelReqBaseResp.getData();
                    BaseResp ciphertext = channelProcessService.getCiphertext(params, channelParamConfig);
                    if(!RespCodeEnum.SUCC.getMessage().equals(ciphertext.getMessage())){
                        return BaseResp.error(ciphertext.getMessage());
                    }else{
                        ChannelSecretReq channelSecretReq = JSON.parseObject(JSON.toJSONString(ciphertext.getData()), ChannelSecretReq.class);
                        BaseResp baseResp = channelProcessService.handleParam(channelSecretReq, channelParamConfig);
                        if(!RespCodeEnum.SUCC.getCode().equals(baseResp.getCode())){
                            return BaseResp.error(baseResp.getMessage());
                        }else{
                            BaseResp<String> httpInvoke = channelProcessService.httpInvoke(channelParamConfig);
                            if(!RespCodeEnum.SUCC.getCode().equals(httpInvoke.getCode())){
                                return BaseResp.error(httpInvoke.getMessage());
                            }else{
                                String ciphertextChannelResp = httpInvoke.getData() + "";
                                BaseResp<String> plaintext = channelProcessService.getPlaintext(ciphertextChannelResp, channelParamConfig);
                                if(!RespCodeEnum.SUCC.getMessage().equals(plaintext.getMessage())){
                                    return BaseResp.error(plaintext.getMessage());
                                }else{
                                    return channelProcessService.getObject(plaintext.getData(), channelParamConfig.getInterfaceName());
                                }
                            }
                        }
                    }
                }
            }
        });
    }
}

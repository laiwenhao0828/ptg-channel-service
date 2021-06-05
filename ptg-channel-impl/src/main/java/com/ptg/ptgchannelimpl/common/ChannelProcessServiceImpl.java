package com.ptg.ptgchannelimpl.common;

import com.alibaba.fastjson.JSON;
import com.ptg.channel.po.ClChannelSecretConfig;
import com.ptg.channel.po.ClChannelSecretConfigExample;
import com.ptg.channel.req.ChannelHttpParamConfig;
import com.ptg.channel.req.ChannelParamConfig;
import com.ptg.channel.req.ChannelSecretReq;
import com.ptg.channel.resp.BaseResp;
import com.ptg.ptgchannelimpl.exception.GatewayException;
import com.ptg.ptgchannelimpl.mapper.ClChannelInterfaceConfigMapper;
import com.ptg.ptgchannelimpl.mapper.ClChannelSecretConfigMapper;
import com.ptg.ptgchannelimpl.mapper.ClHttpParamConfigMapper;
import com.ptg.ptgchannelimpl.util.Constants;
import com.ptg.ptgchannelimpl.util.HttpClientFactory;
import com.ptg.ptgchannelimpl.util.ServiceTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author xch
 * @Date 2021/6/1 19:37
 * @Version 1.0
 **/
@Service
@Slf4j
public class ChannelProcessServiceImpl implements ChannelProcessService {

    @Autowired
    private ClChannelInterfaceConfigMapper clChannelInterfaceConfigMapper;
    @Autowired
    private ClHttpParamConfigMapper clHttpParamConfigMapper;
    @Autowired
    private ClChannelSecretConfigMapper channelSecretConfigMapper;

    @Override
    public BaseResp<ChannelParamConfig> getInterfaceConfig(String interfaceName) {
        return ServiceTemplate.service(() -> {
            ChannelParamConfig channelParamConfig = clChannelInterfaceConfigMapper.queryConfigByInterfaceName(interfaceName);
            if (null == channelParamConfig) {
                return BaseResp.error("接口配置为空");
            } else {
                ClChannelSecretConfigExample clChannelSecretConfigExample = new ClChannelSecretConfigExample();
                clChannelSecretConfigExample.createCriteria().andKeyIdIn(buildKeyIds(channelParamConfig)).andDelFlagEqualTo(Constants.DEL_FLAG);
                List<ClChannelSecretConfig> clChannelSecretConfigs = channelSecretConfigMapper.selectByExample(clChannelSecretConfigExample);
                if (null == clChannelSecretConfigs || clChannelSecretConfigs.size() == 0) {
                    return BaseResp.error("秘钥配置为空");
                } else {
                    clChannelSecretConfigs.forEach(clChannelSecretConfig -> {
                        if (Constants.PRI_KEY_FLAG.equals(clChannelSecretConfig.getIsPriKey())) {
                            channelParamConfig.setPriKey(clChannelSecretConfig.getKeyValue());
                        } else {
                            channelParamConfig.setPubKey(clChannelSecretConfig.getKeyValue());
                        }
                    });
                    List<ChannelHttpParamConfig> channelHttpParamConfigList = clHttpParamConfigMapper.queryHttpParams(channelParamConfig.getHttpParamId());
                    if (null == channelHttpParamConfigList || channelHttpParamConfigList.size() == 0) {
                        return BaseResp.error("HTTP参数配置为空");
                    } else {
                        channelParamConfig.setClHttpParamConfigs(channelHttpParamConfigList);
                        return BaseResp.success(channelParamConfig);
                    }
                }
            }

        });
    }

    private List<String> buildKeyIds(ChannelParamConfig channelParamConfig) {
        List<String> keyIds = new ArrayList<>();
        keyIds.add(channelParamConfig.getPubKeyId());
        keyIds.add(channelParamConfig.getPriKeyId());
        return keyIds;
    }

    @SuppressWarnings("unchecked")
    @Override
    public BaseResp getCiphertext(String params, ChannelParamConfig channelParamConfig) {
        return ServiceTemplate.service(() -> {
            try {
                Class c = Class.forName(Constants.RELATIVE_PATH + channelParamConfig.getEncryFilter());
                //通过newInstance()获取对象实例。
                Object object = c.newInstance();
                Method encryParam = c.getMethod("encryParam", String.class, ChannelParamConfig.class);
                Object invoke = null;
                if (StringUtils.isEmpty(params)) {
                    invoke = encryParam.invoke(object, channelParamConfig.getTemplateReq(), channelParamConfig);
                } else {
                    invoke = encryParam.invoke(object, params, channelParamConfig);
                }
                return JSON.parseObject(JSON.toJSONString(invoke), BaseResp.class);
            } catch (ClassNotFoundException | InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                log.error("ChannelProcessServiceImpl.getCiphertext error:", e);
            }
            return BaseResp.error("获取密文失败");
        });
    }

    @Override
    public BaseResp handleParam(ChannelSecretReq channelSecretReq, ChannelParamConfig channelParamConfig) {
        return ServiceTemplate.service(() -> {
            List<ChannelHttpParamConfig> clHttpParamConfigs = channelParamConfig.getClHttpParamConfigs();
            clHttpParamConfigs.forEach(channelHttpParamConfig -> {
                if (Constants.CIPHERTEXT_FALG.equals(channelHttpParamConfig.getHttpParamValue())) {
                    channelHttpParamConfig.setHttpParamValue(channelSecretReq.getCiphertext());
                }
                if (Constants.SIGN_FALG.equals(channelHttpParamConfig.getHttpParamValue())) {
                    channelHttpParamConfig.setHttpParamValue(channelSecretReq.getSign());
                }
            });
            return BaseResp.success(channelParamConfig);
        });
    }

    @Override
    public BaseResp<String> httpInvoke(ChannelParamConfig channelParamConfig) {
        return ServiceTemplate.service(() -> {
            if (Constants.IS_TEST_FLAG.equals(channelParamConfig.getIsTest())) {
                return BaseResp.success(channelParamConfig.getTemplateResp());
            }
            try {
                HttpClientFactory.get().buildMethodCahe().buildSimpleConnectionPool().buildNoSSLCheckConnectionPool();
            } catch (GatewayException e) {
                log.error("ChannelProcessServiceImpl.httpInvoke error:", e);
            }
            Object[] obj = {channelParamConfig.getHttpHost(), channelParamConfig.getClHttpParamConfigs()};
            String resp = null;
            if (Objects.nonNull(HttpClientFactory.get().getMethod(channelParamConfig.getHttpMethod()))) {
                try {
                    resp = HttpClientFactory.get().methodInvoke(channelParamConfig.getHttpMethod(), channelParamConfig.getHttpHost(), obj);
                } catch (GatewayException e) {
                    log.error("ChannelProcessServiceImpl.httpInvoke error:", e);
                }
                log.info("返回信息" + resp);
            }
            if (StringUtils.isNotEmpty(resp)) {
                return BaseResp.success(resp);
            } else {
                return BaseResp.error("通道返回为空");
            }

        });
    }

    @Override
    public BaseResp<String> getPlaintext(String params, ChannelParamConfig channelParamConfig) {
        return ServiceTemplate.service(() -> {
            try {
                if (Constants.IS_TEST_FLAG.equals(channelParamConfig.getIsTest())) {
                    return BaseResp.success(params);
                }
                Class c = Class.forName(Constants.RELATIVE_PATH + channelParamConfig.getEncryFilter());
                //通过newInstance()获取对象实例。
                Object object = c.newInstance();
                Method encryParam = c.getMethod("decryParam", String.class, ChannelParamConfig.class);
                Object invoke = encryParam.invoke(object, params, channelParamConfig);
                return JSON.parseObject(JSON.toJSONString(invoke), BaseResp.class);
            } catch (ClassNotFoundException | InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                log.error("ChannelProcessServiceImpl.getPlaintext error:", e);
            }
            return BaseResp.error("获取明文失败");
        });
    }
}

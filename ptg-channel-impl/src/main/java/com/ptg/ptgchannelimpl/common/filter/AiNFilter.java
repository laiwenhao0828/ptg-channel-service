package com.ptg.ptgchannelimpl.common.filter;


import com.google.gson.Gson;
import com.ptg.channel.req.ChannelHttpParamConfig;
import com.ptg.channel.req.ChannelParamConfig;
import com.ptg.channel.req.ChannelSecretReq;
import com.ptg.channel.resp.AiNBaseResponse;
import com.ptg.channel.resp.BaseResp;
import com.ptg.ptgchannelimpl.util.SecurityEncryptUtil;
import com.ptg.ptgchannelimpl.util.SecurityKeyUtil;
import com.ptg.ptgchannelimpl.util.SecuritySignUtil;
import lombok.extern.slf4j.Slf4j;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.List;


/**
 * @Author xch
 * @Date 2021/6/4 15:50
 * @Version 1.0
 **/
@Slf4j
public class AiNFilter extends EncryDecryFilter{
    @Override
    public BaseResp<ChannelSecretReq> encryParam(String params, ChannelParamConfig channelParamConfig) {
        PublicKey ainongPublicKey = SecurityKeyUtil.getPubKeyByString(channelParamConfig.getPubKey(), SecurityKeyUtil.RSA_ALGORITHM);
        PrivateKey mctPrivateKey = SecurityKeyUtil.getPriKeyByString(channelParamConfig.getPriKey(), SecurityKeyUtil.RSA_ALGORITHM);
        String AESKey = SecurityKeyUtil.createAesKey();
        String encryptedData = SecurityEncryptUtil.encryptByAES(params, AESKey, SecurityEncryptUtil.AES_ENCRYPT_ALGORITHM);
        String encryptedKey = SecurityEncryptUtil.encrypt(AESKey, ainongPublicKey, SecurityEncryptUtil.RSA_ENCRYPT_ALGORITHM);
        List<ChannelHttpParamConfig> clHttpParamConfigs = channelParamConfig.getClHttpParamConfigs();
        String interfaceCode = "";
        String merchantNo = "";
        String spMerchantNo = "";
        String version = "";
        for(ChannelHttpParamConfig channelHttpParamConfig : clHttpParamConfigs){
            if("interfaceCode".equals(channelHttpParamConfig.getHttpParamName())){
                interfaceCode = channelHttpParamConfig.getHttpParamValue();
            }
            if("merchantNo".equals(channelHttpParamConfig.getHttpParamName())){
                merchantNo = channelHttpParamConfig.getHttpParamValue();
            }
            if("spMerchantNo".equals(channelHttpParamConfig.getHttpParamName())){
                spMerchantNo = channelHttpParamConfig.getHttpParamValue();
            }
            if("version".equals(channelHttpParamConfig.getHttpParamName())){
                version = channelHttpParamConfig.getHttpParamValue();
            }
        }
        ChannelHttpParamConfig channelHttpParamConfig = new ChannelHttpParamConfig();
        channelHttpParamConfig.setHttpParamName("encryptedKey");
        channelHttpParamConfig.setHttpParamValue(encryptedKey);
        clHttpParamConfigs.add(channelHttpParamConfig);
        String toSignData = "encryptedData=" + encryptedData + "&encryptedKey=" + encryptedKey + "&interfaceCode=" + interfaceCode + "&merchantNo=" + merchantNo + "&spMerchantNo=" + spMerchantNo + "&version=" + version;
        //用商户私钥对拼接后的数据做签名
        String signedData = SecuritySignUtil.sign(toSignData, mctPrivateKey, SecuritySignUtil.SHA_SIGN_ALGORITHM);
        ChannelSecretReq channelSecretReq = new ChannelSecretReq(signedData,encryptedData);
        return BaseResp.success(channelSecretReq);
    }

    @Override
    public BaseResp<String> decryParam(String params, ChannelParamConfig channelParamConfig) {
        PublicKey ainongPublicKey = SecurityKeyUtil.getPubKeyByString(channelParamConfig.getPubKey(), SecurityKeyUtil.RSA_ALGORITHM);
        PrivateKey mctPrivateKey = SecurityKeyUtil.getPriKeyByString(channelParamConfig.getPriKey(), SecurityKeyUtil.RSA_ALGORITHM);
        //工具类转换
        AiNBaseResponse response = new Gson().fromJson(params, AiNBaseResponse.class);
        String version = response.getVersion();
        String merchantNo = response.getMerchantNo();
        String interfaceCode = response.getInterfaceCode();
        String encryptedData = response.getEncryptedData();
        String encryptedKey = response.getEncryptedKey();
        String signedData = response.getSignedData();
        String toSignData = "encryptedData=" + encryptedData + "&encryptedKey=" + encryptedKey + "&interfaceCode=" + interfaceCode + "&merchantNo=" + merchantNo + "&version=" + version;
        boolean result = SecuritySignUtil.checkSign(toSignData, signedData, ainongPublicKey, SecuritySignUtil.SHA_SIGN_ALGORITHM);
        log.info("analysisResult验签结果:" + result);
        if (!result) {
            log.warn("analysisResult【" + interfaceCode + "】验签失败：");
            log.warn("******[analysisResult toSignData = " + toSignData + "]******");
            log.warn("******[analysisResult signedData = " + signedData + "]******");
            return BaseResp.error("验签失败");
        }
        String AESKey = "";
        String decryptData = "";
        try {
            AESKey = SecurityEncryptUtil.decrypt(encryptedKey, mctPrivateKey, SecurityEncryptUtil.RSA_ENCRYPT_ALGORITHM);
            decryptData = SecurityEncryptUtil.decryptByAES(encryptedData, AESKey, SecurityEncryptUtil.AES_ENCRYPT_ALGORITHM);
        } catch (Exception e) {
            log.warn("analysisResult【" + interfaceCode + "】验签失败：");
            log.warn("******[analysisResult encryptedData = " + encryptedData + "]******");
            return BaseResp.error("解密失败");
        }
        log.info("analysisResult 接收明文信息:" + decryptData);
        return BaseResp.success(decryptData);
    }
}

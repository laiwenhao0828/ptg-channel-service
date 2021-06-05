package com.ptg.ptgchannelimpl.util;

/**
 * @author: xu_ch
 * @date: 2021-06-05 17:59
 * @version: V1.0
 * @desc:
 **/
public class Constants {
    public static final String UTF8 = "UTF-8";
    public static final String RSA_ENCRYPT_ALGORITHM = "RSA/ECB/PKCS1Padding";//RSA加密模式
    public static final String AES_ENCRYPT_ALGORITHM = "AES/ECB/PKCS5Padding";//AES加密模式
    public static final String RSA_ALGORITHM = "RSA";//RSA秘钥生产算法
    public static final String SHA_SIGN_ALGORITHM = "SHA1WithRSA";//SHA签名算法
    public static final int HTTP_TIME_OUT = 300000;
    public static final String PRI_KEY_FLAG = "1";//私钥
    public static final String DEL_FLAG = "1";//可用
    public static final String RELATIVE_PATH = "com.ptg.ptgchannelimpl.common.filter.";//加密的类的相对路径
    public static final String CIPHERTEXT_FALG = "$param$";//密文标识
    public static final String SIGN_FALG = "$sign$";//签名标识
    public static final String HTTP_HEAD_FALG = "$head$";//头部标识
    public static final String IS_TEST_FLAG = "2";//2测试模式返回挡板信息
}


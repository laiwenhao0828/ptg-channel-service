package com.ptg.channel.req;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author xch
 * @Date 2021/6/2 10:45
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
public class ChannelSecretReq {
    private String sign;
    private String ciphertext;
}

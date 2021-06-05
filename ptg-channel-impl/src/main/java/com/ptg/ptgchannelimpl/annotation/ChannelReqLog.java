package com.ptg.ptgchannelimpl.annotation;

import java.lang.annotation.*;

/**
 * @author xuconghui
 * @Date 2020/11/17 15:25
 * @description
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ChannelReqLog {
    String channelType() default "01";
    String channelDesc() default "";//渠道描述
}

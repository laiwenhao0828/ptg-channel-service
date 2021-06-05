package com.ptg.ptgchannelimpl.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author xch
 * @Date 2020/12/3 20:18
 * @Version 1.0
 **/
@Component
@ConfigurationProperties(prefix = "ptg")
@PropertySource("classpath:ptg.properties")
@Getter
@Setter
public class PtgConfig {
    private String publicKey;
    private String privateKey;
}

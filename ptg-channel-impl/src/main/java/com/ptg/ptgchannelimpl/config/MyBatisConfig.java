package com.ptg.ptgchannelimpl.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * @author denghailong
 * @date 2020/11/6
 */
@org.springframework.context.annotation.Configuration
public class MyBatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return  (Configuration configuration) -> configuration.setMapUnderscoreToCamelCase(true);
    }
}


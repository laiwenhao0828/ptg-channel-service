package com.ptg.ptgchannelimpl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.ptg.ptgchannelimpl.*")
@MapperScan("com.ptg.ptgchannelimpl.mapper")
@SpringBootApplication
public class PtgChannelImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(PtgChannelImplApplication.class, args);
    }

}

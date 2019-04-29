package com.zhangxiwei.weather.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Xiweiiii
 * @Since 2019/4/29
 */
@Configuration
public class HttpRestConfig {

    @Autowired
    private RestTemplateBuilder templateBuilder;

    @Bean
    public RestTemplate restTemplate() {
        return templateBuilder.build();
    }

}

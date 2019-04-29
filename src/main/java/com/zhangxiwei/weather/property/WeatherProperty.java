package com.zhangxiwei.weather.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author Xiweiiii
 * @Since 2019/4/29
 */
@Configuration
@PropertySource({"classpath:application.yaml"})
public class WeatherProperty {
    @Value("${weather.api}")
    private String api;

    public String getApi() {
        return api;
    }
}

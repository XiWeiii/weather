package com.zhangxiwei.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhangxiwei.weather.entity.Weather;
import com.zhangxiwei.weather.property.WeatherProperty;
import com.zhangxiwei.weather.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * 天气信息的获取
 *
 * @Author Xiweiiii
 * @Since 2019/4/29
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeatherProperty weatherProperty;

    @Override
    public Weather getDataByCityId(String cityId) {
        String url = weatherProperty.getApi() + cityId;
        return getWeatherData(url);
    }

    @Override
    public Weather getDataByCityName(String cityName) {
        String url = weatherProperty + cityName;
        return getWeatherData(url);
    }

    /**
     * 通过天气接口获取天气信息
     * @param apiUrl
     * @return
     */
    private Weather getWeatherData(String apiUrl) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        String data = null;
        Weather weather = null;
        ObjectMapper objectMapper = new ObjectMapper();
        if (responseEntity.getStatusCodeValue() == 200) {
            data = responseEntity.getBody();
        }
        try {
            weather = objectMapper.readValue(data, Weather.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weather;
    }
}

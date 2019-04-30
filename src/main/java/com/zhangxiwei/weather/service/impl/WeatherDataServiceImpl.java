package com.zhangxiwei.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhangxiwei.weather.entity.Weather;
import com.zhangxiwei.weather.property.WeatherProperty;
import com.zhangxiwei.weather.service.WeatherDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

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
     *
     * @param apiUrl
     * @return
     */
    private Weather getWeatherData(String apiUrl) {
        String data = null;
        Weather weather = null;
        ValueOperations<String,Weather> valueOperations = redisTemplate.opsForValue();
        ObjectMapper objectMapper = new ObjectMapper();
        //如果redis中包含有该key则从Redis中读取数据,否则向天气接口发出请求获取数据
        if (redisTemplate.hasKey(apiUrl)) {
            logger.info("从Redis中读取>>>>>>>>>");
            weather = valueOperations.get(apiUrl);
        } else {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
            if (responseEntity.getStatusCodeValue() == 200) {
                data = responseEntity.getBody();
            }
            try {
                weather = objectMapper.readValue(data, Weather.class);
                //将对象存入至redis中，apiUrl作为key
                valueOperations.set(apiUrl,weather);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return weather;
    }
}

package com.zhangxiwei.weather.service;

import com.zhangxiwei.weather.entity.Weather;

public interface WeatherDataService {

    /**
     * 获取天气信息
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);

    /**
     * 获取天气信息
     * @param cityName
     * @return
     */
    Weather getDataByCityName(String cityName);

    void syncWeatherDataByCityId(String cityId);
}

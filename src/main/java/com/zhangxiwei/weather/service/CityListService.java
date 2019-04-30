package com.zhangxiwei.weather.service;

import com.zhangxiwei.weather.entity.CityList;

import java.util.List;

/**
 * 从JSON文件获取所有的城市
 *
 * @Author Xiweiiii
 * @Since 2019/4/30
 */
public interface CityListService {

    List<CityList> getAllCity();

}

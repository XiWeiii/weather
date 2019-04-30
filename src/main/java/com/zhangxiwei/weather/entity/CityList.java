package com.zhangxiwei.weather.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * 城市列表
 *
 * @Author Xiweiiii
 * @Since 2019/4/30
 */

@Data
public class CityList {

    /**
     * _id : 1
     * id : 1
     * pid : 0
     * city_code : 101010100
     * city_name : 北京
     */

    private int _id;
    private int id;
    private int pid;
    private String city_code;
    private String city_name;
}

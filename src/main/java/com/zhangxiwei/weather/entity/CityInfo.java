package com.zhangxiwei.weather.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class CityInfo implements Serializable {

    private static final long serialVersionUID = -7270871946608788470L;
    private String city;
    private String cityId;
    private String parent;
    private String updateTime;
}

package com.zhangxiwei.weather.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Weather implements Serializable {


    private static final long serialVersionUID = 2284135106153484326L;
    private String time;
    private CityInfo cityInfo;
    private String date;
    private String message;
    private int status;
    private com.zhangxiwei.weather.entity.Data data;
}

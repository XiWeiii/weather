package com.zhangxiwei.weather.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Yesterday implements Serializable {

    private static final long serialVersionUID = -4961214336981200088L;
    private String date;
    private String sunrise;
    private String high;
    private String low;
    private String sunset;
    private int aqi;
    private String ymd;
    private String week;
    private String fx;
    private String fl;
    private String type;
    private String notice;
}

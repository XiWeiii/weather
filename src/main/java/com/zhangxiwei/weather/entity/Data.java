package com.zhangxiwei.weather.entity;

import java.io.Serializable;
import java.util.List;

@lombok.Data
public class Data implements Serializable {

    private static final long serialVersionUID = 4488394754200093995L;
    private String shidu;
    private int pm25;
    private int pm10;
    private String quality;
    private String wendu;
    private String ganmao;
    private Yesterday yesterday;
    private List<Forecast> forecast;
}

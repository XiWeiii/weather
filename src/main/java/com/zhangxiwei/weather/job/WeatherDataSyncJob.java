package com.zhangxiwei.weather.job;

import com.zhangxiwei.weather.entity.CityList;
import com.zhangxiwei.weather.service.CityListService;
import com.zhangxiwei.weather.service.WeatherDataService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * 天气数据同步任务
 *
 * @Author Xiweiiii
 * @Since 2019/4/30
 */
public class WeatherDataSyncJob extends QuartzJobBean {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private CityListService cityListService;

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("同步任务开始>>>>>>>>");
        List<CityList> allCity = cityListService.getAllCity();
        //遍历每一个城市的信息
        for (CityList city :
                allCity) {
            logger.info(city.toString());
            weatherDataService.syncWeatherDataByCityId(city.getCity_code());
        }
        logger.info("同步任务已经完成>>>>>>>>>>>");
    }
}

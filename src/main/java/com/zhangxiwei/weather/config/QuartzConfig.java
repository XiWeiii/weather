package com.zhangxiwei.weather.config;

import com.zhangxiwei.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 天气同步任务配置
 *
 * @Author Xiweiiii
 * @Since 2019/4/30
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail weatherDataSyncJobDetail() {
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob").storeDurably()
                .build();
    }

    /**
     * Trigger 定义什么时候触发一个任务
     *
     * .withIntervalInHours(5) 执行频率为5个小时一次
     *
     * @return
     */
    @Bean
    public Trigger sampleJobTrigger() {
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInHours(5).repeatForever();
        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail()).withIdentity("weatherDataSyncTrigger")
                .withSchedule(simpleScheduleBuilder).build();

    }

}

package com.zhangxiwei.weather.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhangxiwei.weather.entity.CityList;
import com.zhangxiwei.weather.service.CityListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author Xiweiiii
 * @Since 2019/4/30
 */

@Service
public class CityListServiceImpl implements CityListService {

    private final static Logger logger = LoggerFactory.getLogger(CityListServiceImpl.class);

    @Override
    public List<CityList> getAllCity() {
        File file = new File("C:\\Users\\11156\\IdeaProjects\\learn_cloud\\weather\\src\\main\\resources\\city.json");
        ObjectMapper mapper = new ObjectMapper();
        List<CityList> citys = null;
        try {
            citys = mapper.readValue(file, new TypeReference<List<CityList>>() {});
        } catch (IOException e) {
            logger.info("读取失败");
        }
        return citys;
    }
}

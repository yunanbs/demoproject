package com.yu.demo.exceldemo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yunan on 2017/5/12.
 */
@FeignClient(
        name = "hefeng",
        url = "https://free-api.heweather.com/v5/"
)
public interface HeFengProxy
{
    @RequestMapping(value = "/now",method = RequestMethod.GET)
    String getNowWeatherInfo(@RequestParam("city") String city, @RequestParam("key")String key);
}

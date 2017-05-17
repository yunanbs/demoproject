package com.yu.demo.exceldemo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yunan on 2017/5/13.
 */
@FeignClient(
        name = "test",
        url = "http://localhost:8001"
)
public interface TestProxy
{
    @RequestMapping(value = "/add",method = RequestMethod.POST,consumes = "application/json;chartset=utf-8")
    String add(@RequestBody String params);
}

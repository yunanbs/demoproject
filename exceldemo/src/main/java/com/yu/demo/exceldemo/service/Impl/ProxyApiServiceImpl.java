package com.yu.demo.exceldemo.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.yu.demo.exceldemo.service.HeFengProxy;
import com.yu.demo.exceldemo.service.ProxyApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yunan on 2017/5/12.
 */
@Service
public class ProxyApiServiceImpl implements ProxyApiService
{
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HeFengProxy heFengProxy;


    @Override
    public String consumeApiByRestTemplate(String url, String body)
    {
        String resutl = "";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);


        if (null == body || "".equals(body))
        {
            HttpEntity httpEntity = new HttpEntity(httpHeaders);

            resutl = restTemplate.exchange(url,HttpMethod.GET,httpEntity,String.class).getBody();
        } else
        {
            HttpEntity<JSONObject> httpEntity = new HttpEntity<JSONObject>(JSONObject.parseObject(body), httpHeaders);

            resutl = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class).getBody();

        }
        return resutl;
    }
}

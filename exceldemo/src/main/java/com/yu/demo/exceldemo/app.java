package com.yu.demo.exceldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yunan on 2017/5/8.
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients
public class app
{
    public static void main(String... args){
        SpringApplication.run(app.class,args);
    }

    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}

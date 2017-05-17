package com.yu.demo.testapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by yunan on 2017/5/13.
 */
@SpringBootApplication
@MapperScan("com.yu.demo.testapi.dao")
public class app
{
    public static void main(String... args){
        SpringApplication.run(app.class,args);
    }
}

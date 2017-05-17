package com.yu.demo.testapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Created by yunan on 2017/5/16.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String USERNAME;
    private String PASSWORD;
    private int STATE;
    private String CREATED;
    private String MODIFYED;
}

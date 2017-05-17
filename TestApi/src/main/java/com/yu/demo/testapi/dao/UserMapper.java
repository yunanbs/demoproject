package com.yu.demo.testapi.dao;

import com.yu.demo.testapi.entity.User;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by yunan on 2017/5/16.
 */
public interface UserMapper {

    @Insert("insert into users(username,password,state,created,modifyed) values(#{USERNAME},#{PASSWORD},#{STATE},#{CREATED},#{MODIFYED})")
    int addUser(User user);
}

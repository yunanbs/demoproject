package com.yu.demo.testapi.controller;

import com.alibaba.fastjson.JSONObject;
import com.yu.demo.testapi.dao.UserMapper;
import com.yu.demo.testapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yunan on 2017/5/13.
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.GET})
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public JSONObject add(@RequestBody final String params) {
        JSONObject jsonObject = new JSONObject();
        JSONObject paramsJson = JSONObject.parseObject(params);
        jsonObject.put("result", paramsJson.getIntValue("x") + paramsJson.getIntValue("y")+paramsJson.getIntValue("z"));
        return jsonObject;
    }

    @RequestMapping(value = "/upload")
    public String fileUpload(@RequestParam("file") final MultipartFile[] files) throws IOException {
        String filePath = "d:\\";
        List<MultipartFile> listmMultipartFiles = Arrays.asList(files);
        for (Iterator iterator = listmMultipartFiles.iterator(); iterator.hasNext(); ) {
            MultipartFile file = (MultipartFile) iterator.next();
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(String.format("%s%s", filePath, file.getOriginalFilename())));
            out.write(file.getBytes());
            out.flush();
            out.close();
        }
        return "succeed";
    }

    @RequestMapping(value = "/user",consumes = "application/json",method = {RequestMethod.POST})
    public User addUser(@RequestBody User user){
        user.setSTATE(1);
        userMapper.addUser(user);

        return  user;
    }
}

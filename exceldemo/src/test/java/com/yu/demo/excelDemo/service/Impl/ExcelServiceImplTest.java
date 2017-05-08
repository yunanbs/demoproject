package com.yu.demo.excelDemo.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yu.demo.excelDemo.service.ExcelService;
import com.yu.demo.excelDemo.utils.ZipUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by yunan on 2017/5/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = com.yu.demo.excelDemo.app.class)
public class ExcelServiceImplTest
{
    @Autowired
    private ExcelService excelService;


    @Test
    public void createExcelFile() throws Exception
    {
        JSONArray sourceData = new JSONArray();
        JSONObject tmpdata = new JSONObject();

        tmpdata = new JSONObject();
        tmpdata.put("name","test");
        tmpdata.put("age","1");
        sourceData.add(tmpdata);

        tmpdata = new JSONObject();
        tmpdata.put("name","test");
        tmpdata.put("age","2");
        sourceData.add(tmpdata);

        tmpdata = new JSONObject();
        tmpdata.put("name","test");
        tmpdata.put("age","3");
        sourceData.add(tmpdata);

        excelService.createExcelFile(sourceData,"d:/logs/test.xls");


        String filePath = "D:\\logs\\ccjoin\\assist";
        String zipName = "D:\\logs\\ccjoin\\assist\\test.zip";

        ZipUtil.createZipFile(filePath,zipName);
    }

}
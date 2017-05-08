package com.yu.demo.excelDemo.service;

import com.alibaba.fastjson.JSONArray;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by yunan on 2017/5/8.
 */
public interface ExcelService
{
    String createExcelFile(JSONArray sourceData, String fileFullName) throws IOException;
}

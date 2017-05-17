package com.yu.demo.exceldemo.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yu.demo.exceldemo.service.ExcelService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by yunan on 2017/5/8.
 */
@Service
public class ExcelServiceImpl implements ExcelService
{

    @Override
    public String createExcelFile(JSONArray sourceData, String fileFullName) throws IOException
    {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("sheet1");
        HSSFCellStyle borderStyle = workbook.createCellStyle();
        borderStyle.setBorderBottom(BorderStyle.THIN);
        borderStyle.setBorderLeft(BorderStyle.THIN);
        borderStyle.setBorderRight(BorderStyle.THIN);
        borderStyle.setBorderTop(BorderStyle.THIN);

        JSONObject header = (JSONObject) sourceData.getJSONObject(0).clone();
        String[] keys = new String[header.keySet().size()];
        header.keySet().toArray(keys);
        for(String key:keys){
            header.put(key,key);
        }
        sourceData.add(0,header);


        for (int i = 0; i < sourceData.size(); i++)
        {
            JSONObject tmpData = sourceData.getJSONObject(i);
            HSSFRow tmpRow = sheet.createRow(i);
            for (int j = 0; j < keys.length; j++)
            {
                HSSFCell tmpCell = tmpRow.createCell(j, CellType.STRING);
                tmpCell = tmpRow.createCell(j, CellType.STRING);
                tmpCell.setCellValue(tmpData.getString(keys[j]));
                tmpCell.setCellStyle(borderStyle);
            }
        }

        FileOutputStream fileOutputStream = new FileOutputStream(fileFullName);
        workbook.write(fileOutputStream);
        fileOutputStream.close();

        return null;
    }
}

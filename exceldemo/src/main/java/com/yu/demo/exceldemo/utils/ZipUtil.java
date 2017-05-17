package com.yu.demo.exceldemo.utils;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by yunan on 2017/5/8.
 */
public class ZipUtil
{
    public static void createZipFile(String filePath, String zipFileFullName) throws IOException
    {

        InputStream inputStream = null;
        File file = new File(filePath);
        File zipFile = new File(zipFileFullName);
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));
        if (file.isDirectory())
        {
            File[] listFiles = file.listFiles();
            for (int i = 0; i < listFiles.length; i++)
            {
                if(listFiles[i].getName().equals(zipFile.getName()))
                {
                    continue;
                }
                inputStream = new FileInputStream(listFiles[i]);
                zipOutputStream.putNextEntry(new ZipEntry(String.format("%s/%s",file.getName(),listFiles[i].getName())));
                byte[] buffer = new byte[1024];
                while (inputStream.read(buffer)>0){
                    zipOutputStream.write(buffer);
                }
                inputStream.close();
            }
        }

        zipOutputStream.close();
    }
}

package com.szatc.cdm.common.util;

import java.io.File;
import java.io.FileInputStream;

public class FileUtil {

    public static   String readToString(String fileName){
        String encoding="UTF-8";
        try{
            File file=new File(fileName);
            Long fileLen=file.length();
            byte[] fileContent=new byte[fileLen.intValue()];

            FileInputStream in=new FileInputStream(file);
            in.read(fileContent);
            in.close();
            return new String(fileContent,encoding);

        }catch (Exception ex){

            return null;
        }

    }
}

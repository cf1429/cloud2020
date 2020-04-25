package com.atguigu.springcloud.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author cf
 * @create 2020\4\22 0022
 */
public class FileTools {
    /**
     * 图片上传
     * @author cf
     * @param file
     * @param filePath
     * @param fileName
     */
    public static void uploadFiles(byte[] file, String filePath, String fileName) throws IOException {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(filePath +"/"+ fileName);
        fileOutputStream.write(file);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    /**
     * @author cf
     * @param fileName
     * @return
     */
    public static String renameToUUId(String fileName){
        return UUID.randomUUID().toString().replace("-","")+"."+fileName.substring(fileName.lastIndexOf(".")+1);
    }




}

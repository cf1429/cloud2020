package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.StrUtil;
import com.atguigu.springcloud.config.UploadConfig;
import com.atguigu.springcloud.dao.KcFileDao;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.KcFile;
import com.atguigu.springcloud.service.FileUploadService;
import com.atguigu.springcloud.utils.FileTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author cf
 * @create 2020\4\22 0022
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Autowired
    private UploadConfig uploadConfig;
    @Autowired
    private KcFileDao kcFileDao;

    @Override
    public CommonResult<Object> fileUpload(MultipartFile file, String pathPrefix) {
       CommonResult<Object> commonResult = new CommonResult<>();
       if(file == null || file.isEmpty()){
           commonResult.setMessage("文件为空");
           return commonResult;
       }

       String fileName = file.getOriginalFilename();
       String fileSecondName = FileTools.renameToUUId(fileName);
       if(StrUtil.isBlank(fileSecondName)){
           commonResult.setMessage("请选择正确的文件");
           return commonResult;
       }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String filePath = uploadConfig.getUploadPath();
        try {
            FileTools.uploadFiles(file.getBytes(), filePath,fileSecondName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = uploadConfig.getStaticAccessPath()+"/"+fileSecondName;
        KcFile kcFile = new KcFile();
        kcFile.setFileName(fileName);
        kcFile.setFileSecondName(fileSecondName);
        kcFile.setFilePath(pathPrefix+url);
        kcFile.setCreateTime(new Date());
        int num = kcFileDao.create(kcFile);
        if(num >0){
            commonResult.setData(kcFile.getId());
        }else{
            commonResult.setMessage("上传附件失败，亲重新上传");
        }
        return commonResult;
    }
}

package com.atguigu.springcloud;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author cf
 * @create 2020\4\22 0022
 */
public interface FileUploadService {
    public CommonResult<Object> fileUpload(MultipartFile file , String pathPrefix);
}

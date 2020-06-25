package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cf
 * @create 2020\4\23 0023
 */
@Slf4j
@RestController
@RequestMapping(value = {"/","/api/file"})
@CrossOrigin
public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;
    @PostMapping(value = "/fileUpload")
    public CommonResult<Object> fileUpload(HttpServletRequest request,
                                           @RequestParam(value = "file") MultipartFile file){
        log.info("调用附件上传接口---------fileUpload------");
        CommonResult<Object> commonResult = fileUploadService.fileUpload(file, request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort());
        return commonResult;
    }



}

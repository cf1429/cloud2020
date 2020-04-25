package com.atguigu.springcloud.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author cf
 * @create 2020\4\22 0022
 */
@Component
@ConfigurationProperties(prefix = "preread")
public class UploadConfig {
    //上传路径
    private String uploadPath;
    private String staticAccessPath;

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getStaticAccessPath() {
        return staticAccessPath;
    }

    public void setStaticAccessPath(String staticAccessPath) {
        this.staticAccessPath = staticAccessPath;
    }
}

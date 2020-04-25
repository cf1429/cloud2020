package com.atguigu.springcloud.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * @author cf
 * @create 2020\4\25 0025
 */
public class KcFile implements Serializable {
    private Integer id;
    private String fileName;
    private String fileSecondName;
    private String fileType;
    private String filePath;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSecondName() {
        return fileSecondName;
    }

    public void setFileSecondName(String fileSecondName) {
        this.fileSecondName = fileSecondName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", fileSecondName='" + fileSecondName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", filePath='" + filePath + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

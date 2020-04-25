package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.KcFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface KcFileDao {
    // 添加文件记录
    int create(KcFile kcFile);
    // 修改文件记录
    int updateKcFile(KcFile kcFile);
    // 文件记录列表查询
    List<KcFile> findKcFileList(Map<String, Object> map);
    int findKcFileListCount(Map<String, Object> map);
    // 根据id查找文件信息
    KcFile findKcFileById(Integer id);

}

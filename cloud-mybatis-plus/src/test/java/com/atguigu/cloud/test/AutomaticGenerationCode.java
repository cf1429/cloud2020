package com.atguigu.cloud.test;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * mybatis-plus 代码生成器
 */
public class AutomaticGenerationCode {
    public static void main(String[] args) {
        // 需要构建一个代码自动生成器对象
        AutoGenerator mpg = new AutoGenerator();
        //配置策略


        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //获取当前项目路径
        String propertyPath = System.getProperty("user.dir");
        //自动生成代码存放路径
        gc.setOutputDir(propertyPath+"/cloud-mybatis-plus/src/main/java");
        gc.setAuthor("cf");
        gc.setOpen(false);  // 是否打开资源管理器，即生成代码的存放的文件夹
        gc.setFileOverride(false);  //是否覆盖之前的代码
        gc.setServiceName("%sService");  //去service的I前缀
        gc.setIdType(IdType.ID_WORKER);  // id的策略
        gc.setDateType(DateType.ONLY_DATE);  // 日期格式，仅仅是日期
        gc.setSwagger2(true);   //设置swagger
        mpg.setGlobalConfig(gc);

        //设置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://8.133.170.159:3306/db2020?useUnicode=true&characterEncoding=utf8&useSSL=false&tinyInt1isBit=true");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("awnjqq58");
        dataSourceConfig.setDbType(DbType.MYSQL);
        mpg.setDataSource(dataSourceConfig);

        //包的设置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.atguigu.cloud");  //包的最外层
        pc.setEntity("entiy");    // 实体类
        pc.setMapper("mapper");   // mapper即dao
        pc.setService("service"); //service
        pc.setController("controller"); //controller
        mpg.setPackageInfo(pc);

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("book","order","user_order");   //设置要映射的表名,即需要生成代码的表名称
        strategyConfig.setNaming(NamingStrategy.underline_to_camel); //将数据库字段中的下划线转成驼峰命名
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);  //自动支持lombok
        strategyConfig.setLogicDeleteFieldName("deleted");
        //自动填充配置
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        List<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(updateTime);
        strategyConfig.setTableFillList(tableFills);

        //乐管锁配置
        strategyConfig.setVersionFieldName("version");

        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setControllerMappingHyphenStyle(true); /// localhost:8080/hello_id_2
        mpg.setStrategy(strategyConfig);
        mpg.execute();  //执行


    }
}

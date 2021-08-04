package com.cf.test;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:chenf
 * @Date:2021/8/4 15:26
 * @describe
 */
public class FreemarkTest {
    public static void main(String[] args) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.getVersion());
        configuration.setDirectoryForTemplateLoading(new File("D:\\test\\RreeMark"));
        configuration.setDefaultEncoding("utf-8");
        Template template = configuration.getTemplate("test.ftl");
        Map model = new HashMap();
        model.put("hello","测试数据");
        Writer writer = new FileWriter(new File("D:\\test\\RreeMark\\test.html"));
        template.process(model,writer);
        writer.close();
    }
}

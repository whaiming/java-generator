package org.mybatis.generator.codegen.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.mybatis.generator.codegen.freemarker.TemplateEntity.ServiceTemplateEntity;
import org.mybatis.generator.internal.JavaFileMergerJaxp;

import java.io.*;

import java.util.List;

import static org.mybatis.generator.codegen.freemarker.FreemarkerUtil.generateFreemarkerFile;
import static org.springframework.util.FileCopyUtils.copy;


/**
 * 通过解析serviceTemplate生成对应的service
 * Created by whm on 2017/7/26.
 */
public class JavaServiceGenerator {

    public static void addJavaServiceGenerator(List<ServiceTemplateEntity> serviceTemplateEntityList) {
        Configuration cfg = new Configuration();
        try {
            for (ServiceTemplateEntity s : serviceTemplateEntityList) {
                cfg.setClassForTemplateLoading(JavaServiceGenerator.class, "/template"); //指定模板所在的classpath目录
                Template t = cfg.getTemplate("ServiceTemplate"); //指定模板
                File f = new File(System.getProperty("user.dir") + "/" + s.getProjectTargetPackage());
                f.mkdirs();
                String filePath = System.getProperty("user.dir") + "/" + s.getProjectTargetPackage() + s.getClassName() + ".java";
                File file = new File(filePath);
                generateFreemarkerFile(file ,t,s);
            }
        } catch  (IOException e) {
        e.printStackTrace();
        }
    }
}

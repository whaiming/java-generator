package org.mybatis.generator.codegen.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.mybatis.generator.codegen.freemarker.TemplateEntity.ServiceTemplateEntity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.util.List;


/**
 * 通过解析serviceTemplate生成对应的service
 * Created by whm on 2017/7/26.
 */
public class JavaServiceGenerator {

    public static void addJavaServiceGenerator(List<ServiceTemplateEntity> serviceTemplateEntitylist) {
        Configuration cfg = new  Configuration();
        try  {
            for (ServiceTemplateEntity s:serviceTemplateEntitylist) {
                cfg.setClassForTemplateLoading(JavaServiceGenerator.class, "/template"); //指定模板所在的classpath目录
                Template t = cfg.getTemplate("ServiceTemplate"); //指定模板
                File f = new File(System.getProperty("user.dir") +"/"+ s.getProjectTargetPackage());
                f.mkdirs();
                FileOutputStream fos = new FileOutputStream(new File(System.getProperty("user.dir") +"/"+ s.getProjectTargetPackage() + s.getClassName()+".java")); //java文件的生成目录
                t.process(s, new OutputStreamWriter(fos, "utf-8")); //
                fos.flush();
                fos.close();
            }
        } catch  (IOException e) {
            e.printStackTrace();
        } catch  (TemplateException e) {
            e.printStackTrace();
        }

    }
}

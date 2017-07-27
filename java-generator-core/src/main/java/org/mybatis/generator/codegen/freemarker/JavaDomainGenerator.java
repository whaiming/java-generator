package org.mybatis.generator.codegen.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.mybatis.generator.codegen.freemarker.TemplateEntity.DomainTemplateEntity;
import org.mybatis.generator.codegen.freemarker.TemplateEntity.ServiceTemplateEntity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * Created by whm on 2017/7/26.
 */
public class JavaDomainGenerator {
    public static void addJavaDomainGenerator(List<DomainTemplateEntity> domainTemplateEntities) {
        Configuration cfg = new  Configuration();
        try  {
            for (DomainTemplateEntity d:domainTemplateEntities) {
                DomainTemplateEntity.DomainTemplate domainTemplate = d.getDomainTemplate();
                DomainTemplateEntity.NativeDomainTemplate nativeDomainTemplate = d.getNativeDomainTemplate();
                cfg.setClassForTemplateLoading(JavaServiceGenerator.class, "/template"); //指定模板所在的classpath目录
                Template t = cfg.getTemplate("DomainTemplate"); //指定模板
                File f = new File(System.getProperty("user.dir") +"/"+ domainTemplate.getProjectTargetPackage());
                f.mkdirs();
                FileOutputStream fos = new FileOutputStream(new File(System.getProperty("user.dir") +"/"+ domainTemplate.getProjectTargetPackage() + domainTemplate.getDomainInterface()+".java")); //java文件的生成目录
                t.process(domainTemplate, new OutputStreamWriter(fos, "utf-8")); //
                Configuration cfg1 = new  Configuration();
                cfg1.setClassForTemplateLoading(JavaServiceGenerator.class, "/template"); //指定模板所在的classpath目录
                Template t1 = cfg1.getTemplate("NativeDomainTemplate"); //指定模板
                FileOutputStream fos1 = new FileOutputStream(new File(System.getProperty("user.dir") +"/"+ nativeDomainTemplate.getProjectTargetPackage() + nativeDomainTemplate.getNativeDomainClazz()+".java")); //java文件的生成目录
                t1.process(nativeDomainTemplate, new OutputStreamWriter(fos1, "utf-8")); //
                fos.flush();
                fos.close();
                fos1.flush();
                fos1.close();
            }
        } catch  (IOException e) {
            e.printStackTrace();
        } catch  (TemplateException e) {
            e.printStackTrace();
        }

    }
}

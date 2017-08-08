package org.mybatis.generator.codegen.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.mybatis.generator.codegen.freemarker.TemplateEntity.DomainTemplateEntity;
import org.mybatis.generator.codegen.freemarker.TemplateEntity.ServiceTemplateEntity;

import java.io.*;
import java.util.List;

import static org.mybatis.generator.codegen.freemarker.FreemarkerUtil.generateFreemarkerFile;

/**
 * Created by whm on 2017/7/26.
 */
public class JavaDomainGenerator {
    public static void addJavaDomainGenerator(List<DomainTemplateEntity> domainTemplateEntities) {
        try  {
            for (DomainTemplateEntity d:domainTemplateEntities) {
                Configuration cfg = new  Configuration();
                DomainTemplateEntity.DomainTemplate domainTemplate = d.getDomainTemplate();
                DomainTemplateEntity.NativeDomainTemplate nativeDomainTemplate = d.getNativeDomainTemplate();
                cfg.setClassForTemplateLoading(JavaDomainGenerator.class, "/template"); //指定模板所在的classpath目录
                Template t = cfg.getTemplate("DomainTemplate"); //指定模板
                File f = new File(System.getProperty("user.dir") +"/"+ domainTemplate.getProjectTargetPackage());
                f.mkdirs();
                File domainFile = new File(System.getProperty("user.dir") +"/"+ domainTemplate.getProjectTargetPackage() + domainTemplate.getDomainInterface()+".java");
                generateFreemarkerFile(domainFile,t,domainTemplate);
                Configuration cfg1 = new  Configuration();
                cfg1.setClassForTemplateLoading(JavaDomainGenerator.class, "/template"); //指定模板所在的classpath目录
                Template t1 = cfg1.getTemplate("NativeDomainTemplate"); //指定模板
                File nativeDomainFile = new File(System.getProperty("user.dir") +"/"+ nativeDomainTemplate.getProjectTargetPackage() + nativeDomainTemplate.getNativeDomainClazz()+".java");

                generateFreemarkerFile(nativeDomainFile,t1,nativeDomainTemplate);

            }
        } catch  (IOException e) {
            e.printStackTrace();
        }

    }
}

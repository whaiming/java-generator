package org.mybatis.generator.codegen.freemarker.TemplateEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by whm on 2017/7/26.
 */
public class ServiceTemplateEntity implements TemplateEntity{
    private String templatePackage;//包名
    private String modelPackage;//所需要导入的model包
    private String mapperPackage;//所需要导入的mapper包
    private String className;//生成的Service类名
    private String mapperType;//对应的Mapper类
    private String mapperName;//Mapper类的实例对象名
    private String modelClazz;//对应的model类
    private String projectTargetPackage;//Service生成的目标工程包
    private String generatedDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());//代码生成日期
    private String generatedTime =  new SimpleDateFormat("HH:mm").format(new Date());//代码生成时间
    private boolean columnsHasBLOB;//是否包含BLOB字段

    public String getTemplatePackage() {
        return templatePackage;
    }

    public void setTemplatePackage(String templatePackage) {
        this.templatePackage = templatePackage;
    }

    public String getModelPackage() {
        return modelPackage;
    }

    public void setModelPackage(String modelPackage) {
        this.modelPackage = modelPackage;
    }

    public String getMapperPackage() {
        return mapperPackage;
    }

    public void setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMapperType() {
        return mapperType;
    }

    public void setMapperType(String mapperType) {
        this.mapperType = mapperType;
    }

    public String getMapperName() {
        return mapperName;
    }

    public void setMapperName(String mapperName) {
        this.mapperName = mapperName;
    }

    public String getModelClazz() {
        return modelClazz;
    }

    public void setModelClazz(String modelClazz) {
        this.modelClazz = modelClazz;
    }

    public String getProjectTargetPackage() {
        return projectTargetPackage;
    }

    public void setProjectTargetPackage(String projectTargetPackage) {
        this.projectTargetPackage = projectTargetPackage;
    }

    public String getGeneratedDate() {
        return generatedDate;
    }

    public String getGeneratedTime() {
        return generatedTime;
    }

    public boolean isColumnsHasBLOB() {
        return columnsHasBLOB;
    }

    public void setColumnsHasBLOB(boolean columnsHasBLOB) {
        this.columnsHasBLOB = columnsHasBLOB;
    }
}

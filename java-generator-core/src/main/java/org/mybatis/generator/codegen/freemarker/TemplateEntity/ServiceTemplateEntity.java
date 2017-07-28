package org.mybatis.generator.codegen.freemarker.TemplateEntity;

/**
 * Created by whm on 2017/7/26.
 */
public class ServiceTemplateEntity {
    private String templatePackage;//包名
    private String boPackage;//所需要导入的model包
    private String mapperPackage;//所需要导入的mapper包
    private String className;//生成的Service类名
    private String mapperType;//对应的Mapper类
    private String mapperName;//Mapper类的实例对象名
    private String boClazz;//对应的model类
    private String projectTargetPackage;//Service生成的目标工程包

    public String getTemplatePackage() {
        return templatePackage;
    }

    public void setTemplatePackage(String templatePackage) {
        this.templatePackage = templatePackage;
    }

    public String getBoPackage() {
        return boPackage;
    }

    public void setBoPackage(String boPackage) {
        this.boPackage = boPackage;
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

    public String getBoClazz() {
        return boClazz;
    }

    public void setBoClazz(String boClazz) {
        this.boClazz = boClazz;
    }

    public String getProjectTargetPackage() {
        return projectTargetPackage;
    }

    public void setProjectTargetPackage(String projectTargetPackage) {
        this.projectTargetPackage = projectTargetPackage;
    }
}

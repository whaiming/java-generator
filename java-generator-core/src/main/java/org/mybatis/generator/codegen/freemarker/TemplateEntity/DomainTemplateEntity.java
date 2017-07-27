package org.mybatis.generator.codegen.freemarker.TemplateEntity;

/**
 * Created by whm on 2017/7/26.
 */
public class DomainTemplateEntity {
    private DomainTemplate domainTemplate;
    private NativeDomainTemplate nativeDomainTemplate;

    public DomainTemplate getDomainTemplate() {
        return domainTemplate;
    }

    public void setDomainTemplate(DomainTemplate domainTemplate) {
        this.domainTemplate = domainTemplate;
    }

    public NativeDomainTemplate getNativeDomainTemplate() {
        return nativeDomainTemplate;
    }

    public void setNativeDomainTemplate(NativeDomainTemplate nativeDomainTemplate) {
        this.nativeDomainTemplate = nativeDomainTemplate;
    }

    public static class DomainTemplate{
        private String domainPackage;//domain所在的包
        private String boPackage;//对应的bo对象所在的包
        private String domainInterface;//domain接口名
        private String boType;//bo类名
        private String ProjectTargetPackage;//文件生成路径

        public String getDomainPackage() {
            return domainPackage;
        }

        public void setDomainPackage(String domainPackage) {
            this.domainPackage = domainPackage;
        }

        public String getBoPackage() {
            return boPackage;
        }

        public void setBoPackage(String boPackage) {
            this.boPackage = boPackage;
        }

        public String getDomainInterface() {
            return domainInterface;
        }

        public void setDomainInterface(String domainInterface) {
            this.domainInterface = domainInterface;
        }

        public String getBoType() {
            return boType;
        }

        public void setBoType(String boType) {
            this.boType = boType;
        }

        public String getProjectTargetPackage() {
            return ProjectTargetPackage;
        }

        public void setProjectTargetPackage(String projectTargetPackage) {
            ProjectTargetPackage = projectTargetPackage;
        }
    }

    public static class NativeDomainTemplate{
        private String nativeDomainPackage;//nativeDomain所在的包
        private String domainPackage;//domain所在的包
        private String boPackage;//对应的bo对象所在的包
        private String modelPackage;//对应的bo对象所在的包
        private String modelServicePackage;//对应的对象所在的包
        private String domainName;//对应的domain名
        private String nativeDomainClazz;//NativeDomain类名
        private String domainInterface;//domain接口名
        private String modelServiceClazz;//所对应service类
        private String modelServiceName;//所对应service类名
        private String boType;//bo类名
        private String modelClazz;//model类名
        private String ProjectTargetPackage;//文件生成路径

        public String getNativeDomainPackage() {
            return nativeDomainPackage;
        }

        public void setNativeDomainPackage(String nativeDomainPackage) {
            this.nativeDomainPackage = nativeDomainPackage;
        }

        public String getDomainPackage() {
            return domainPackage;
        }

        public void setDomainPackage(String domainPackage) {
            this.domainPackage = domainPackage;
        }

        public String getBoPackage() {
            return boPackage;
        }

        public void setBoPackage(String boPackage) {
            this.boPackage = boPackage;
        }

        public String getModelPackage() {
            return modelPackage;
        }

        public void setModelPackage(String modelPackage) {
            this.modelPackage = modelPackage;
        }

        public String getModelServicePackage() {
            return modelServicePackage;
        }

        public void setModelServicePackage(String modelServicePackage) {
            this.modelServicePackage = modelServicePackage;
        }

        public String getDomainName() {
            return domainName;
        }

        public void setDomainName(String domainName) {
            this.domainName = domainName;
        }

        public String getNativeDomainClazz() {
            return nativeDomainClazz;
        }

        public void setNativeDomainClazz(String nativeDomainClazz) {
            this.nativeDomainClazz = nativeDomainClazz;
        }

        public String getDomainInterface() {
            return domainInterface;
        }

        public void setDomainInterface(String domainInterface) {
            this.domainInterface = domainInterface;
        }

        public String getModelServiceClazz() {
            return modelServiceClazz;
        }

        public void setModelServiceClazz(String modelServiceClazz) {
            this.modelServiceClazz = modelServiceClazz;
        }

        public String getModelServiceName() {
            return modelServiceName;
        }

        public void setModelServiceName(String modelServiceName) {
            this.modelServiceName = modelServiceName;
        }

        public String getBoType() {
            return boType;
        }

        public void setBoType(String boType) {
            this.boType = boType;
        }

        public String getModelClazz() {
            return modelClazz;
        }

        public void setModelClazz(String modelClazz) {
            this.modelClazz = modelClazz;
        }

        public String getProjectTargetPackage() {
            return ProjectTargetPackage;
        }

        public void setProjectTargetPackage(String projectTargetPackage) {
            ProjectTargetPackage = projectTargetPackage;
        }
    }
}

package org.mybatis.generator.config;

import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 * Created by whm on 2017/7/26.
 */
public class JavaDomainGeneratorConfiguration extends PropertyHolder {
    private String targetPackage;

    private String targetProject;


    /**
     *
     */
    public JavaDomainGeneratorConfiguration() {
        super();
    }

    public XmlElement toXmlElement() {
        XmlElement answer = new XmlElement("javaDomainGenerator"); //$NON-NLS-1$

        if (targetPackage != null) {
            answer.addAttribute(new Attribute("targetPackage", targetPackage)); //$NON-NLS-1$
        }

        if (targetProject != null) {
            answer.addAttribute(new Attribute("targetProject", targetProject)); //$NON-NLS-1$
        }

        addPropertyXmlElements(answer);

        return answer;
    }

    public String getTargetPackage() {
        return targetPackage;
    }

    public void setTargetPackage(String targetPackage) {
        this.targetPackage = targetPackage;
    }

    public String getTargetProject() {
        return targetProject;
    }

    public void setTargetProject(String targetProject) {
        this.targetProject = targetProject;
    }
}


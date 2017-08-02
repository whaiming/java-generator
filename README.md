1、增加了获取sqlServer数据库字段注释的功能（官网给出的解释是JDBC不支持获取sqlServer字段注释）。
2、扩展生成Bo，对应的XML配置如下：
<javaBoGeneratortargetPackage="com.btjf.business.authentication.custcertification.Bo"
       targetProject="Java-generator-core/src/main/java">
       <propertyname="enableSubPackages" value="true" />
       <propertyname="trimStrings" value="true" />
</javaBoGenerator>
3、(1)table里增加了
enableInsertSelective
enableUpdateByExampleSelective属性，其默认值为true；
(2)对应的enableUpdateByExample
enableUpdateByPrimaryKey
enableInsert默认改成了false ；
(3)新增enableSelectAll
enableSelectNotDeleteAll
enableSelectNotDeleteByPrimaryKey属性，默认为true；
对应的则在Mapper中添加了相应的方法。
4、结合freemarker和XML生成了简单的Service和domain，对应的XML配置如下：
<javaServiceGenerator targetPackage="com.btjf.business.authentication.custcertification.service"
            targetProject="java-generator-core/src/main/java">
       <propertyname="enableSubPackages" value="true" />
</javaServiceGenerator>
<javaDomainGenerator targetPackage="com.btjf.business.authentication.custcertification.domain"
           targetProject="java-generator-core/src/main/java">
</javaDomainGenerator>
5、 注意：javaBoGenerator、javaServiceGenerator均为可选不进行配置，javaDomainGenerator和javaServiceGenerator成对出现（要么都配置，要么都不配置）
 
6、附上整个的generatorConfig.xml，所有的均以t_member表为例的。
 view plain copy 
<?xml version="1.0" encoding="UTF-8" ?>  
  
<!DOCTYPE generatorConfiguration PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN" "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd" >  
<generatorConfiguration>  
    <classPathEntry location="F:/tools/libs/com/microsoft/sqlserver/sqljdbc4/6.0/sqljdbc4-6.0.jar" />  
    <context id="beitaijinfu" targetRuntime="MyBatis3">  
        <property name="javaFileEncoding" value="UTF-8"/>  
        <property name="mergeable" value="true" />  
        <plugin type="org.mybatis.generator.plugins.EqualsHashCodePlugin" />  
        <plugin type="org.mybatis.generator.plugins.CaseInsensitiveLikePlugin"></plugin>  
        <plugin type="org.mybatis.generator.plugins.SerializablePlugin"></plugin>  
        <commentGenerator  type="org.mybatis.generator.internal.DefaultCommentGenerator">  
            <property name="suppressDate" value="true" />  
            <property name="addRemarkComments" value="true" />  
        </commentGenerator>  
        <jdbcConnection driverClass="com.microsoft.sqlserver.jdbc.SQLServerDriver" connectionURL=""  
                        userId="" password="" />  
        <javaTypeResolver>  
            <property name="forceBigDecimals" value="false"/>  
        </javaTypeResolver>  
  
        <!--<javaBoGenerator targetPackage="com.btjf.business.authentication.custcertification.Bo" targetProject="java-generator-core/src/main/java">-->  
            <!--<property name="enableSubPackages" value="true" />-->  
            <!--<property name="trimStrings" value="true" />-->  
        <!--</javaBoGenerator>-->  
        <javaModelGenerator targetPackage="com.btjf.business.authentication.custcertification.model" targetProject="java-generator-core/src/main/java">  
            <property name="enableSubPackages" value="true" />  
            <property name="trimStrings" value="true" />  
        </javaModelGenerator>  
        <sqlMapGenerator targetPackage="com.btjf.business.authentication.custcertification.mapper" targetProject="java-generator-core/src/main/java">  
            <property name="enableSubPackages" value="true" />  
        </sqlMapGenerator>  
        <javaClientGenerator targetPackage="com.btjf.business.authentication.custcertification.mapper" targetProject="java-generator-core/src/main/java" type="XMLMAPPER">  
            <property name="enableSubPackages" value="true" />  
        </javaClientGenerator>  
        <!--<javaServiceGenerator targetPackage="com.btjf.business.authentication.custcertification.service" targetProject="java-generator-core/src/main/java">-->  
            <!--<property name="enableSubPackages" value="true" />-->  
        <!--</javaServiceGenerator>-->  
        <!--<javaDomainGenerator targetPackage="com.btjf.business.authentication.custcertification.domain"-->  
                             <!--targetProject="java-generator-core/src/main/java">-->  
        <!--</javaDomainGenerator>-->  
  
        <table tableName="t_Member" domainObjectName="Member"  enableInsert="false" enableUpdateByExample = "false" enableSelectAll="true" enableSelectNotDeleteAll="true"  
               enableSelectNotDeleteByPrimaryKey = "true"  
        >  
            <property name="useActualColumnNames" value="true"/>  
            <generatedKey column="FID" sqlStatement="SELECT @@IDENTITY" identity="true"/>  
            <columnRenamingRule searchString="^F" replaceString=""/>  
        </table>  
    </context>  
  
</generatorConfiguration>  

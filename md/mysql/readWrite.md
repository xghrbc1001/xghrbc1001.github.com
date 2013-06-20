http://wilr.iteye.com/blog/1190524

<?xml version="1.0" encoding="UTF-8"?>  
<beans xmlns="http://www.springframework.org/schema/beans"  
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:aop="http://www.springframework.org/schema/aop"  
    xmlns:tx="http://www.springframework.org/schema/tx" xmlns:context="http://www.springframework.org/schema/context"  
    xsi:schemaLocation="  
     http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-2.5.xsd    
    http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.5.xsd  
    http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-2.5.xsd  
    http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-2.5.xsd">  
    <!--加载数据源JDBC属性文件 -->  
    <bean id="propertyConfig"  
        class="org.springframework.beans.factory.config.PreferencesPlaceholderConfigurer">  
        <property name="locations">  
            <list>  
                <value>classpath:jdbc.properties</value>  
            </list>  
        </property>  
    </bean>  
    <!--数据源公共属性 -->  
    <bean id="parentDataSource" class="org.apache.commons.dbcp.BasicDataSource"  
        destroy-method="close">  
        <property name="initialSize" value="10" />  
        <property name="maxActive" value="100" />  
        <property name="maxIdle" value="30" />  
        <property name="minIdle" value="10" />  
        <property name="logAbandoned" value="true" />  
        <property name="removeAbandoned" value="true" />  
        <property name="removeAbandonedTimeout" value="100" />  
        <property name="maxWait" value="5000" />  
        <property name="testOnBorrow" value="true"/>  
        <property name="testOnReturn" value="true"/>  
        <property name="testWhileIdle" value="true"/>  
        <property name="minEvictableIdleTimeMillis" value="0"></property>  
        <property name="timeBetweenEvictionRunsMillis" value="60"></property>  
    </bean>  
    <!--配置主数据源(负责数据UPDATE操作) -->  
    <bean id="masterDataSource" parent="parentDataSource">  
        <property name="driverClassName" value="${master.jdbc.driverClassName}" />  
        <property name="url" value="${master.jdbc.url}" />  
        <property name="username" value="${master.jdbc.username}" />  
        <property name="password" value="${master.jdbc.password}" />  
        <property name="validationQuery" value="SELECT COUNT(1) FROM tbl_test"></property>  
    </bean>  
    <!--配置主数据源(负责数据UPDATE操作) -->  
    <bean id="slaveDataSource" parent="parentDataSource">  
        <property name="driverClassName" value="${slave.jdbc.driverClassName}" />  
        <property name="url" value="${slave.jdbc.url}" />  
        <property name="username" value="${slave.jdbc.username}" />  
        <property name="password" value="${slave.jdbc.password}" />  
        <property name="validationQuery" value="SELECT COUNT(1) FROM tbl_test"></property>  
    </bean>  
    <!--配置数据源 -->  
    <bean id="dataSource" class="com.ssi222.wilr.util.datasource.DynamicDataSource">  
        <property name="targetDataSources">  
            <map key-type="java.lang.String">  
                <entry key="master" value-ref="masterDataSource" />  
                <entry key="slave" value-ref="slaveDataSource" />  
            </map>  
        </property>  
        <property name="defaultTargetDataSource" ref="masterDataSource"></property>  
    </bean>  
    <!--Spring|Ibatis整合 -->  
    <bean id="sqlMapClient" class="org.springframework.orm.ibatis.SqlMapClientFactoryBean">  
        <property name="configLocations">  
            <list>  
                <value>classpath:config/ibatis.xml</value>  
            </list>  
        </property>  
        <property name="dataSource">  
            <ref local="dataSource" />  
        </property>  
    </bean>  
  
    <!--配置持久模型层 -->  
    <bean id="presentation" class="com.ssi222.wilr.presentation.impl.PresentationImpl">  
        <property name="sqlMapClient">  
            <ref local="sqlMapClient" />  
        </property>  
    </bean>  
    <!--配置业务模型层基础类 -->  
    <bean id="baseService" class="com.ssi222.wilr.service.impl.BaseServiceImpl">  
        <property name="presentation">  
            <ref local="presentation" />  
        </property>  
    </bean>  
</beans>  

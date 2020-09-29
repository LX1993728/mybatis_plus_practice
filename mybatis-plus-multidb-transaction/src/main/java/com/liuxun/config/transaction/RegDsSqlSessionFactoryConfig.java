package com.liuxun.config.transaction;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

import javax.sql.DataSource;
import java.util.Map;

/**
 * 动态注册SqlSessionFactory 并注入生成好的DataSource
 *
 */
@Configuration
@Slf4j
public class RegDsSqlSessionFactoryConfig {
    private GenericApplicationContext genericContext;
    private ConfigurableApplicationContext configContext;
    public RegDsSqlSessionFactoryConfig(ApplicationContext applicationContext) {
        this.genericContext = (GenericApplicationContext) applicationContext;
        this.configContext = (ConfigurableApplicationContext) applicationContext;
    }

    protected void registerSqlSessionFactory(Map<String, DataSource> dataSourceMap, String primaryDsName){
        log.info("==========================");
        final ConfigurableListableBeanFactory beanFactory = configContext.getBeanFactory();
        String factoryPrefix = "SqlSessionFactory";
        dataSourceMap.forEach((key,dataSource)->{
            final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
            String sqlFactoryKey = key + factoryPrefix;
            beanFactory.registerSingleton(key, dataSource);
            beanFactory.registerSingleton(sqlFactoryKey, sessionFactoryBean);
            BeanDefinition sqlFactoryDefination = new GenericBeanDefinition();
            if (key.equals(primaryDsName)){
                sqlFactoryDefination.setPrimary(true);
            }
            genericContext.registerBeanDefinition(sqlFactoryKey, sqlFactoryDefination);

       });
    }
}

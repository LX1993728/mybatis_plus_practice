package com.liuxun.config.transaction;

import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.dynamic.datasource.support.ScriptRunner;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * @author liuxun
 * @apiNote 事务数据源
 */
@Component
public class AtomikosDataSourceCreator {

    /**
     * 创建数据源
     * @param dataSourceProperty  数据源信息
     * @return 创建数据源
     */
    public DataSource createDataSource(DataSourceProperty dataSourceProperty){
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(dataSourceProperty.getUrl());
        mysqlXaDataSource.setPassword(dataSourceProperty.getPassword());
        mysqlXaDataSource.setUser(dataSourceProperty.getUsername());
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setMinPoolSize(5);
        xaDataSource.setBorrowConnectionTimeout(60);
        xaDataSource.setMaxPoolSize(20);
        xaDataSource.setXaDataSourceClassName(dataSourceProperty.getDriverClassName());
        xaDataSource.setTestQuery("SELECT 1 FROM DUAL");
        xaDataSource.setUniqueResourceName(dataSourceProperty.getPoolName());
        this.runScrip(xaDataSource, dataSourceProperty);
        return xaDataSource;
    }

    /**
     * 初始化数据源对应的SQL脚本
     * @param dataSource
     * @param dataSourceProperty
     */
    private void runScrip(DataSource dataSource, DataSourceProperty dataSourceProperty) {
        String schema = dataSourceProperty.getSchema();
        String data = dataSourceProperty.getData();
        if (StringUtils.hasText(schema) || StringUtils.hasText(data)) {
            ScriptRunner scriptRunner = new ScriptRunner(dataSourceProperty.isContinueOnError(), dataSourceProperty.getSeparator());
            if (StringUtils.hasText(schema)) {
                scriptRunner.runScript(dataSource, schema);
            }
            if (StringUtils.hasText(data)) {
                scriptRunner.runScript(dataSource, data);
            }
        }
    }
}

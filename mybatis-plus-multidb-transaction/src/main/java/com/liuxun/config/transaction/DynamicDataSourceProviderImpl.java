package com.liuxun.config.transaction;

import com.baomidou.dynamic.datasource.provider.DynamicDataSourceProvider;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuxun
 * @apiNote 接管MybatisPlus多数据源至Atomikos管理
 */

@Service
@Primary
@EnableConfigurationProperties(DynamicDataSourceProperties.class)
public class DynamicDataSourceProviderImpl implements DynamicDataSourceProvider {

    /**
     * 配置文件数据的松散绑定
     */
    private final DynamicDataSourceProperties properties;

    private final AtomikosDataSourceCreator atomikosDataSourceCreator;

    public DynamicDataSourceProviderImpl(DynamicDataSourceProperties properties, AtomikosDataSourceCreator atomikosDataSourceCreator) {
        this.properties = properties;
        this.atomikosDataSourceCreator = atomikosDataSourceCreator;
    }

    @Autowired
    private RegDsSqlSessionFactoryConfig factoryConfig;

    @Override
    public Map<String, DataSource> loadDataSources() {
        Map<String, DataSourceProperty> datasourcePropertiesMap = properties.getDatasource();
        Map<String, DataSource> dataSourceMap = new HashMap<>(datasourcePropertiesMap.size());
        for (Map.Entry<String, DataSourceProperty> item : datasourcePropertiesMap.entrySet()){
            String poolName = item.getKey();
            DataSourceProperty dataSourceProperty = item.getValue();
            dataSourceProperty.setPoolName(poolName);
            dataSourceMap.put(poolName, atomikosDataSourceCreator.createDataSource(dataSourceProperty));
        }
        final String primaryDsName = properties.getPrimary();
        factoryConfig.registerSqlSessionFactory(dataSourceMap, primaryDsName);
        return dataSourceMap;
    }


}

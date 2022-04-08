package com.liuxun.factory;

import org.mybatis.spring.mapper.MapperFactoryBean;

public class CustomMapperFactoryBean<T> extends MapperFactoryBean<T> {

    public CustomMapperFactoryBean(){}

    public CustomMapperFactoryBean(Class<T> mapperInterface){
        super(mapperInterface);
    }

    @Override
    public T getObject() throws Exception {
        Class<?> mapperInterfaceClazz = getObjectType();
        T mapperProxy = super.getObject();
        return (T) new JdkDynamicMapperProxy(mapperProxy, mapperInterfaceClazz).getProxy();
    }

}

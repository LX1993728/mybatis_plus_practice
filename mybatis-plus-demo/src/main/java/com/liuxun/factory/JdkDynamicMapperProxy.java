package com.liuxun.factory;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ClassUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Slf4j
public class JdkDynamicMapperProxy implements InvocationHandler {


    /**
     * 是否打印方法参数
     */
    private boolean printArguments = false;
    /**
     * 是否打印方法结果
     */
    private boolean printResults = false;

    private Object object;

    private Class<?> interfaceClazz;

    public JdkDynamicMapperProxy(Object object, Class<?> interfaceClazz) {
        this.interfaceClazz = interfaceClazz;
        this.object = object;
    }

    public Object getProxy() {
        return getProxy(ClassUtils.getDefaultClassLoader());
    }

    public Object getProxy(ClassLoader classLoader) {
        return Proxy.newProxyInstance(classLoader, new Class[]{interfaceClazz}, this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object retValue = null;
        String result = "N";
        long beginTime = System.currentTimeMillis();
        try {
            retValue = method.invoke(object, args);
            result = "Y";
            return retValue;
        } finally {
            long endTime = System.currentTimeMillis();
            log.info("[({}.{},{},{}ms)({})({})]", interfaceClazz.getSimpleName(), method.getName(), result,
                    endTime - beginTime, getArgumentsString(args), getResultsString(retValue));
        }
    }

    private String getMessage(Method method) {
        return interfaceClazz.getSimpleName() + "." + method.getName();
    }

    /**
     * 获取日志中使用的方法参数
     */
    private String getArgumentsString(Object[] args) {
        String arguments = "-";
        if (printArguments) {
            arguments = StringUtils.join(args, ",");
        }
        return arguments;
    }

    /**
     * 获取结果内容
     */
    private Object getResultsString(Object retValue) {
        if (printResults) {
            return retValue == null ? "null" : retValue.toString();
        } else {
            return "-";
        }
    }

}

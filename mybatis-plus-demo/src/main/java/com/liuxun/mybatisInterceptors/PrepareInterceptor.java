package com.liuxun.mybatisInterceptors;

import com.liuxun.utils.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.Properties;

@Intercepts({
//          @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }),
        @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class,Integer.class })
//        @Signature(method = "query", type = Executor.class, args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class })
})
@Component
@Slf4j
public class PrepareInterceptor implements Interceptor {
    @Override
    public void setProperties(Properties properties) {

    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if(log.isInfoEnabled()){
            log.info("进入 PrepareInterceptor 拦截器...");
        }
        if(invocation.getTarget() instanceof RoutingStatementHandler) {
            RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
            StatementHandler delegate = (StatementHandler) ReflectUtil.getFieldValue(handler, "delegate");
            //通过反射获取delegate父类BaseStatementHandler的mappedStatement属性
            MappedStatement mappedStatement = (MappedStatement) ReflectUtil.getFieldValue(delegate, "mappedStatement");
            //千万不能用下面注释的这个方法，会造成对象丢失，以致转换失败
            //MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];

            if(log.isInfoEnabled()){
                log.info("数据权限处理【拼接SQL】...");
            }
            BoundSql boundSql = delegate.getBoundSql();
            //Connection connection = (Connection) invocation.getArgs()[0];
            log.info("--{}", boundSql.getSql());
            ReflectUtil.setFieldValue(boundSql, "sql", permissionSql(boundSql.getSql()));
        }

        return invocation.proceed();
    }

    private String permissionSql(String boundSql){
        return boundSql;
    }
}

package com.liuxun.aspects;

import com.liuxun.annotations.RefundSwitch;
import com.liuxun.domain.enums.MethodEnum;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.interceptor.ExposeInvocationInterceptor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.Optional;

/**
 * @author liuxun
 * @apiNote 对refundOrder增强
 */
@Slf4j
@Aspect
@Component
public class RefundOrderAspect {

//    @Pointcut("@annotation(com.liuxun.annotations.RefundSwitch)")
//    public void pointcut(){}

//    @Pointcut("execution(* com.baomidou.mybatisplus.core.mapper.BaseMapper+.*(..))")
//    public void pointcut(){}

    @Pointcut("execution(* com.liuxun.mapper.UserMapper.*(..))")
    public void pointcut(){}


    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object proceed = null;
        MethodInvocation methodInvocation = ExposeInvocationInterceptor.currentInvocation();
        if (methodInvocation != null){
            Annotation[] annotations = methodInvocation.getMethod().getAnnotations();
            if (annotations !=null){
                for (Annotation annotation : annotations){
                    if (annotation.annotationType().equals(RefundSwitch.class)){
                        RefundSwitch refundSwitch = (RefundSwitch) annotation;
                        Optional<Object> proceedOption = resolveBusinessSwitch(refundSwitch, proceedingJoinPoint);
                        if (proceedOption.isPresent()){
                            proceed = proceedOption.get();
                            return proceed;
                        }
                    }
                }
            }

        }
        proceed = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());

        return proceed;
    }

    @PostConstruct
    public void construct(){
        log.info("---------- Mapper 代理类生成 -----------------------");
    }

    private Optional<Object> resolveBusinessSwitch(RefundSwitch refundSwitch, ProceedingJoinPoint proceedingJoinPoint) {
        MethodEnum methodEnum = refundSwitch.method();
        if (methodEnum == MethodEnum.REFUND_ORDER_QUERY) {
            return Optional.of(Collections.emptyList());
        }
        return Optional.empty();
    }



}

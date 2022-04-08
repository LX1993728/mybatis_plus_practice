package com.liuxun.annotations;


import com.liuxun.domain.enums.ArgumentType;
import com.liuxun.domain.enums.MethodEnum;

import java.lang.annotation.*;


/**
 * @author liuxun
 * @apiNote 方法切换注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
@Inherited
public @interface RefundSwitch {
    MethodEnum method();  // 方法
    ArgumentType argument(); // 参数类型，例如查询根据之类的
}

package com.ai.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: WebInitParamEx
 * @Description: 定义Servlet的初始化参数注解
 * @author: wuyj
 * @date: 2018-03-24
 *
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface WebInitParamEx {
    //参数名
    String paramName() default "";
    //参数的值
    String paramValue() default "";
}

package com.Annotation2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用注解方便将数据存储到数据库的案例
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation3 {
    int column();//在数据库第几行

    String type();//数据类型

    int space();//给定空间

    int precision() default 0;//位数精度
}

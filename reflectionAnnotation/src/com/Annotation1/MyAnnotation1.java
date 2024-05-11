package com.Annotation1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解的引入，给计算机看的叫注解，给人看的叫注释
 * public @interface name{}，定义一个注解类
 *
 * Target（ElementType.METHOD方法，ElementType.Type类，Element.FIELD成员变量）
 * 该注解只能在什么目标上注解
 *
 * Retention（RetentionPolicy.运行时间）
 * 该注解运行到程序的哪里，RUNTIME就是运行时
 *
 */
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation1 {
    //类型 名称（） default 默认值
    //定义注解的变量，可以没有default
    String value()default "";
    int num() default 0;
    double[] os();
}

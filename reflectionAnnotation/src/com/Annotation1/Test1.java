package com.Annotation1;

/**
 * 注解测试
 * 格式：@注解（变量=value，...）
 * 只有一个变量时可以：@注解（value）
 * 注解没有变量或者每个变量都有默认值可以：@注解
 */
public class Test1 {

    @MyAnnotation1(os=1.12,num=1)
    @MyAnnotation2
    void method1(){}

    public static void main(String[] args) {

    }
}

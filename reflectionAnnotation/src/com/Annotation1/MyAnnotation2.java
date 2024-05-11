package com.Annotation1;

/**
 * 一个注解没有Target就是可以在任何地方运行
 */
public @interface MyAnnotation2 {
    int value() default 1;
}

package com.Annotation2;

import java.util.Date;

/**
 * 让注解与对象表一一对应，实现数据库数据自动读取
 */
// @MyAnnotation4
public class Test1 {
    @MyAnnotation3(column = 1, type = "int", space = 10)
    private int id;
    @MyAnnotation3(column = 2, type = "String", space = 12)
    private Date birthday;
    @MyAnnotation3(column = 3, type = "String", space = 8)
    private String name;
    @MyAnnotation3(column = 4, type = "String", space = 1)
    private String sex;
}

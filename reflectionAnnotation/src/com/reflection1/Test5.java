package com.reflection1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 一、用Class类实例化对象
 * 无参的方法：
 * 1.Class.newInstance（） == new 类（）
 * 2.Constructor.newInstance（）
 * 有参的方法：
 * 1.Constructor.newInstance(Object...)
 * 与直接new不同的是可以突破private构造器的限制，但操作繁琐
 * private构造器要setAccessible（true）
 * <p>
 * 二、在Class类上操作对象成员变量，可以突破private限制
 * private的变量要先setAccessible（true）才能操作
 * Field.set（对象，值） == 对象.成员变量=值
 * Field.get（对象） == 对象.成员变量
 * 着也体现了所有同类型对象的类对象有且只有这一个
 */
public class Test5 {
    public static void main(String[] args) throws Exception {
        String className = "com.reflection1.Dog";
        Class<?> aClass = Class.forName(className);

        Dog dog = (Dog) aClass.newInstance();
        System.out.println(dog);

        Constructor<?> constructor = aClass.getConstructor();
        Dog dog1 = (Dog) constructor.newInstance();
        System.out.println(dog1);

        Constructor<?> constructor1 = aClass.getDeclaredConstructor(int.class);
        constructor1.setAccessible(true);
        Dog dog2 = (Dog) constructor1.newInstance(99);
        System.out.println(dog2);

        Field field = aClass.getDeclaredField("leg");
        field.setAccessible(true);
        field.set(dog2, 12);
        System.out.println(field.get(dog2));

    }
}

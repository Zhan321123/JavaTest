package com.reflection1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 利用Class类调用方法
 * method.invoke（对象，Object...），对象使用该方法
 */
public class Test6 {
    public static void main(String[] args) throws Exception {

        Class<?> aClass = Class.forName("com.reflection1.Dog");
        Constructor<?> constructor = aClass.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        Object o = constructor.newInstance(10);
        Method method = aClass.getDeclaredMethod("shout",int.class);
        method.setAccessible(true);
        method.invoke(o,3);


    }
}

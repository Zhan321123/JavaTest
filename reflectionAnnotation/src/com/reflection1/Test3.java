package com.reflection1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Class类的各种参数的获取
 */
public class Test3 {
    public static void main(String[] args) throws Exception {
        Class<?> class1 = Class.forName("com.reflection1.Dog");

        Constructor<?>[] constructors1 = class1.getConstructors();
        show(constructors1);
        constructors1 = class1.getDeclaredConstructors();
        show(constructors1);
        //getDeclaredConstructor（Object.class），在类型后加上.class，是该方法的参数
        Constructor<?> constructor = class1.getDeclaredConstructor(int.class);
        System.out.println(constructor);
        System.out.println("===========================");

        Method[] methods1 = class1.getMethods();
        show(methods1);
        methods1 = class1.getDeclaredMethods();
        show(methods1);
        Method method = class1.getDeclaredMethod("shout",int.class);
        System.out.println(method);
        System.out.println("===========================");


    }
    private static void show(Object[] os){
        for (Object o:os){
            System.out.println(o);
        }
        System.out.println("-------------------");
    }
}

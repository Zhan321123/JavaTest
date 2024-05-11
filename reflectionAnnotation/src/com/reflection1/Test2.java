package com.reflection1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Class类中获取一个类的所有东西的方法
 * Field成员变量，
 * Constructor构造方法，
 * Modifiers修饰符，
 * Class和Interface多态结构，
 * Method成员方法
 */
public class Test2 {
    public static void main(String[] args) throws Exception{

        Class<?> class1 = Class.forName("com.reflection1.Dog");

        //getName（），获取该类的完整名，包含路径，返回String
        System.out.println(class1.getName());
        //getSimpleName（），获取该类的简单名，只有类名，返回String
        System.out.println(class1.getSimpleName());
        //getSuperclass（），获取父类，返回Class<?>
        System.out.println(class1.getSuperclass());
        //getInterfaces（），获取该类实现的接口，返回Class<?>[]
        System.out.println(Arrays.toString(class1.getInterfaces()));
        //getModifiers（），返回修饰符对应的int
        System.out.println(class1.getModifiers());
        //Modifier.toString（int），获取int对应的修饰符，返回String
        System.out.println(Modifier.toString(class1.getModifiers()));
        System.out.println("-------------------------");

        //getFields（），获取public成员变量，包括父类的，返回Filed[]
        Field[] fields1 = class1.getFields();
        for (Field f: fields1){
            System.out.println(f);
        }
        System.out.println("-------------------------");
        //getDeclaredFields（），获取该类的所有成员变量，包括private，不包括父类
        Field[] fields2 = class1.getDeclaredFields();
        for (Field f: fields2){
            System.out.println(f);
        }
        System.out.println("-------------------------");
        //获取父类所有成员变量的方法
        Field[] fields3 = class1.getSuperclass().getDeclaredFields();
        for (Field f:fields3){
            System.out.println(f);
        }
        System.out.println("-------------------------");

        Field f = class1.getDeclaredField("head");
        System.out.println(f.getName()+"  "+f.getModifiers());

        //获取构造方法,Declared和s的区别同上
        Constructor<?>[] constructor1 = class1.getConstructors();
        Constructor<?>[] constructor2 = class1.getDeclaredConstructors();
        Constructor<?> constructor3 = class1.getConstructor();
        Constructor<?> constructor4 = class1.getDeclaredConstructor();

        //获取方法
        Method[] methods1 = class1.getMethods();
        Method method2 = class1.getMethod("shout");
        Method[] method3 = class1.getDeclaredMethods();
        Method method4 = class1.getDeclaredMethod("shout");

    }
}


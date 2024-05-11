package com.reflection1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射的引入
 * 类的类使用测试
 * 四个类：
 * Class类类
 * Constructor构造方法类
 * Field成员变量类
 * Method方法类
 */
public class Test1 {

    public String name = "animal";
    int age = 10;
    String language = "shout";

    public Test1(String name,int age,String language){
        this.name = name;
        this.age = age;
        this.language = language;
    }

    public void shout(){
        System.out.println(name+": I am "+age+"years old, "+language);
    }

    @Override
    public String toString() {
        return "Test1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws Exception {

        String name = "com.reflection1.Test1";

        Class c = Class.forName(name);
        Constructor constructor = c.getConstructor();
        Object o = constructor.newInstance("dog",19,"wang!!!");
        Field myName = c.getField("name");
        myName.set(o,"dog");
        Method toString = c.getMethod("shout");
        toString.invoke(o);

    }
}

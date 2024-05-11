package com.reflection1;

/**
 * 获取类对象的方法
 * 一：类名.class
 * 从类中获取
 * 二：对象.getClass（）
 * 从对象获取
 * 三：Class.forName（String）
 * 从路径获取，在不知道具体类信息是使用该方法
 *
 * 类对象在内存中有且仅有一个，与对象不同
 */
public class Test4 {
    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> class1 = Dog.class;
        Class<?> class2 = Class.forName("com.reflection1.Dog");
        Dog dog = new Dog();
        Class<?> class3 = dog.getClass();

        System.out.println(class1);
        System.out.println(class2);
        System.out.println(class3);

        System.out.println("=====================");

        //特殊的类对象，int.class等等
        Class<?> class4 = int.class;
        Class<?> class5 = float[].class;

        System.out.println(class4);
        System.out.println(class5);


    }
}

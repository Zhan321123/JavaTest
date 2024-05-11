package com.ContainerTest1;

/**
 * 泛型方法以及继承的测试
 */
public class Test3 {
    public static void main(String[] args) {
        Bi b = new Bi();
        System.out.println(b.getName("liu"));

        fuck f = new Bi();
        System.out.println(f.getName("123"));


    }
}

interface fuck <T>{
    T getName(T name);
}
class Bi implements fuck<String>{
    @Override
    public String getName(String name) {
        return name;
    }
}
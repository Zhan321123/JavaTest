package com.ContainerTest1;

/**
 * 对泛型类的测试
 */
public class Test2 {
    public static void main(String[] args) {
        Test1<String> tt = new Test1<>();
        tt.setT(String.valueOf(Math.PI));
        String d = tt.getT();
        System.out.println(d);

        Integer i = 100;
        System.out.println(i);

    }
}

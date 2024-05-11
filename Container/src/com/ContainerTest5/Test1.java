package com.ContainerTest5;

import java.util.HashSet;
import java.util.Set;

/**
 * HashSet类的测试
 * 不可重复，无顺序，线程不安全
 */
public class Test1 {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();//HashSet<>()，线程不安全，存储不重复，
        set.add("abc");//add（element）添加元素
        set.add("345");
        set.add("xyz");
        set.add("e8e");
        set.add("abc");

//        set.get(int index);//无法用get获取元素，只能用for：
        display(set);

        System.out.println("------------------------");
        boolean b1 = set.remove("345");
        System.out.println(b1);

        display(set);

        System.out.println(set.size());
        System.out.println(set);

        System.out.println(Integer.valueOf(12).hashCode());
        "23".hashCode();//哈希值
        int i1 = set.hashCode();
        System.out.println(i1);

    }

    private static void display(Set<String> s){
        for (String str : s){
            System.out.print(str+"\t");
        }
        System.out.println();
    }
}

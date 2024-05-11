package com.ContainerTest5;

import java.util.HashSet;
import java.util.Set;

/**
 * HashSet的测试
 * 容器添加对象
 */
public class TestUse {
    public static void main(String[] args) {

        Set<Users> set = new HashSet<>();

        Users u = new Users("Zhan",17);
        set.add(u);
        set.add(new Users("Zhan",17));
        set.add(new Users("wei",18));

        System.out.println(set);
        display(set);

        System.out.println(u.getClass());



    }
    static void display(Set<Users> set){
        System.out.println("----");
        for (Users u:set){
            System.out.print(u+"\t");
        }
        System.out.println();
        for (Users u:set){
            System.out.print(u.hashCode()+"\t");
        }
        System.out.println("\n----");
    }
}

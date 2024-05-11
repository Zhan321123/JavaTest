package com.ContainerTest5;

import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet容器的测试
 * 自动排序，不可重复
 */
public class Test2 {
    public static void main(String[] args) {

        Set<String> s = new TreeSet<>();//TreeSet<>()，Set接口实现类，可自动排序
        s.add("a");
        s.add("c");
        s.add("b");
        s.add("a");
        display(s);

        Set<Users> set = new TreeSet<>();//当装自定义对象时，必须在类里重写CompareTo方法
        set.add(new Users("jin",18));
        set.add(new Users("lin",20));
        set.add(new Users("com",17));
        set.add(new Users("wei",18));

        display(set);

        for (Users u : set ){
            System.out.println(u);
        }



    }

    //泛型实现的方法
    static<E> void display(Set<E> set){
        System.out.print("["+"\t");
        for (E s : set){
            System.out.print(s+"\t");
        }
        System.out.println("]");
    }
}

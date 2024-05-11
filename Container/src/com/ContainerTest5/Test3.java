package com.ContainerTest5;

import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet容器添加对象的实验
 */
public class Test3 {
    public static void main(String[] args) {

        Set<Student> set = new TreeSet<>(new StudentCompare());
        set.add(new Student(18, "com"));
        set.add(new Student(20,"lin"));
        set.add(new Student(18,"wei"));
        set.add(new Student(18,"jin"));
        set.add(new Student(18,"bai"));

        display(set);

    }
    private static<T> void display(Set<T> set){
        System.out.println("---------------");
        for (T t:set){
            System.out.println(t);
        }
        System.out.println("---------");
    }
}

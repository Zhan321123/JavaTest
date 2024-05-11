package com.ContainerTest3;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Vector容器的测试
 * 有顺序，可重复
 */
public class Test1 {
    public static void main(String[] args) {

        List<String> v = new Vector<>();
        v.add("123");
        v.add("234");
        v.add("345");

        for (String s:v){
            System.out.print(s+"\t");
        }
        System.out.println();
        System.out.println(v);

        ArrayList<String> a = new ArrayList<>();
        a.add("qwe");
        System.out.println(a);

        Vector<Integer> i = new Vector<>();
        i.add(1232);
        System.out.println(i);


    }
}

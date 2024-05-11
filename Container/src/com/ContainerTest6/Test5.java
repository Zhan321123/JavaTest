package com.ContainerTest6;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * TreeMap的测试2
 */
public class Test5 {
    public static void main(String[] args) {

        Map<Stu,String> map = new TreeMap<>(new StuComparator());
        map.put(new Stu("com",17),"He likes playing Glory Of Kings");
        map.put(new Stu("jin",18),"A boy like play yellow game");
        map.put(new Stu("yan",20),"A boy often ff");
        map.put(new Stu("wei",18),"A boy like buying shoes");

        display(map);


    }
    static <K,V> void display(Map<K,V> map){
        System.out.println("-----");
        Set<K> set = map.keySet();
        for (K k:set){
            System.out.println(k+"    "+map.get(k));
        }
        System.out.println("----");
    }
}

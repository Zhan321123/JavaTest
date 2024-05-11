package com.ContainerTest6;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * TreeMap容器的测试
 * TreeMap<K，V>，一个K对应一个V
 * K不可重复，V可以
 * 可以实现自动排序
 */
public class Test4 {
    public static void main(String[] args) {

        Map<User,String> map = new TreeMap<>();
        User u1 = new User("com",17);
        map.put(u1,"He is handsome");
        map.put(new User("jin",18),"A boy like play yellow game");
        map.put(new User("yan",20),"A boy often ff");
        map.put(new User("wei",18),"A boy like buying shoes");

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

package com.ContainerTest6;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * HashMap容器的测试
 * Map<Key，Value>，一个k对应一个V
 * k不可重复，V可以重复，无顺序
 */
public class Test2 {
    public static void main(String[] args) {

        Map<Character,String> map = new HashMap<>();//HashMap<>()，Map<K,V>的实现类，双链表存储结构
        //一个Key对应一个Value，Key不能重复

        String s1 = map.put('a', "do a dear");//map.put(K,V)，在K添加一个元素V，返回为原来K处的V
        System.out.println(s1);//没有就是null
        System.out.println(map.put('a',"A"));

        map.put('b',"B");
        map.put('c',"C");

        String s2 = map.get('a');//get（K），获取K处的元素，返回V
        System.out.println(s2);
        System.out.println(map.get('b'));//K处没有东西，不会报错，会返回null

        System.out.println(map);//Map的toString（）方法

        System.out.println("------------------");

        display(map);
        display2(map);

        //Map.Entry<K,V>，Map的内部接口，用于将Map转化为Set
        Set<Map.Entry<Character,String>> set = map.entrySet();//方法是entrySet（）
        System.out.println(set);
        for (Map.Entry<Character, String> s : set){
            System.out.print(s.getKey()+"---"+s.getValue()+"   ");
            //Entry<K,V>的两个方法 getValue（）和 getKey（），获取K和V
        }
        System.out.println();

    }

    //遍历方法之一
    static<K,V> void display(Map<K,V> map){
        Set<K> set = map.keySet();//keySet（），将map中的K转化成set<K>，用于遍历
        System.out.println("[");
        for (K k:set){
            System.out.print(k+":"+map.get(k)+",\t");
        }
        System.out.println("\n]");
    }

    //遍历方法之二
    static<K,V> void display2(Map<K,V> map){
        Set<Map.Entry<K,V>> set = map.entrySet();
        System.out.println("[");
        for (Map.Entry<K,V> m:set){
            System.out.print(m.getKey()+":"+m.getValue()+",\t");
        }
        System.out.println("\n]");
    }
}

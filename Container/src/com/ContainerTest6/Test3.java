package com.ContainerTest6;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * HashMap的测试2
 */
public class Test3 {
    public static void main(String[] args) {
        Map<Integer,String> map1 = new HashMap<>();
        map1.put(1,"A");
        map1.put(2,"b");
        map1.put(3,"c");

        Map<Integer,String> map2 = new HashMap<>();
        map2.put(4,"d");
        map2.put(5,"e");
        map2.put(1,"a");

        map1.putAll(map2);//putAll(Map)，容器并集操作，void方法
        //相同Key的会替换为map2中的元素
        display(map1);
        display2(map1);

        System.out.println("--------------------");

        String s1 = map1.remove(5);//remove（Key），容器移除元素操作，返回为该K对应的Value
        System.out.println(s1);
        display(map1);

        String s2 = map1.remove(6);//没有Key，则返回null
        System.out.println(s2);

        System.out.println("-------------------");
        boolean b1 = map1.containsKey(1);//containsKey（Key），检测容器是否含有该Key，有返回true
        boolean b2 = map1.containsKey(7);//没有则返回false
        System.out.println(b1+"  "+b2);

        boolean b3 = map1.containsValue("a");//containsValue（Value),检测Value
        boolean b4 = map1.containsValue("zzz");
        System.out.println(b3+"   "+b4);



    }
    static<K,V> void display(Map<K,V> map){
        Set<K> set = map.keySet();
        for (K k : set){
            System.out.print(k+"---"+map.get(k)+"\t");
        }
        System.out.println();
    }

    static<K,V> void display2(Map<K,V> map){
        Set<Map.Entry<K,V>> set = map.entrySet();
        for (Map.Entry<K,V> m : set){
            System.out.print(m.getKey()+"---"+m.getValue()+"\t");
        }
        System.out.println();
    }
}

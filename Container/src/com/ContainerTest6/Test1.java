package com.ContainerTest6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 利用ArrayList和HashSet的存储数据的比较
 */
public class Test1 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        while(true){
            int n = (int)(Math.random()*10+1);
            if (!list.contains(n)){
                list.add(n);
            }
            if (list.size()==10){
                break;
            }
        }
        for (Integer i : list){
            System.out.print(i+"\t");
        }

        System.out.println("\n------------------------------");

        Set<Integer> set = new HashSet<>();
        while(true){
            int n = (int)(Math.random()*100+1);
            set.add(n);
            if (set.size()==10){
                break;
            }
        }
        for (Integer i:set){
            System.out.print(i+"\t");
        }


    }
}

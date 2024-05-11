package com.ContainerTest7;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Iterator迭代器在Set中的应用，同List一样的用法
 *
 */
public class Test3 {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        set.add("liu");
        set.add("wei");
        set.add("lin");
        set.add("jin");

        boolean b = Collections.addAll(set, "lin", "wei", "jin", "liu");
        System.out.println(b);

        for (String s:new String[]{"lin","wei","jin","liu"}){
            set.add(s);
        }

        System.out.println("--------------------");

        display1(set);
        display2(set);
        display3(set);


    }
    static <E> void display1(Set<E> set){
        Iterator<E> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+"\t");
        }
        System.out.println();
    }
    static <E> void display2(Set<E> set){
        for (E s:set){
            System.out.print(s+"\t");
        }
        System.out.println();
    }
    static <E> void display3(Set<E> set){
        for (Iterator<E> iterator = set.iterator();iterator.hasNext();){
            System.out.print(iterator.next()+"\t");
        }
        System.out.println();
    }
}

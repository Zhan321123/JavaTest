package com.ContainerTest7;

import java.util.*;

/**
 * 一个泛型方法
 * Collection遍历Set和List
 *
 */
public class Test4 {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        Collections.addAll(set,"liu","gao", "com");
        list.addAll(Arrays.asList("yan","wei","hang"));

        display1(set);
        display2(set);
        display3(set);

        display1(list);
        display2(list);
        display3(list);

    }
    static <E> void display1(Collection<E> collection){
        for (E e:collection){
            System.out.print(e+" \t");
        }
        System.out.println();
    }
    static <E> void display2(Collection<E> collection){
        Iterator<E> iterator = collection.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" \t");
        }
        System.out.println();
    }
    static <E> void display3(Collection<E> collection ){
        for (Iterator<E> iterator = collection.iterator();iterator.hasNext();){
            System.out.print(iterator.next()+" \t");
        }
        System.out.println();
    }
}

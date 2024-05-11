package com.ContainerTest7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Iterator容器的测试
 * 用于遍历
 */
public class Test1 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        //三种list容器添加元素的方法
        //first---add
        list.add("lin");
        list.add("wei");
        list.add("com");
        list.add("jin");
        //second---foreach
        for (String s:new String[]{"lin","wei", "com","jin"}){
            list.add(s);
        }
        //third---addAll
        list.addAll(Arrays.asList("lin", "wei", "com", "jin"));

        System.out.println("----------------------");

        //四种遍历List容器元素的方法
        //first---for循环，主要用到list.get方法
        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" \t");
        }
        System.out.println();
        //second---foreach，遍历容器
        for (String s:list){
            System.out.print(s+" \t");
        }
        System.out.println();
        //third---用到Iterator<E>泛型容器
        Iterator<String> iterator = list.listIterator();//list.listIterator()，将list容器的元素定义为一个Iterator容器类型
        while(iterator.hasNext()){//Iterator.hasNext(),判断Iterator容器光标处是否为空，空说明容器没有元素，或已经用next方法获取完了
            String s = iterator.next();//Iterator.next(),获取iterator的元素，获取完之后将光标放在下一个位置
            System.out.print(s+" \t");
        }
        System.out.println();
        //forth---for（Iterator；hasNext；）办法
        for (Iterator<String> it = list.listIterator(); it.hasNext();){
            System.out.print(it.next()+" \t");
        }
        System.out.println();

        System.out.println("-----------------------");

        boolean b1 = iterator.hasNext();//可见iterator容器已经遍历完了，hasNext（）返回false
        System.out.println(b1);
        iterator = list.listIterator();
        System.out.println(iterator.hasNext());

        String s1 = iterator.next();//可见一个新的list.iterator的next（）方法返回第一个元素
        System.out.println(s1);
        System.out.println(iterator.next());

        System.out.println("------------------------------");

        display1(list);
        display2(list);
        display3(list);
        display4(list);

    }

    //四种用泛型方法遍历list容器
    static <E> void display1(List<E> list){
        Iterator<E> iterator = list.listIterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" \t");
        }
        System.out.println();
    }
    static <E> void display2(List<E> list){
        for (Iterator<E> iterator = list.listIterator();iterator.hasNext();){
            System.out.print(iterator.next()+" \t");
        }
        System.out.println();
    }
    static <E> void display3(List<E> list){
        for (E e:list){
            System.out.print(e+" \t");
        }
        System.out.println();
    }
    static <E> void display4(List<E> list){
        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" \t");
        }
        System.out.println();
    }
}

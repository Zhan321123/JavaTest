package com.ContainerTest2;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList容器的测试4
 */
public class Test4 {
    public static void main(String[] args) {

        List<String> a = new ArrayList<>();
        a.add("a");a.add("b");a.add("c");

        List<String> b = new ArrayList<>();
        b.add("1");b.add("2");b.add("3");

        System.out.println("-----------容器并集操作----------");
        boolean b1 = a.addAll(b);//容器甲.addAll（容器乙），将乙中元素添加到甲中
        System.out.println(b1);//添加成功返回true
        display(a);

        b.clear();
        boolean b2 = a.addAll(b);//添加失败，即容器乙无元素，返回false
        System.out.println(b2);

        System.out.println("-------容器交集操作---------");
        b.add("b");b.add("c");b.add("d");

        boolean b3 = a.retainAll(b);//容器甲.retain（容器乙），将甲的元素换成 甲乙都有的元素
        System.out.println(b3);//操作成功返回true
        display(a);

        b.remove("d");
        boolean b4 = a.retainAll(b);//操作失败返回false
        System.out.println(b4);

        b.clear();
        boolean b5 = a.retainAll(b);//即便有一个容器为空集，只要操作成功，就返回true
        System.out.println(b5);
        display(a);

        System.out.println("-------容器差集操作------------");
        a.add("a");a.add("b");a.add("c");
        b.add("b");b.add("c");b.add("d");

        boolean b6 = a.removeAll(b);//容器甲.remove（容器乙），清除甲中乙的元素，乙不变
        System.out.println(b6);
        display(a);

        boolean b7 = a.removeAll(b);
        System.out.println(b7);
        display(a);


    }

    protected static void display(List<String> a){
        for (String s :a){
            System.out.print(s+"\t");
        }
        System.out.println();
    }

}

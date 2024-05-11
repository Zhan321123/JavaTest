package com.ContainerTest4;

import java.util.LinkedList;

/**
 * LinkedList双向列表的测试
 * 有顺序，可重复
 */
public class Test1 {
    public static void main(String[] args) {

        LinkedList<String> l = new LinkedList<>();//LinkedList<>()双向列表
        boolean b2 = l.add("a");//add（）添加元素，返回boolean
        System.out.println(b2);
        l.add("b");
        l.add("c");
        l.add("a");

        String s1 = l.get(1);//get（位置int），获取指定位置元素，返回该元素
        System.out.println(s1);

        display(l);

        System.out.println("------------------------");
        l.addFirst("1");//addFirst（元素），添加元素到最前面
        l.addLast("123");//addLast（元素），添加元素到最后面

        display(l);

        String s2 = l.getFirst();//getFirst（），获取最前面的元素，返回该元素
        String s3 = l.getLast();//getLast（），获取最后面的元素
        System.out.println(s2+"   "+s3);

        String s4 = l.removeFirst();//removeFirst（），移除最前面的元素，返回该元素
        String s5 = l.removeLast();//removeLast（），移除最后面的元素
        System.out.println(s4+"   "+s5);
        display(l);

        String s6 = l.pop();//行顺时针旋转成列，pop（），移除最顶的元素，返回该元素
        l.pop();
        System.out.println(s6);
        display(l);

        l.push("e eeee");//push（元素），将元素添加到最前面
        display(l);


        boolean b = l.isEmpty();//isEmpty（），判断列表是否为空，不是空返回true
        System.out.println(b);
        l.pop();
        l.removeFirst();
        l.removeLast();
        System.out.println(l.isEmpty());//空，则返回true

    }
    private static void display(LinkedList<String> l){
        for (String s : l){
            System.out.print(s+"\t");
        }
        System.out.println();
    }
}

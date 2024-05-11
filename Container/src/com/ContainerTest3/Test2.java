package com.ContainerTest3;

import java.util.Stack;

/**
 * Stack栈容器的测试
 * 向上弹栈，适合用于事件
 */
public class Test2 {
    public static void main(String[] args) {

//        List<String> s = new Stack<>();
//        boolean b1 = s.add("add");
//        System.out.println(b1);

        Stack<String> ss = new Stack<>();//Stack<>()创建栈容器
        String s1 = ss.push("s1");//push（元素），入栈，向栈中添加元素，返回该元素
        System.out.println(s1);
        ss.push("s2");//将下一个元素添加到上面
        ss.push("s3");
        ss.push("s4");

        System.out.println(ss.search("s4"));//search（元素），查找元素位置，返回int
        System.out.println(ss.search("s1"));//最上面的位置是1，然后依次向下数
        System.out.println(ss.search("none"));//如果没有，返回-1

        int size = ss.size();
        String s = ss.peek();//peek（），返回最上面的元素
        System.out.println(s);
        for (int i=0;i<size;i++){
            System.out.print(ss.peek());//peek（）不会清除最上面的元素
        }

        System.out.println();
        System.out.println("----------pop()-----------");

        String s2 = ss.pop();//pop（），弹栈，将最上面的元素取出，返回最上面的元素
        for (int i=0;i<size-1;i++){
            System.out.print(ss.pop());//pop（）会清除最上面的元素，调用一次清除一次
        }
        System.out.println();

        boolean b = ss.isEmpty();
        System.out.println(b);
        boolean b2 = ss.empty();//empty（）检测栈容器是否为空，空返回true
        System.out.println(b2);

        ss.push("s5");
        System.out.println(ss.empty());//不是空，返回false


    }
}

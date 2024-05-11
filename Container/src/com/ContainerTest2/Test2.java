package com.ContainerTest2;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList容器的测试2
 */
public class Test2 {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
//        l.set(0,"liu");
        l.add("yan");
        String s = l.set(0,"liu");//设置容器元素set（位置，新元素）//返回为容器的元素
        System.out.println(s);

        for (String value : l) {
            System.out.println(value);
        }

        System.out.println("------clear----------");
        l.clear();//clear清空元素
        for (String ss :l){
            System.out.println(ss);
        }
        System.out.println(l.size());

        System.out.println("------judgeList--------");

        if (l.isEmpty()){
            System.out.println("this l is empty");
        }
        boolean b = l.isEmpty();//isEmpty检测容器元素是否为空，空返回为true
        System.out.println(b);
        l.add("jin");
        System.out.println(l.isEmpty());

        System.out.println("-------------judge a element-----");
        boolean b1 = l.contains("liu");//contain（元素）检测容器是否包含该元素//有则返回true
        System.out.println(b1);
        System.out.println(l.contains("jin"));

    }
}

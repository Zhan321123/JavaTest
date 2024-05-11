package com.ContainerTest2;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList<>泛型容器的测试1
 * 可重复，有顺序
 */
public class Test1 {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();//创建容器
        l.add(123);//add添加元素
        l.add(234);
        l.add(0);
        l.add(234);
        boolean b1 = l.add(234);//添加元素返回布尔值
        System.out.println(b1);

//        l.add(6,345);//添加元素不能超过
        l.add(4,234);//add指定位置添加元素

        System.out.println(l);//遍历为[元素，元素，…………]

        System.out.println(l.size());//size（）容器大小，相当于数组的length（）

        System.out.println(l.get(0)+l.get(1));//get（数字）相当于数组的【数字】
        System.out.println("-----------------------");
        for (int i =0;i<l.size();i++){
            System.out.print(l.get(i)+"\t");
        }
        for (Integer i:l){
            System.out.println(i+"\t");
        }
        System.out.println();

        Integer I = l.remove(0);//remove指定位置移除元素//返回为该元素
        System.out.println(I);
        System.out.println("-----------------------");
        for (int i =0;i<l.size();i++){
            System.out.print(l.get(i)+"\t");
        }
        System.out.println();

        Boolean b2 = l.remove(Integer.valueOf(234));//remove指定元素移除元素//返回为boolean
        l.remove(Integer.valueOf(234));//如果有相同的每次只移除最前面的该元素
        boolean b3 = l.remove(Integer.valueOf(123));
        System.out.println(b2+"  "+b3);
        System.out.println("-----------------------");
        for (int i =0;i<l.size();i++){
            System.out.print(l.get(i)+"\t");
        }



    }

}

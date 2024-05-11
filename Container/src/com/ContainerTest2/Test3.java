package com.ContainerTest2;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList容器的测试3
 */
public class Test3 {
    public static void main(String[] args) {

        List<String> l = new ArrayList<>();
        l.add("fuck");
        l.add("thanks");
        l.add("fuck");
        l.add("WC");
        l.add("fuck");
        l.add("shaBi");

        System.out.println("-----------查找元素位置----------");
        int i = l.indexOf("fuck");//indexOf(元素)查找元素第一次出现的位置，返回为int类型
        System.out.println(i);

        int i2 = l.lastIndexOf("fuck");//lastIndexOf（元素）查找元素最后一次出现的位置
        System.out.println(i2);

        int i3 = l.indexOf("sdf");//如果找不到，返回为-1
        System.out.println(i3);

        System.out.println("---------转化为数组");
        Object[] os = l.toArray();//toArray（）将单列集合转化为数组，返回为Object【】类型
        for (Object ss:os){
            System.out.print(ss);
        }
        System.out.println();
        String[] strings1 = l.toArray(new String[0]);//toArray（new 类型[0]）将单列集合转化为特定类型
        String[] strings2 = l.toArray(new String[2]);//无论[]里面填几都是一样的
        String[] strings3 = l.toArray(new String[l.size()]);
        for (int i1=0;i1<strings1.length;i1++){
            System.out.print(strings1[i1]+"\t");
            System.out.print(strings2[i1]+"\t");
            System.out.print(strings3[i1]+"\t");

        }



    }
}

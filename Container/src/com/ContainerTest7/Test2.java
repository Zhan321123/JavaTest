package com.ContainerTest7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Iterator的测试2
 */
public class Test2 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("liu");
        list.add("gao");
        list.add("com");

        Iterator<String> iterator = list.listIterator();

        System.out.println(iterator);//Iterator类没有toString（）方法

        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());//每用一次next（）方法，光标就会放到下一个元素位置
        System.out.println(iterator.hasNext());

        System.out.println(iterator.next());//没有遍历完，光标位置一直有元素，hasNext（）方法返回true
        System.out.println(iterator.hasNext());

        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());//遍历完之后，hasNext（）为false，也就是光标位置没有元素了

//        System.out.println(iterator.next());//遍历完之后，再调用next（）方法，会报错

        System.out.println(iterator);


    }
}

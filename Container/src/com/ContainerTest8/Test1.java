package com.ContainerTest8;

import java.util.*;

/**
 * 测试Collections容器类
 */
public class Test1 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("2");
        list.add("4");
        list.add("1");
        list.add("3");

        display(list);

        Collections.sort(list);//Collections.sort(List)，对list容器进行排序，void
        display(list);

        System.out.println("---------------------");
        Collections.shuffle(list);//Collections.shuffle（List），对list容器进行随机排序，void
        display(list);
        Collections.shuffle(list);
        display(list);

    }
    static <E> void display(Collection<E> collection){
        for (Iterator<E> iterator = collection.iterator();iterator.hasNext();){
            System.out.print(iterator.next()+" \t");
        }
        System.out.println();
    }
}

package com.ContainerTest7;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 方法的实验
 * 从Set和List中检测元素是否存在
 */
public class Test5 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(34);

        boolean b1 = find(set,3);
        System.out.println(b1);
        System.out.println(find(set, 34));

    }

    static <E> boolean find(Collection<E> collection,E e){
        for (Iterator<E> iterator = collection.iterator();iterator.hasNext();){
            if (iterator.next().equals(e)){
                return true;
            }
        }
        return false;
    }
}

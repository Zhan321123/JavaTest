package com.ContainerTest6;

import java.util.Comparator;
/**
 * 对象的比较
 * 实现Comparator可以用于比较
 */
public class StuComparator implements Comparator<Stu> {
    @Override
    public int compare(Stu o1, Stu o2) {
        if (o1.getAge()>o2.getAge()){
            return 1;
        }
        if (o1.getAge()==o2.getAge()){
            return o1.getName().compareTo(o2.getName());
        }
        return -1;
    }
}

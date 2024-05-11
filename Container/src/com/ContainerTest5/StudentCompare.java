package com.ContainerTest5;

import java.util.Comparator;

/**
 * 对象的比较器，继承Comparator实现对象比较
 */
public class StudentCompare implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAge()>o2.getAge()){
            return 1;
        }
        if (o1.getAge()==o2.getAge()){
             return o1.getName().compareTo(o2.getName());
        }
        return -1;
    }
}

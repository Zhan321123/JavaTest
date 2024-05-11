package com.ContainerTest5;

import java.util.Objects;

/**
 * 创建User对象类
 */
public class Users implements Comparable<Users>{
    private String name;
    private int age;

    public Users(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //equals（Object），对比两个对象的地址，或重写对比方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return age == users.age && Objects.equals(name, users.name);
    }

    //hashCode（），获取对象地址的哈希值，或重写哈希值获取方法
    @Override
    public int hashCode() {
        return Objects.hash(name, age);//Objects.hash(Object... values),以此获取哈希值
    }

    //toString(),获取对象的地址，或重写toString（）
    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //compareTo()，顺序的比较，如果有顺序比较比如TreeSet，必须要重写该方法，
    //  1： 在前
    //  0： 相等
    //  -1：在后
    @Override
    public int compareTo(Users o) {
        if (o.getAge()<this.age){
            return 1;
        }
        if (o.getAge()==this.age){
            return o.getName().compareTo(this.name);
        }
        return 0;
    }
}

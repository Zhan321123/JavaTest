package com.test1;

/**
 * 测试enum枚举
 */
public class Test1Enum {

    public static void main(String[] args) {
        student s = new student("wei",Gender.female);
        Gender sex = s.getSex();
        System.out.println(sex);
    }

}

/**
 * public enum name{}
 * 里面放常量，常量，...
 *
 * 在其他类定义属性为该enum
 * 其值只能为里面的常量
 */
enum Gender{
    male,female,doubleSex
}
class student{
    private String name;
    private Gender sex;

    public student(String name, Gender sex) {
        this.name = name;
        this.sex = sex;
    }

    public Gender getSex() {
        return sex;
    }
}
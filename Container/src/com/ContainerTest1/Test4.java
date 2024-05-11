package com.ContainerTest1;

/**
 * 泛型方法的测试
 */
public class Test4 {
    public static void main(String[] args) {
        IDontKnow i = new IDontKnow();
        i.getName("Fuck");
        i.getName(123);

        double name = i.name(9.99);
        String nn = i.name("nnnn");
        System.out.println(nn+name);

    }
}
class IDontKnow{
    protected <T> void getName(T name){
        System.out.println(name);
    }
    protected <T> T name (T name){
        return name;
    }
}
package com.ContainerTest1;

/**
 * 泛型类和方法的测试
 */
public class Test5 {

    public static void main(String[] args) {
        fnn.printFlag("fuck");
        fnn.printFlag(34647);

        System.out.println(fnn.setFlag("wok"));
        System.out.println(fnn.setFlag(4567));

    }

}

class fnn <T>{
    protected static <T> void printFlag(T flag){
        System.out.println(flag);
    }
    protected static <T> T setFlag(T flag){
        return flag;
    }

}

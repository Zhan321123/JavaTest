package com.ContainerTest1;

/**
 * 泛型在多元方法上的测试
 */
public class Test6 {
    public static void main(String[] args) {

        asd a = new asd();

        String[] ss = {"fuck","shit","My god"};
        a.sdf(ss);

        Integer[] is = {1,2,3,4,4};
        a.sdf(is);
    }
}

class asd {
    //Object...表示有未知个Object参数
    protected <T> void sdf(T...arg){
        for (T t:arg){
            System.out.println(t);
        }
    }
}
package com.ThreadTest1;

/**
 * 线程模拟
 */
public class Test4 {

    public static void main(String[] args) {
        testTurtle t1 = new testTurtle("turtle");
        testTurtle t2 = new testTurtle("rabbit");
        t1.start();
        t2.start();
    }
}
class testTurtle extends Thread{

    int i = 1;
    String name;

    testTurtle(String name){
        this.name = name;
    }

    @Override
    public void run() {
        while (i<1000) {
            System.out.println(name+"在跑" + i);
            i++;
        }
    }
}
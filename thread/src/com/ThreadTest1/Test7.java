package com.ThreadTest1;

/**
 * yield（）方法的测试
 * 让线程准备就绪
 */
public class Test7 {
    public static void main(String[] args) {

        w1 w1 = new w1();
        w2 w2 = new w2();

        w1.start();
        w2.start();
    }
}
class w1 extends Thread {
    @Override
    public void run() {
        while (true){
            System.out.println("rabbit++++");
            yield();
        }
    }
}
class w2 extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println("turtle");
            yield();
        }
    }
}
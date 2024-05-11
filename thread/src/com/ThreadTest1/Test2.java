package com.ThreadTest1;

/**
 * Thread线程与Runnable任务两种开启新线程
 *
 * Thread线程类
 * 优：方便
 * 缺：没什么可以继承的了
 *
 * Runnable任务接口
 * 优：还可以继承其他类，可以共享任务
 * 缺：稍微有一点麻烦
 */
public class Test2 {
    public static void main(String[] args) {

        Thread turtle = new Turtle();
        turtle.start();

        //new Thread（new Runnable）
        Runnable rabbit = new Rabbit();
        Thread t = new Thread(rabbit);
        t.start();

    }
}

class Turtle extends Thread{

    @Override
    public void run() {
        while(true){
            System.out.println("乌龟跑");
        }
    }
}

class Rabbit implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("兔子在跑");
        }
    }
}
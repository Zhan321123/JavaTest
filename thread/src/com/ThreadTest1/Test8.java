package com.ThreadTest1;

/**
 * 线程方法线程寄生setDaemon（）和线程打断interrupt（）
 * setDaemon（boolean），设置线程为是否寄生，会因为主线程被打断而断开连接
 */
public class Test8 {
    public static void main(String[] args) {

        Turtle8 t = new Turtle8();
        //在main方法下set某个线程daemon为true，该线程会因为主线程结束而结束
        t.setDaemon(true);
        t.start();

        sheep sheep = new sheep();
        sheep.start();

        int i=0;
        while (i<=100){
            System.out.println("rabbit"+i);
            i++;
        }
        //Thread.interrupt（），打断线程
        sheep.interrupt();

    }
}
class Turtle8 extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println("turtle");
        }
    }
}
class sheep extends Thread{
    @Override
    public void run() {
        //Thread.isInterrupt（），线程是否被打断
        while (!isInterrupted()){
            System.out.println("sheep");
        }
    }
}
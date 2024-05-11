package com.ThreadTest1;

import java.util.concurrent.TimeUnit;

/**
 * 在线程休息sleep时打断interrupt该线程
 * 以下在线程休息10s，在5s时打断该线程
 * 线程会报错，会有try跳转到catch中
 */
public class Test9 extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("-----1-----");
            System.out.println(this.isInterrupted());//false
            TimeUnit.SECONDS.sleep(10);
            System.out.println("-----2------");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("-----3------");
            System.out.println(this.isInterrupted());//false，在底层线程打断后会恢复，只有打断后立即is检测才会是true
        }
        System.out.println("------4------");
    }

    public static void main(String[] args) {
        Test9 t = new Test9();
        t.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }
}

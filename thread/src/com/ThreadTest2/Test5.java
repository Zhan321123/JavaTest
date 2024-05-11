package com.ThreadTest2;

/**
 * 关键字volatile
 * 保证同一变量在不同线程下的值统一
 */
public class Test5 {
    public volatile static boolean b = true;
    public static void main(String[] args) {
        new Thread(()->{
            int i=0;
            while (b){
//                System.out.println("----");
                i++;
            }
        }).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b = false;
    }
}

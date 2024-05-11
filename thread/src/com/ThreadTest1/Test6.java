package com.ThreadTest1;

import java.util.concurrent.TimeUnit;

/**
 * TimeUtil时间工具类的测试
 * TimeUtil下的成员量
 */
public class Test6 {
    public static void main(String[] args) {

        testRabbit rabbit = new testRabbit();
        rabbit.start();

        while (true){
            System.out.println("turtle");
            try {
                //TimeUtil.Seconds.sleep（int），按秒休息int
                //Thread.sleep（int），按毫秒休息
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
class testRabbit extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println("rabbit");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

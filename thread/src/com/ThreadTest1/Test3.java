package com.ThreadTest1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable接口实现新线程
 * 可以抛出异常，也可以有返回值
 */
public class Test3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //new Thread（new FutureTask<>（new Callable<>（）{}）），利用Callable新建线程
        Thread t1 = new Thread(new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        }));
        //也可以这么new
        Thread t2 = new Thread(new FutureTask<>(() -> 1));

        Callable<String> c = new myCallable();
        FutureTask<String> ft = new FutureTask<>(c);
        Thread t = new Thread(ft);

        t.start();
        System.out.println("1############");

        System.out.println(ft.isDone());
        System.out.println("2$$$$$$$$$$$$$$$$");
        //get（）方法，得不到返回值，就会一直等待，后面的也不会执行
        System.out.println(ft.get());
        System.out.println("5%%%%%%%%%%%%%%%%");
        System.out.println(ft.isDone());



    }
}

class myCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("2@@@@@@@@@");
        Thread.sleep(4000);
        return "4!!!!!!!!!!!!!";
    }
}

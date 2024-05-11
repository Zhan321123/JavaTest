package com.ThreadTest2;

/**
 * 线程问题及其简单解决方案
 * 问题：多个线程同时修改一个数据，出现两次都成功
 * 解决：用synchronized（）{}环绕
 */
public class Test1 {
    public static void main(String[] args) {

        Runnable r = new AccountRunnable();
        Thread t1 = new Thread(r, "Steve");
        Thread t2 = new Thread(r, "lucy");

        t1.start();
        t2.start();

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}

class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void withBalance(int money) {
        this.balance = balance - money;
    }
}

class AccountRunnable implements Runnable {
    Account account = new Account(600);

    @Override
    public void run() {
        //省略200句

        synchronized(account){

            if (account.getBalance() >= 400) {
                try {
                    Thread.sleep(60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.withBalance(400);
                System.out.println("success to with 400 money,residue " + account.getBalance());
            } else {
                System.out.println("failed to with money,residue " + account.getBalance());
            }

        }

        //省略300句
    }
}
package com.ThreadTest3;

/**
 * 优化Test1生产和消费行为
 */
public class Test2 {
    public static void main(String[] args) {
        Product2 p = new Product2();
        new Thread(p::produce).start();
        new Thread(() -> p.consume()).start();
    }
}

class Product2 {

    private String name;
    private String color;
    public boolean empty = true;

    public Product2() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public synchronized void consume() {
        while (true) {
            while (this.empty) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费了" + this);
            this.empty = true;
            this.notifyAll();
        }

    }

    public synchronized void produce() {
        while (true) {
            while (!empty) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (Math.random() > 0.5) {
                this.setName("wei");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.setColor("read");
            } else {
                this.setName("jing");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.setColor("yel");
            }
            System.out.println("生产了" + this);
            this.empty = false;
            this.notifyAll();
        }
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

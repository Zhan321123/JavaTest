package com.reflection1;

interface an {
    void shout();

    void run();
}

public abstract class Animal implements an {
    private int age;
    float speed;
    protected String sound;
    public String name;

    public Animal() {
    }

    public Animal(int age, String name, String sound) {
        this.age = age;
        this.name = name;
        this.sound = sound;
    }
}

class Dog extends Animal implements an {

    private int leg = 4;
    String head = "circle";
    protected int eye = 2;
    public boolean isCute = true;

    public Dog(int age, String name, String sound) {
        super(age, name, sound);
    }

    private Dog(int age) {
        this.name = age + " dog";
        this.sound = "I am " + age;

    }

    public Dog() {

    }

    @Override
    public void shout() {
        System.out.println("dog:" + sound);
    }

    private void shout(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("dog:" + sound);
        }
    }

    @Override
    public void run() {
        System.out.println("dog run!" + speed);
    }

    public void sleep() {
        System.out.println("dog sleep");
    }

    protected String introduce() {
        System.out.println("my name is " + super.name);
        return name + "  " + head;
    }

    void go() {
        System.out.println("go! go! go!");
    }

    private void setSelf(int leg, int eye, String head) {
        this.leg = leg;
        this.eye = leg;
        this.head = head;
    }

    @Override
    public String toString() {
        return "I am a dog, "+sound;
    }
}
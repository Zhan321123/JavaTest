package com.IOTest4;

import java.io.Serializable;

/**
 * 使用ObjectOutputStream和ObjectInputStream类传输的对象
 */
public class User implements Serializable {
    private int age;
    private String name;
    private int ID;

    public User() {
    }

    public User(int age, String name, int ID) {
        this.age = age;
        this.name = name;
        this.ID = ID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}

package com.ContainerTest1;

/**
 * 泛型类的创建
 * <T>在类名之后，就表示该类是泛型类
 * @param <T>
 */
public class Test1 <T>{
    private T t;

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return this.t;
    }
}

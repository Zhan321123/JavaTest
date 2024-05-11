package com.ContainerTest1;

/**
 * 泛型范围的测试
 */
public class Test8 {
    public static void main(String[] args) {

        A<Integer> a = new A<>();
//        a.setT("fuck");
        B b = new B();
        a.setT(123);
        b.show(a);

    }
}
class A <T> {
    T t ;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
class B{
    protected void show(A<? super Integer> a){
        System.out.println(a.t);
    }
}
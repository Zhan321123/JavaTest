package com.ContainerTest1;

/**
 * 泛型的范围限制的测试
 * 用extend和super限制
 * ？ extend Object1 super Object2
 * 泛型类的范围限制
 */
public class Test7 {
    public static void main(String[] args) {

        qq<String> q1 = new qq<>();
        ww w = new ww();

        q1.setFlag("fuck");
//        w.Sh(q1);

        qq<Integer> q2 = new qq<>();
        q2.setFlag(123);
        w.Sh(q2);

    }
}

class qq <T>{
    private T Flag;

    public T getFlag() {
        return Flag;
    }

    public void setFlag(T Flag) {
        this.Flag = Flag;
    }
}

class ww{
    protected void Sh(qq<? extends Number> q){
        System.out.println(q.getFlag());
    }
}
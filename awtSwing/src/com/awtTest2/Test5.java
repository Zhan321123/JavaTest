package com.awtTest2;

import com.awtTest1.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 自建内部类实现事件监听
 * 实现一个按钮的作用
 */
public class Test5 {
    Frame f = Main.addFrame2();
    TextField tf = new TextField(30);
    Button b = new Button("Click");

    /**
     * 内部类Listener实现行为监听类
     * 在内部重写actionPerformed方法
     */
    private class MyListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            tf.setText("Hello World");
        }
    }

    //组装界面
    //并把事件监听添加到button里
    private void initializing(){
        //addActionListener（new ActionListener）
        b.addActionListener(new MyListener());

        f.add(tf);
        f.add(b,BorderLayout.SOUTH);
        f.pack();
    }

    public static void main(String[] args) {
        new Test5().initializing();
    }


}

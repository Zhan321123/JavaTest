package com.awtTest1;

import java.awt.*;

/**
 * 窗口布局类之一 FlowLayout 的测试
 * 像写字一样布局，从头开始，碰到边缘就”换行“
 */
public class Test4 {
    public static void main(String[] args) {

        Frame f = Main.addFrame(200, 200, 400, 400);

        /*
        布局类
        new FlowLayout（对齐方向，行距，列距）
        对齐方向有左右上下
         */
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 200, 40);
        //setLayout（FlowLayout），将窗口设置为此布局
        f.setLayout(flowLayout);

        for (int i = 0; i < 100; i++) {
            TextField t = new TextField(3);
            f.add(t);
        }

        /*
        如果没有定义窗口大小及位置，那么调用pack（）方法，使得窗口“最佳“
         */
        Frame frame = new Frame();
        frame.setLayout(new FlowLayout(FlowLayout.RIGHT,10,0));
        for (int i=0;i<100;i++){
            frame.add(new Button(i+""));
        }
        frame.setVisible(true);
        frame.pack();//pack（），方法使得窗口位置大小最佳

        /*
        new FlowLayout(),无参时是水平居中，相当于没有任何效果，行列间距为5
        new FlowLayout（方向），默认行列间距为5
         */
        Frame frame1 = new Frame();
        frame.setLayout(new FlowLayout());
        for (int i=0;i<100;i++){
            frame1.add(new Button("Fuck"));
        }
        frame1.setVisible(true);
        frame1.pack();



    }
}

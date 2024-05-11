package com.awtTest3;

import com.awtTest1.Main;

import java.awt.*;
import java.util.Random;

/**
 * Canvas画布类的测试
 * 相当于一个组件，被frame.add
 * 与Frame的paint方法一致
 */
public class Test1 {

    public Frame f = Main.addFrame2();
    Button b1 = new Button("draw rectangle");
    Button b2 = new Button("draw oval");
    Panel p1 = new Panel();
    boolean bb1 = false;
    boolean bb2 = false;

    //用一个类继承Canvas，重写paint方法
    private class MyCanvas extends Canvas{
        @Override
        public void paint(Graphics g) {
            Random r = new Random();
            if (bb1) {
                g.drawRect(r.nextInt(300), r.nextInt(300), r.nextInt(100), r.nextInt(100));
                bb1 = false;
            }
            if (bb2) {
                g.drawOval(r.nextInt(300), r.nextInt(300), r.nextInt(100), r.nextInt(100));
                bb2 = false;
            }
        }
    }

    /**
     * 组装每个部件
     */
    private void initializing(){
        p1.add(b1);
        p1.add(b2);
        MyCanvas myCanvas = new MyCanvas();
        //canvas也可以setPreferredSize（new Dimension（int width，int height））
        myCanvas.setPreferredSize(new Dimension(400,400));
        //用Frame来add（canvas）
        f.add(myCanvas);
        f.add(p1,BorderLayout.SOUTH);

        b1.addActionListener(e ->  {
            bb1 = true;
            /*
            repaint（）方法重画画布
            会先清除内容，再画上新内容
             */
            myCanvas.repaint();
        });
        b2.addActionListener(e -> {
            bb2 = true;
            myCanvas.repaint();
        });

        f.pack();

    }

    public static void main(String[] args) {
        new Test1().initializing();
    }
}

package com.awtTest3;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * 利用awt实现在窗口上绘图
 */
public class Test3 {
    Frame f = new Frame("Test1");
    /*
    调整颜色组件PopupMenu和MenuItems
    以及清空组件
     */
    PopupMenu pm = new PopupMenu();
    MenuItem miRed = new MenuItem("Red");
    MenuItem miBlue = new MenuItem("Blue");
    MenuItem miGreen = new MenuItem("Green");
    MenuItem miBlack = new MenuItem("Black");
    MenuItem miClear = new MenuItem("Clear");

    //窗口长w宽h
    final int w = 800;
    final int h = 700;

    /*
    设定BufferedImage
    将其画到Canvas画布上
    获取画布的图形Graphics用以在上面画画
     */
    BufferedImage bufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    Graphics g = bufferedImage.getGraphics();

    //画布，将BufferedImage画到上面
    private class myCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            g.drawImage(bufferedImage, 0, 0, null);
        }
    }

    myCanvas myCanvas = new myCanvas();
    /*
    设置成员变量，为坐标，可以判定是否要画
    设置为成员变量是为了让匿名内部类可以修改和访问
     */
    private int x0 = -1;
    private int y0 = -1;

    private void initializing() {
        //将四个组件MenuItem添加到PopupMenu上，并设置其修改颜色
        pm.add(miRed);
        pm.add(miBlue);
        pm.add(miGreen);
        pm.add(miBlack);
        pm.add("-");
        pm.add(miClear);
        miRed.addActionListener(e -> g.setColor(Color.red));
        miBlue.addActionListener(e -> g.setColor(Color.blue));
        miGreen.addActionListener(e -> g.setColor(Color.green));
        miBlack.addActionListener(e -> g.setColor(Color.black));
        miClear.addActionListener(e->{
            Color c = g.getColor();
            g.setColor(Color.white);
            g.fillRect(0,0,w,h);
            myCanvas.repaint();
            g.setColor(c);
        });


        //窗口添加画布，画布添加组件，设置画布大小
        f.add(myCanvas);
        myCanvas.add(pm);
        myCanvas.setPreferredSize(new Dimension(w, h));

        //设置鼠标点击事件
        myCanvas.addMouseListener(new MouseAdapter() {

            //右击时展示组件面板及其位置
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) {
                    pm.show(myCanvas, e.getX(), e.getY());
                }
            }

            //鼠标松开将坐标设为初始值
            @Override
            public void mouseReleased(MouseEvent e) {
                x0 = -1;
                y0 = -1;
            }

        });

        //画出白色背景，并将画笔颜色改为黑色，以方便画画
        g.setColor(Color.white);
        g.fillRect(0, 0, w, h);
        g.setColor(Color.black);

        //画布添加鼠标移动事件
        myCanvas.addMouseMotionListener(new MouseAdapter() {
            //鼠标拖动事件，画画
            @Override
            public void mouseDragged(MouseEvent e) {

                if (x0 != -1 && y0 != -1) {
                    g.drawLine(x0, y0, e.getX(), e.getY());
                }
                x0 = e.getX();
                y0 = e.getY();

                //只要鼠标在移动就调用repaint,才能画出来
                myCanvas.repaint();

            }
        });

        f.setVisible(true);
        f.setLocation(400, 100);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.pack();


    }

    public static void main(String[] args) {
        new Test3().initializing();
    }


}

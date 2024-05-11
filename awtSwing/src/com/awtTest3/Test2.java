package com.awtTest3;

import java.awt.*;
import java.awt.event.*;

/**
 * 利用canvas画布和其他组件完成弹弹小球游戏
 */
public class Test2 {
    Frame f = new Frame("BallGame");
    Panel p1 = new Panel();
    Panel p2 = new Panel();
    Button b1 = new Button("Start Game");
    Button b2 = new Button("Re Play");
    //游戏状态，0为未开始，1为游戏进行中，2为游戏结束
    int state = 0;

    final int WIDTH = 500;
    final int HEIGHT = 700;

    myCanvas myCanvas = new myCanvas();

    private void initializing(){
        myCanvas.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        f.setVisible(true);
        f.setLocation(400,100);
        f.setSize(WIDTH,HEIGHT);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        p2.add(b2);
        p1.add(b1);

        f.add(myCanvas);

        f.add(p1,BorderLayout.SOUTH);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state = 1;
                f.remove(p1);
                f.remove(myCanvas);
                f.add(myCanvas);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state = 0;
                f.remove(p2);
                f.add(p1,BorderLayout.SOUTH);
                ball.y = 100;
                ball.angle = Math.PI*2*Math.random();
            }
        });
        KeyListener keyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 37){
                    racket.left = true;
                }
                if (e.getKeyCode() == 39){
                    racket.right = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 37){
                    racket.left = false;
                }
                if (e.getKeyCode() == 39){
                    racket.right = false;
                }
            }
        };
        myCanvas.addKeyListener(keyListener);

        while(true){
            myCanvas.repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    ball ball = new ball();
    racket racket = new racket();



    Image offScreenImage;
    private class myCanvas extends Canvas {
    @Override
    public void paint(Graphics g) {
//        offScreenImage = createImage(WIDTH,HEIGHT);
//        Graphics g = offScreenImage.getGraphics().create();
//        g.setColor(Color.PINK);
//        g.fillRect(0,0,Test2.this.WIDTH,Test2.this.HEIGHT);
//        g.setColor(Color.black);

        switch (state) {
            case 0:
                g.drawString("弹弹球游戏,按住←或→移动", 200, 300);
                break;
            case 1:
                paintState1(g);
                break;
            case 2:
                g.drawString("游戏结束",200,300);
                break;
        }

//        gg.drawImage(offScreenImage,0,0,null);
    }

    private void paintState1(Graphics g) {
        ball.paint(g);
        racket.paint(g);
        if (ball.getRec().intersects(racket.getRec())) {
            ball.angle = Math.PI - ball.angle;
        }
        if (ball.y > Test2.this.HEIGHT) {
            state = 2;
            f.remove(myCanvas);
            f.add(myCanvas);
            f.add(p2,BorderLayout.NORTH);
        }
    }
}

    private class ball{
        int x = 100;
        int y = 200;
        int speed = 10;
        int w = 20;
        double angle = Math.random()*Math.PI*2;

        public void paint(Graphics g){
            g.fillOval(x,y,w,w);
            y += Math.cos(angle)*speed;
            x += Math.sin(angle)*speed;
            if (y<0){
                angle = Math.PI-angle;
            }
            if (x<0 || x>WIDTH-w){
                angle = -angle;
            }
        }
        public Rectangle getRec(){
            return new Rectangle(x,y,w,w);
        }
    }

    private class racket{
        int x = 200;
        int y = 600;
        int speed = 8;
        int w = 100;
        int h = 50;
        boolean left = false;
        boolean right = false;

        public void paint(Graphics g){
            g.fillRect(x,y,w,h);
            if (left && x>0){
                x -= speed;
            }
            if (right && x<WIDTH-w){
                x += speed;
            }
        }
        public Rectangle getRec(){
            return new Rectangle(x,y,w,h);
        }
    }

    public static void main(String[] args) {
        new Test2().initializing();
    }
}

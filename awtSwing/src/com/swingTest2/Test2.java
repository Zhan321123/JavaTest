package com.swingTest2;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * JTabbedPane多页选项板的测试
 * 就像HelloMCLaunch上的页面一样
 * 点击选项实现页面的切换
 */
public class Test2 {
    JFrame jf = new JFrame("JiNiTiMi");


    //new JTabbedPane（int 方向位置，int 选项卡布局）
    JTabbedPane jtp = new JTabbedPane(SwingConstants.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);
    JTextArea jta = new JTextArea();
    JList<String> jl = new JList<>(new String[]{"User1", "User2", "User3"});

    private void initializing() {

        initializing1();

        /*
        JTabbedPane.addTab（title，ImageIcon，组件）
        在多页选项卡上添加页面，另外一个方向可以任何组件
        点击选项实现页面的切换
         */
        jtp.addTab("Write", new ImageIcon("images\\minecraft\\diamond_block.png"), jta);
        jtp.addTab("Paint", new ImageIcon("images\\minecraft\\iron_block.png"), jPanel);
        jtp.addTab("Users", new ImageIcon("images\\minecraft\\gold_block.png"), jl);

        //setEnabledAT（int index，boolean），设置是否可以点击，否的话为灰色不可点击，默认是true
        jtp.setEnabledAt(2,true);
        //setSelectedIndex（int），默认时界面所在的页数
        jtp.setSelectedIndex(1);
        //addChangeListener（new ChangedListener（）{}），添加页面切换事件监听
        jtp.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("you choose "+jtp.getSelectedIndex());
            }
        });

        jl.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println("It is "+jl.getSelectedValue());
            }
        });

        jf.add(jtp);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(3);
        jf.setSize(500, 600);
        jf.setLocationRelativeTo(null);
    }

    /**
     * 下面是画画界面的JPanel
     */
    JPanel jPanel = new JPanel(new BorderLayout());
    Button b1 = new Button("draw rectangle");
    Button b2 = new Button("draw oval");
    Button b3 = new Button("clear");
    Panel p1 = new Panel();
    BufferedImage bi = new BufferedImage(500,400,BufferedImage.TYPE_INT_RGB);
    Graphics g = bi.getGraphics();

    private class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            g.drawImage(bi, 0, 0, null);
        }
    }

    private void initializing1() {
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        MyCanvas myCanvas = new MyCanvas();
        myCanvas.setPreferredSize(new Dimension(400, 400));
        g.fillRect(0,0,500,400);
        g.setColor(Color.black);

        Random r = new Random();

        b1.addActionListener(e -> {
            g.drawRect(r.nextInt(300), r.nextInt(300), r.nextInt(100), r.nextInt(100));
            myCanvas.repaint();
        });
        b2.addActionListener(e -> {
            g.drawOval(r.nextInt(300), r.nextInt(300), r.nextInt(100), r.nextInt(100));
            myCanvas.repaint();
        });
        b3.addActionListener(e->{
            g.setColor(Color.white);
            g.fillRect(0,0,500,400);
            myCanvas.repaint();
            g.setColor(Color.black);
        });

        jPanel.add(p1, BorderLayout.SOUTH);
        jPanel.add(myCanvas);
    }


    public static void main(String[] args) {
        new Test2().initializing();
    }
}

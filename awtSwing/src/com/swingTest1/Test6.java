package com.swingTest1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * JOptionPane选型窗格类的信息展示showMessageDialog的测试
 * 只有一个确定按钮
 */
public class Test6 {
    JFrame jf = new JFrame("Test1");

    TextField tf1 = new TextField();
    TextField tf2 = new TextField();
    Box b = new Box(1);

    JButton jb = new JButton(new AbstractAction("登录") {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*
            JOptionPane.showMessageDialog（组件 提供相对位置，message 提示信息，title 窗口标题，int 信息类型）
            弹出一个窗口，窗口上会显示一个图标和提示信息和一个确定按钮
            信息类型决定图标，组件决定窗口相对位置
            信息类型为-1，没有图标

            注意：点击确定按钮之前，会暂停运行！！！
             */
            JOptionPane.showMessageDialog(jf,"你干嘛","哎哟",0);
            /*
            JOptionPane.showMessageDialog（组件，message，title，-1，new ImageIcon（String 路径））
            弹出窗口，自定义icon图标，信息类型的图标会被覆盖，所以不如直接填-1
             */
            JOptionPane.showMessageDialog(jf,"密码或账号有误，请重新输入","error",
                    -1,new ImageIcon("images\\minecraft\\purpur_block.png"));
        }
    });

    private void initializing(){
        jf.setVisible(true);
        jf.setLocation(300,200);
        jf.setDefaultCloseOperation(3);

        jf.add(jb,BorderLayout.SOUTH);
        jf.add(b);
        b.add(tf1);
        b.add(tf2);

        jf.pack();
    }

    public static void main(String[] args) {
        new Test6().initializing();
    }
}

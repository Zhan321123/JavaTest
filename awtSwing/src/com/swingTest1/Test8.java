package com.swingTest1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * JOptionPane类下showInputDialog输入窗口的测试
 * 会有一个TextField和确定按钮
 */
public class Test8 {
    JFrame jf = new JFrame("f");
    JTextArea jta = new JTextArea(6,40);
    JButton jb = new JButton(new AbstractAction("log in") {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*
            JOptionPane.showInputDialog（组件，message，title，窗口类型）
            返回String，是文本框里的内容
            空时点确定，String是”“
            如果点取消，String是null，注意空指针异常
             */
            String s = JOptionPane.showInputDialog(jf, "请输入口令", "value", JOptionPane.INFORMATION_MESSAGE);
            if (s!=null && s.equals("minecraft")){
                jta.append("successful");
            }
        }
    });

    private void initializing(){
        jf.add(jta);
        jf.add(jb,BorderLayout.SOUTH);



        jf.setVisible(true);
        jf.setLocation(300,200);
        jf.setDefaultCloseOperation(3);
        jf.pack();
    }

    public static void main(String[] args) {
        new Test8().initializing();
    }

}

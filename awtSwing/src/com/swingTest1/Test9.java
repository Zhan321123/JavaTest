package com.swingTest1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
/**
 * JOptionPane类下的showOptionDialog多选项框的测试
 * 有多个选项框
 */
public class Test9 {
    JFrame jf = new JFrame("g");
    JTextArea jta = new JTextArea(6,40);
    JScrollPane jsp = new JScrollPane(jta);
    JButton jb = new JButton(new AbstractAction("选择类型") {
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] s = {"fuck","dull","shit"};
            /*
            JOptionPane.showOptionDialog（组件，message，title，选项类型，信息类型，ImageIcon，String[]，String 默认选项）
            有以string[]为JLabel的所有的按钮，按照顺序，点击返回int从0开始依次递增
             */
            int i = JOptionPane.showOptionDialog(jf, "请选择", "选择框", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, new ImageIcon("images\\structure_block_save.png"),
                    s, "shit");
            switch (i){
                case 0:
                    jta.append("fuck\n");
                    break;
                case 1:
                    jta.append("dull\n");
                    break;
                case 2:
                    jta.append("shit\n");
                    break;
            }
        }
    });

    private void initializing(){
        jf.add(jsp);
        jf.add(jb, BorderLayout.SOUTH);

        jf.setDefaultCloseOperation(3);
        jf.setLocation(300,200);
        jf.setVisible(true);
        jf.pack();
    }

    public static void main(String[] args) {
        new Test9().initializing();
    }
}

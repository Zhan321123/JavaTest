package com.swingTest1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * 颜色选择界面JColorChooser.showDialog的测试
 * 相当于PS的颜色选择小窗口
 */
public class Test4 {
    JFrame jf = new JFrame("ColorChose");
    JTextArea jta = new JTextArea(6, 40);
    //new JButton可以直接定义事件
    JButton jb = new JButton(new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*
            JColorChooser.showDialog（组件，String 颜色选择界面的标题，Color 默认选择的颜色）
            打开颜色选择器界面
            含有 颜色样本、HSV、HSL、RGB、CMYK 五种选择选择器
             */

            Color c = JColorChooser.showDialog(jf, "Choose a color", Color.white);
            jta.setBackground(c);
        }
    });

    private void initializing() {
        jf.setVisible(true);
        jf.setLocation(300, 200);
        jf.setDefaultCloseOperation(3);
        jf.add(jta);
        jf.add(jb, BorderLayout.SOUTH);

        jf.pack();
    }

    public static void main(String[] args) {
        new Test4().initializing();
    }
}

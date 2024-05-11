package com.swingTest1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * JToolBar工具条的测试
 * 像PS上的工具条一样，可以移动，贴到Frame四个边框上
 * 可以add的有Action和其他组件
 */
public class Test3 {
    JFrame jf = new JFrame("TestJToolBar");
    //new JToolBar（），新建工具条对象
    JToolBar jtb = new JToolBar();

    //将区域文本添加到滚动组件上可以实现滚动
    //new JScrollPane（JTextArea）
    JTextArea jta = new JTextArea();
    JScrollPane jsb = new JScrollPane(jta);

    /*
    新建Action对象，赋予name和ImageIcon，然后添加到工具条上，就成一个图标按钮
     */
    Action a1 = new AbstractAction("",new ImageIcon("images\\diamond_block.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("diamond\n");
        }
    };

    Action a2 = new AbstractAction("",new ImageIcon("images\\gold_block.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("gold\n");
        }
    };

    Action a3 = new AbstractAction("",new ImageIcon("images\\copper_block.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("copper\n");
        }
    };

    private void initializing(){
        jf.setDefaultCloseOperation(3);
        jf.setLocation(300,200);
        jf.setVisible(true);

        jf.add(jtb, BorderLayout.NORTH);
        jtb.add(a1);
        jtb.add(a2);
        jtb.add(a3);

        jf.add(jsb);
        jsb.setPreferredSize(new Dimension(400,200));


        jf.pack();

    }

    public static void main(String[] args) {
        new Test3().initializing();
    }
}

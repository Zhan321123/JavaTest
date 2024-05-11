package com.swingTest1;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 * 边框类的测试
 * 测试七种边框
 */
public class Test2 {
    JFrame jf = new JFrame("TestBorder");
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();
    JPanel jp3 = new JPanel();
    JPanel jp4 = new JPanel();
    JPanel jp5 = new JPanel();
    JPanel jp6 = new JPanel();
    JPanel jp7 = new JPanel();
    JPanel jp8 = new JPanel();

    private void initializing(){

        jf.setLayout(new GridLayout(2,8));
        for (JPanel jp :new JPanel[]{jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8}){
            jf.add(jp);
            jp.setPreferredSize(new Dimension(100,100));
        }
        jf.setVisible(true);
        jf.setLocation(300,200);
        jf.setDefaultCloseOperation(3);

        /*
        组件.setBorder（边框），为组件设置边框
        组件有
            一、斜边边界
        new BevelBorder（组件类型，Color 四种颜色）
        边框四边设置不同颜色，颜色宽度为1，类型会影响颜色顺序
        还会存有黑线边框
            二、线条边框
        new LineBorder（Color，int 宽度）
        设置内边框，由该颜色以该宽度围成一圈
            三、空边框
        new EmptyBorder（int top宽度，int left宽度，int bottom宽度，int right宽度）
        设置后无效果，是空边框
            四、雕刻边框
        new EtchedBorder（类型，发散颜色，边框颜色）
        设置边框颜色和边框发散的颜色
            五、标题边框
        new TitledBorder（边框类型，String title）
        new TitledBorder（边框类型，String title，设置边框位置，设置位置，Font 设置字体）
        设置带有标题的边框，用该类型包裹
        默认时位置在上边框的左边
            六、无光泽方形边框
        new MatteBorder（int top，int left，int bottom，int right，颜色）
        设置为边框每个边的长度以及颜色
            七、组合边框
        new CompoundBorder（外边框，内边框）
        设置为组合边框边框
         */
        jp1.setBorder(new BevelBorder(BevelBorder.RAISED,Color.red,Color.yellow,Color.blue,Color.green));
        jp2.setBorder(BorderFactory.createLineBorder(Color.cyan,20));
        jp3.setBorder(BorderFactory.createEmptyBorder(5,10,15,20));
        jp4.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED,Color.orange, Color.green));
        TitledBorder b1 = new TitledBorder(new LineBorder(Color.magenta,10),"TitleBorder",
                TitledBorder.RIGHT,TitledBorder.BOTTOM,new Font("黑体",Font.BOLD,10),Color.gray);
        jp5.setBorder(b1);
        MatteBorder b2 = new MatteBorder(5,10,15,20,Color.pink);
        jp6.setBorder(b2);
        jp7.setBorder(new CompoundBorder(b2,b1));


        jf.pack();
    }

    public static void main(String[] args) {
        new Test2().initializing();
    }
}

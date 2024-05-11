package com.swingTest1;

import javax.swing.*;
import java.awt.*;

/**
 * swing中awt组件的测试
 * 大部分都是在类名前加上“J”
 * 用法略有不同，基本都相同
 */
public class Test1 {
    //new JFrame，新建窗口类
    JFrame jf = new JFrame("Test1");
    //new JMenuBar，顶部菜单对象
    JMenuBar jmb = new JMenuBar();
    //new JMenu，菜单
    JMenu jm1 = new JMenu("文件");
    //new JMenuItem，菜单选项
    JMenuItem jmi1 = new JMenuItem("打开");
    JMenuItem jmi2 = new JMenuItem("保存");

    JMenu jm2 = new JMenu("edit");
    /*
    new 组件（JLabel，new ImageIcon（String 路径）），给组件加上图片
     */
    JMenuItem jmi3 = new JMenuItem("copy",new ImageIcon("images\\diamond_block.png"));
    JMenuItem jmi4 = new JMenuItem("paste",new ImageIcon("images\\emerald_block.png"));
    JMenu jm3 = new JMenu("format");
    JMenuItem jmi6 = new JMenuItem("note");
    JMenuItem jmi7 = new JMenuItem("cancel");

    JPanel jp1 = new JPanel(new BorderLayout());
    JPanel jp2 = new JPanel();
    JPanel jp3 = new JPanel(new BorderLayout());
    JPanel jp4 = new JPanel();

    //new JTextArea，文本区域
    JTextArea jta = new JTextArea(4, 40);
    //new JCheckBox判断选项
    JCheckBox jcb = new JCheckBox("是否已婚");
    /*
    new JList<T>，列表选项框
    new JList<T>(T[] 列表选项)，列表选项加入组件中
     */
    String[] ss = new String[]{"red", "green", "blue"};
    JList<String> jl = new JList<>(ss);
    //new JTextField，单行文本
    JTextField jtf = new JTextField(30);
    //new JButton，按钮
    JButton jb = new JButton("OK",new ImageIcon("images\\gold_block.png"));
    //new JCombBox<T>，下拉选项
    JComboBox<String> jcbb = new JComboBox<>();
    /*
    new ButtonGroup单选容器
    不是组件，只能让内容只选择一个
    当其中一个为true时，其他会设置为false
     */
    ButtonGroup bg = new ButtonGroup();
    //new JRadioButton单选选项
    JRadioButton jrb1 = new JRadioButton("female");
    JRadioButton jrb2 = new JRadioButton("male", true);
    //new JPopupMenu，弹出菜单
    JPopupMenu jpm = new JPopupMenu();
    ButtonGroup bg2 = new ButtonGroup();
    JRadioButtonMenuItem jrbmi1 = new JRadioButtonMenuItem("window",new ImageIcon("images\\iron_block.png"));
    JRadioButtonMenuItem jrbmi2 = new JRadioButtonMenuItem("metal");
    JRadioButtonMenuItem jrbmi3 = new JRadioButtonMenuItem("other");


    private void initializing() {
        //setDefaultCloseOperation（3），设置窗口库关闭
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLocation(300, 200);
        jf.setVisible(true);
        jf.setJMenuBar(jmb);
        jmb.add(jm1);
        jmb.add(jm2);

        jm1.add(jmi1);
        jm1.add(jmi2);
        jm2.add(jmi3);
        jm2.add(jmi4);
        //addSeparator(),添加分隔符
        jm2.addSeparator();
        jm2.add(jm3);

        jm3.add(jmi6);
        jm3.add(jmi7);

        //下拉选项，addItem
        jcbb.addItem("red");
        jcbb.addItem("green");
        jcbb.addItem("yellow");

        jf.add(jp1);
        jf.add(jp2, BorderLayout.SOUTH);

        jp2.add(jtf);
        jp2.add(jb);

        jp1.add(jp3);
        jp1.add(jl, BorderLayout.EAST);

        jp3.add(jta);
        jp3.add(jp4, BorderLayout.SOUTH);

        jp4.add(jcbb);
        jp4.add(jcb);
        jp4.add(jrb1);
        jp4.add(jrb2);

        bg.add(jrb1);
        bg.add(jrb2);

        //设置右键弹出菜单
        jta.setComponentPopupMenu(jpm);
        jpm.add(jrbmi1);
        jpm.add(jrbmi2);
        jpm.add(jrbmi3);
        bg2.add(jrbmi1);
        bg2.add(jrbmi2);
        bg2.add(jrbmi3);

        jrbmi1.addActionListener(e -> {
            try {
                /*
                UIManger.setLookAndFeel（）
                设置窗口风格
                需要try catch，没有的画会报错
                 */
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            /*
            设置完窗口风格之后还要刷新组件才能显示新的风格
            SwingUtilities.updateComponentTreeUI（组件）
            组件.getContentPane（），获取组件容器下的所有组件及其容器下的组件
            JFrame的getContentPane（）不包括顶部菜单和弹出菜单
             */
            SwingUtilities.updateComponentTreeUI(jf.getContentPane());
            SwingUtilities.updateComponentTreeUI(jmb);
            SwingUtilities.updateComponentTreeUI(jpm);
        });
        /*
        组件.setToolTipText（String），组件的提示
        将鼠标停留在组件上一段时间就会显示
         */
        jrbmi1.setToolTipText("可以设置不同的风格");

        jf.pack();
    }


    public static void main(String[] args) {
        new Test1().initializing();
    }

}

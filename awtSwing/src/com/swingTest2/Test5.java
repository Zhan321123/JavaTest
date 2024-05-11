package com.swingTest2;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;

/**
 * 利用JList和JComboBox选项栏的案例
 */
public class Test5 {
    JFrame jf = new JFrame("gg");
    String[] s = new String[]{"Java","C++","Python","PHP","C"};
    JComboBox<String> jcb = new JComboBox<>(s);//new JComboBox<>（T[]），新建下拉选项栏对象
    JList<String> jl = new JList<>(s);//new JList<>（T[])，新建选项栏对象
    JScrollPane jsp = new JScrollPane(jl);
    JTextArea jta = new JTextArea(6,40);

    public static void main(String[] args) {
        new Test5().initialize();
    }

    /**
     * 整体布局
     */
    private void initialize(){
        init1();
        init2();
        init4();
        init5();

        jl.setVisibleRowCount(3);
        jl.setSelectionInterval(2,4);

        //JComboBox.setEditable（boolean），设置是否可编辑
        jcb.setEditable(true);
        //MaximumRowCount（int），设置下拉最多能看到几个选项
        jcb.setMaximumRowCount(3);

        Box b = new Box(BoxLayout.Y_AXIS);
        b.add(jsp);
        b.add(jp1);
        b.add(jp2);

        Box b2 = new Box(BoxLayout.X_AXIS);
        b2.add(b);
        b2.add(jp4);

        Box b3 = new Box(BoxLayout.Y_AXIS);
        b3.add(b2);
        b3.add(jp5);

        jf.add(b3);

        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.pack();
        jf.setLocationRelativeTo(null);
    }

    /**
     * 单选1的布局
     */
    JPanel jp1 = new JPanel();
    private void init1(){
        jp1.setBorder(new TitledBorder("Border"));
        //new JRadioButton（text），新建选项对象
        JRadioButton jb1 = new JRadioButton("纵向滚动");
        JRadioButton jb2 = new JRadioButton("纵向换行");
        JRadioButton jb3 = new JRadioButton("横向换行");
        jp1.add(jb1);
        jp1.add(jb2);
        jp1.add(jb3);

        //JRadioButton.setSelected（boolean），设置是否选择，默认为否
        jb1.setSelected(true);

        //JList.setLayoutOrientation（int 方向），设置布局方向
        jb1.addActionListener(e->jl.setLayoutOrientation(JList.VERTICAL));
        jb1.addActionListener(e->jl.setLayoutOrientation(JList.VERTICAL_WRAP));
        jb1.addActionListener(e->jl.setLayoutOrientation(JList.HORIZONTAL_WRAP));

        ButtonGroup bg = new ButtonGroup();
        bg.add(jb1);
        bg.add(jb2);
        bg.add(jb3);
    }

    /**
     * 单选2的布局
     */
    JPanel jp2 = new JPanel();
    private void init2(){
        jp2.setBorder(new TitledBorder("mode"));
        JRadioButton jb1 = new JRadioButton("无限制");
        JRadioButton jb2 = new JRadioButton("单选");
        JRadioButton jb3 = new JRadioButton("单范围");
        jp2.add(jb1);
        jp2.add(jb2);
        jp2.add(jb3);

        jb1.setSelected(true);

        /*
        JList.setSelectionMode（int 方式），设置选择方式
        有 单选，多选，单范围选择
         */
        jb1.addActionListener(e->jl.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION));
        jb1.addActionListener(e->jl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION));
        jb1.addActionListener(e->jl.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION));

        ButtonGroup bg = new ButtonGroup();
        bg.add(jb1);
        bg.add(jb2);
        bg.add(jb3);
    }
    /**
     * JList的布局
     */
    JPanel jp4 = new JPanel();
    private void init4(){
        jp4.add(jcb);
        jcb.addActionListener(e->{
            Object o = jcb.getSelectedItem();
            if (o != null) {
                jta.setText(o.toString());
            }
        });
        jl.addListSelectionListener(e->{
            jta.setText("");
            List<String> ss = jl.getSelectedValuesList();
            for (String s:ss){
                jta.append(s+"\n");
            }
        });
    }

    /**
     * JComboBox的布局
     */
    JPanel jp5 = new JPanel(new BorderLayout());
    private void init5(){
        //单独的文本和Icon可以用new JLabel（text or Icon）
        JLabel jLabel = new JLabel("选择有:");
        jp5.add(jLabel,BorderLayout.NORTH);
        jp5.add(jta);
    }


}

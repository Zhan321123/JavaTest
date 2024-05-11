package com.swingTest4JTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.Vector;

/**
 * 测试表格JTable的模型DefaultTableModel加行加列的方法
 */
public class Test3 {

    JFrame jf = new JFrame("a");

    Object[] title = new Object[]{"name", "job", "address", "hobby"};
    Object[][] data = new Object[][]{
            {"Tom", "fuck", "American", "fuck"},
            {"Steve", "shit", "Japan", "fuck"},
            {"Lucy", "fuck", "Canada", "fart"},
            {"Zhan", "eat", "China", "read"},
            {"Tim", "fuck", "Russian", "sleep"},
    };
    //new DefaultTableModel（data 一维数组，title 二维数组），新建表格模型，可以实现数据删减
    DefaultTableModel dtm = new DefaultTableModel(data,title);
    //new JTable（DefaultTableModel），利用该模型新建表格
    JTable jt = new JTable(dtm);

    Vector<String> titleV = new Vector<>();
    Vector<Object> dataV = new Vector<>();
    private void init1(){
        dataV.addAll(Arrays.asList(title));
        for (Object[] os:data){
            Vector<Object> v = new Vector<>(Arrays.asList(os));
            dataV.add(v);
        }
    }

    JPanel jp = new JPanel();
    private void init2(){
        JButton jb1 = new JButton("add line");
        JButton jb2 = new JButton("delete line");
        JButton jb3 = new JButton("insert line");
        JButton jb4 = new JButton("add column");
        //DefaultTableModel.addRow（new Object[]），在末尾加行
        jb1.addActionListener(e-> dtm.addRow(new Vector<>()));
        jb2.addActionListener(e->{
            int selectedRow = jt.getSelectedRow();
            //remove（int），删行
            dtm.removeRow(selectedRow);
        });
        jb3.addActionListener(e->{
            int selectedRow = jt.getSelectedRow();
            //insertRow（int，new Object[]），在某位置插入行
            dtm.insertRow(selectedRow,new Vector<>());
        });
        //addColumn（new Object[]），加列
        jb4.addActionListener(e-> dtm.addColumn(new Vector<>()));
        jp.add(jb1);
        jp.add(jb2);
        jp.add(jb3);
        jp.add(jb4);
    }

    private void initialize(){

        init1();
        init2();

        jf.add(new JScrollPane(jt));
        jf.add(jp, BorderLayout.SOUTH);

        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new Test3().initialize();
    }

}


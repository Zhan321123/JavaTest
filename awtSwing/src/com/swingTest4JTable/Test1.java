package com.swingTest4JTable;

import javax.swing.*;
import javax.swing.table.TableColumn;

/**
 * JTable表格类的测试
 */
public class Test1 {
    JFrame jf = new JFrame("d");

    //新建一维数组作为表格的标题
    String[] titles = {"name","age","sex"};
    //新建二维数组作为表格的数据
    Object[][] data = new Object[][]{
            {"zhan",19,"female"},
            {"wei",20,"female"},
            {"jin",21,"male"},
            {"lin",22,"male"},
            {"xin",20,"female"},
    };

    private void initialize(){

        //new JTable（data 一维数组，title 二维数组）
        JTable jt = new JTable(data,titles);

        //JTable.setSelectionMode（int 模式），修改表格选择模式
        jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //getColumn（title），获取标题的一列,返回TableColumn
        TableColumn c1 = jt.getColumn(titles[0]);
        TableColumn c3 = jt.getColumn(titles[2]);

        //TableColumn.setMaxWidth（int），setMinWidth（int），设置表格列最大最小宽度
        c1.setMaxWidth(60);
        c3.setMinWidth(30);

        jf.add(new JScrollPane(jt));

        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new Test1().initialize();
    }
}

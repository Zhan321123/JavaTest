package com.swingTest4JTable;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

/**
 * 自定义类继承AbstractTableModel并设置给JTable
 * 实现表格的方法重构
 */
public class Test2 {
    JFrame jf = new JFrame("s");

    String[] title = new String[]{"name", "job", "address", "hobby"};
    Object[][] data = new Object[][]{
            {"Tom", "fuck", "American", "fuck"},
            {"Steve", "shit", "Japan", "fuck"},
            {"Lucy", "fuck", "Canada", "fart"},
            {"Zhan", "eat", "China", "read"},
            {"Tim", "fuck", "Russian", "sleep"},
    };

    /**
     * 自定义类myModel继承AbstractTableModel
     * 在new JTable（new myModel（）），重构表格方法
     */
    private class myModel extends AbstractTableModel {

        //获取行数
        @Override
        public int getRowCount() {
            return data.length;
        }

        //获取列数
        @Override
        public int getColumnCount() {
            return title.length;
        }

        //获取每个单元格的数据
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }

        //获取标题的Object
        @Override
        public String getColumnName(int column) {
            return title[column];
        }

        //设置每个单元格是否可编辑
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }
    }

    JButton jb = new JButton("read");

    private void initialize() {

        //new JTable（new AbstractTableMode），按照类的方法建立表格
        JTable jt = new JTable(new myModel());

        jb.addActionListener(e -> {
            //JTable.getSelectedRow（），getSelectedColumn（）获取选择的行数与列数
            int selectedRow = jt.getSelectedRow();
            int selectedColumn = jt.getSelectedColumn();
            System.out.println("row" + selectedRow);
            System.out.println("column:" + selectedColumn);
            //JTable.getValueAt（int row，int column），获取表格数据中的数据，不包括标题
            System.out.println(jt.getValueAt(selectedRow, selectedColumn));
        });

        jf.add(jb, BorderLayout.SOUTH);
        jf.add(new JScrollPane(jt));


        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new Test2().initialize();
    }
}

package com.swingTest2;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * 利用DefaultListModel列表模型构建JList
 * 可以实现JList选项的变化
 */
public class Test7 {
    JFrame jf = new JFrame("Library");

    JList<String> jl = new JList<>();
    DefaultListModel<String> dlm = new DefaultListModel<>();//new DefaultListModel<>()

    JTextField jtf = new JTextField(20);
    JButton jb1 = new JButton("add mod");
    JButton jb2 = new JButton("delete mod");

    private void initialize(){
        //在DefaultListModel.addElement（E），添加元素，后续设置到JList中
        dlm.addElement("Advent of Ascension");
        dlm.addElement("The Twilight forest");
        dlm.addElement("Just Enough Items");
        dlm.addElement("Ice and Fire");
        dlm.addElement("Vein Miner");
        //JList.setModel（DefaultListModel），将DefaultListModel模型中的元素设置JList的选项
        jl.setModel(dlm);

        jb1.addActionListener(e->{
            boolean b = true;
            for (int i = 0; i < dlm.getSize(); i++) {
                //DefaultListModel.get（int），获取模型第i个元素
                if (jtf.getText().equals(dlm.get(i))){
                    b = false;
                    break;
                }
            }
            if (!jtf.getText().equals("") && b) {
                dlm.addElement(jtf.getText());
                jtf.setText("");
                jl.setModel(dlm);
            }
        });

        jb2.addActionListener(e->{
            List<String> list = jl.getSelectedValuesList();
            if (list.size()==0){
                //DefaultListModel.removeElement（E），删除元素
                dlm.removeElement(jtf.getText());
            }
            for (String s:list){
                dlm.removeElement(s);
            }
            jl.setModel(dlm);
        });



        jf.add(new JScrollPane(jl));
        JPanel jp = new JPanel();
        jp.add(jtf);
        jp.add(jb1);
        jp.add(jb2);
        jf.add(jp, BorderLayout.SOUTH);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new Test7().initialize();
    }
}

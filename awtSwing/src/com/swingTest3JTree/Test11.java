package com.swingTest3JTree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

/**
 * 默认树单元渲染器DefaultTreeCellRenderer太过单一
 * 例如只能修改叶子节点图标，不能指定节点修改
 * 继承该类实现复杂的图标样式
 */
public class Test11 {
    JFrame jf = new JFrame("t");

    /**
     * 自定义类放入JTree中
     * 自定义类比String有更丰富的内容
     */
    static class myNode {
        String name;
        int type;

        public myNode(String name, int type) {
            this.name = name;
            this.type = type;
        }
    }

    DefaultMutableTreeNode d1 = new DefaultMutableTreeNode(new myNode("what", 0));
    DefaultMutableTreeNode d2 = new DefaultMutableTreeNode(new myNode("fuck", 1));
    DefaultMutableTreeNode d3 = new DefaultMutableTreeNode(new myNode("shit", 1));
    DefaultMutableTreeNode d4 = new DefaultMutableTreeNode(new myNode("dull", 2));
    DefaultMutableTreeNode d5 = new DefaultMutableTreeNode(new myNode("stupid", 2));
    DefaultMutableTreeNode d6 = new DefaultMutableTreeNode(new myNode("silly", 2));
    DefaultMutableTreeNode d7 = new DefaultMutableTreeNode(new myNode("ugly", 2));
    DefaultMutableTreeNode d8 = new DefaultMutableTreeNode(new myNode("greedy", 3));
    JTree jt = new JTree(d1);

    private void ini1(){
        d1.add(d2);
        d1.add(d3);
        d2.add(d4);
        d2.add(d5);
        d2.add(d6);
        d3.add(d7);
        d5.add(d8);
    }

    /**
     * 继承DefaultTreeCellRenderer类
     * 重写getTreeCellRendererComponent方法实现自定义图标绘制
     */
    private static class myRenderer extends DefaultTreeCellRenderer{
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel,
                                                      boolean expanded, boolean leaf, int row, boolean hasFocus) {
            //这里的 Object value 是DefaultMutableTreeNode
            DefaultMutableTreeNode d = (DefaultMutableTreeNode) value;
            myNode myNode = (Test11.myNode) d.getUserObject();

            //setText（String），设置显示出的名称
            this.setText(myNode.name);
            //setIcon（ImageIcon），设置图标
            //这里利用自定义类下的type实现不同类型不同图标
            switch (myNode.type){
                case 0:
                    this.setIcon(new ImageIcon("images\\minecraft\\iron_block.png"));
                    break;
                case 1:
                    this.setIcon(new ImageIcon("images\\minecraft\\gold_block.png"));
                    break;
                case 2:
                    this.setIcon(new ImageIcon("images\\minecraft\\emerald_block.png"));
                    break;
                case 3:
                    this.setIcon(new ImageIcon("images\\minecraft\\diamond_block.png"));
                    break;
            }

            return this;
        }
    }

    private void initialize(){
        ini1();
        //JTree.setCellRenderer（），设置渲染器
        jt.setCellRenderer(new myRenderer());

        jf.add(new JScrollPane(jt));

        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new Test11().initialize();
    }
}

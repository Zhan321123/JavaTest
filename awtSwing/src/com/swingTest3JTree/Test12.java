package com.swingTest3JTree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

/**
 * 继承DefaultTreeCellRenderer修改图标也只能修改图标
 * 实现TreeCellRenderer并继承JPanel可以更加自由地修改JTree样式
 */
public class Test12 {
    JFrame jf = new JFrame("f");

    DefaultMutableTreeNode d1 = new DefaultMutableTreeNode("copper_block.png");
    DefaultMutableTreeNode d2 = new DefaultMutableTreeNode("diamond_block.png");
    DefaultMutableTreeNode d3 = new DefaultMutableTreeNode("emerald_block.png");
    DefaultMutableTreeNode d4 = new DefaultMutableTreeNode("gold_block.png");
    DefaultMutableTreeNode d5 = new DefaultMutableTreeNode("iron_block.png");
    DefaultMutableTreeNode d6 = new DefaultMutableTreeNode("purpur_block.png");
    DefaultMutableTreeNode d7 = new DefaultMutableTreeNode("redstone_block.png");
    DefaultMutableTreeNode d8 = new DefaultMutableTreeNode("structure_block_save.png");
    JTree jt = new JTree(d1);

    private void ini1(){
        d1.add(d2);
        d1.add(d3);
        d2.add(d4);
        d2.add(d5);
        d1.add(d6);
        d3.add(d7);
        d3.add(d8);
    }

    /**
     * 实现TreeCellRenderer可以让JTree修改渲染器
     * 继承JPanel实现绘制
     */
    private static class myRenderer extends JPanel implements TreeCellRenderer{

        String name;
        ImageIcon icon;
        Color c;

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
                                                      boolean expanded, boolean leaf, int row, boolean hasFocus) {
            DefaultMutableTreeNode d = (DefaultMutableTreeNode) value;
            String s = d.toString();
            this.name = s;
            this.icon = new ImageIcon("images\\minecraft\\"+s);
            c = selected?Color.GRAY:Color.white;
            return this;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(140,100);
        }
        Font f = new Font("楷体",Font.PLAIN,14);
        @Override
        public void paint(Graphics g) {
            g.setColor(c);
            g.fillRect(0,0,140,100);
            g.drawImage(icon.getImage(), 27,27,null);
            g.setColor(Color.blue);
            g.setFont(f);
            g.drawString(name,0,70);
        }
    }

    private void initialize(){
        ini1();

        jt.setCellRenderer(new myRenderer());
        jf.add(new JScrollPane(jt));

        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new Test12().initialize();
    }

}

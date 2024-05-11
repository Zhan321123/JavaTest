package com.swingTest2;

import javax.swing.*;
import java.awt.*;

/**
 * 单元渲染器在JList上的使用
 * 可以设置JList每个单元的样式
 */
public class Test8 {
    JFrame jf = new JFrame("QQ friends");
    String[] strings = new String[]{
            "copper_block.png", "diamond_block.png", "emerald_block.png", "structure_block_save.png",
            "gold_block.png","iron_block.png","purpur_block.png","redstone_block.png"};
    JList<String> jl = new JList<>(strings);

    private void initialize() {

        jf.add(new JScrollPane(jl));
        //JList.setCellRenderer（new ListCellRenderer{})
        jl.setCellRenderer(new MyCellRenderer());

        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

    /**
     * 继承JPanel可以绘制图片
     * 实现单元渲染器ListCellRenderer设置给JList
     */
    private class MyCellRenderer extends JPanel implements ListCellRenderer {

        private ImageIcon ii;
        private String name;
        private Color c1;
        private Color c2;

        /**
         * 重写getListCellRendererComponent，组件各个部分的组合方法
         * @param list The JList we're painting.
         * @param value The value returned by list.getModel().getElementAt(index).
         * @param index The cells index.
         * @param isSelected True if the specified cell was selected.
         * @param cellHasFocus True if the specified cell has the focus.
         */
        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {

            this.name = value.toString();
            this.ii = new ImageIcon("images\\minecraft\\"+name);
            //JList.getSelectionBackground，getBackground，getSelectionForeground，getForeground，获取颜色
            this.c1 = isSelected?jl.getSelectionBackground():jl.getBackground();
            this.c2 = isSelected?jl.getSelectionForeground():jl.getForeground();
            return this;
        }

        /**
         * 重写getPreferredSize，可以设置大小，JPanel自己会调用该方法
         */
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(80,80);
        }

        /**
         * 重写paint，JPanel中的方法，实现图片的绘制
         * @param g  the <code>Graphics</code> context in which to paint
         */
        @Override
        public void paint(Graphics g) {
            g.setColor(c1);
            g.fillRect(0,0,80,80);

            g.drawImage(ii.getImage(),32,32,null);

            g.setFont(new Font("黑体",Font.BOLD,15));
            g.setColor(c2);
            g.drawString(this.name,5,60);
        }
    }

    public static void main(String[] args) {
        new Test8().initialize();
    }
}

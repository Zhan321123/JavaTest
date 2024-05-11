package com.swingTest2;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * 列表模型ListModel类的测试
 * 适用于比较复杂的List
 */
public class Test6 {
    JFrame jf = new JFrame("hello");

    JTextField jtf = new JTextField(40);

    /*
    new JList<>（new AbstractListModel（））
    利用列表模型构建列表选项框
     */
    JList<BigDecimal> jl = new JList<>(new Model(new BigDecimal(1), new BigDecimal(2), new BigDecimal(30)));
    /*
    new JComboBox<>（new AbstractListModel（））
    利用列表模型构建下拉选项框
     */
    JComboBox<BigDecimal> jcb = new JComboBox<>(new Number(new BigDecimal("0.2"), new BigDecimal("0.1"), new BigDecimal("2.0")));

    private void initialize() {

        Box b = new Box(BoxLayout.X_AXIS);
        b.add(new JScrollPane(jl));
        JPanel jp = new JPanel();
        jp.add(jcb);
        b.add(jp);

        jf.add(b);

        JPanel jp2 = new JPanel();
        jp2.setBorder(new TitledBorder("Value : "));
        jp2.add(jtf);
        jf.add(jp2, BorderLayout.SOUTH);

        jl.addListSelectionListener(e -> {
            jtf.setText("");
            //JList.getSelectedValuesList（），获取所有选择的选项，返回对象的List<>
            List<BigDecimal> value = jl.getSelectedValuesList();
            for (BigDecimal b1 : value) {
                jtf.setText(jtf.getText() + b1.toString() + ",");
            }
        });

        jcb.addActionListener(e -> {
            Object value = jcb.getSelectedItem();
            if (value != null) {
                jtf.setText(value.toString());
            }
        });

        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.pack();
        jf.setLocationRelativeTo(null);
    }

    public static void main(String[] a) {
        new Test6().initialize();
    }
}

/**
 * 创建类继承抽象列表模型
 * 使用BigBigDecimal精确小数来测试
 * BigDecimal是包装的数据类，亦可自建分数数据类
 */
class Model extends AbstractListModel<BigDecimal> {

    BigDecimal start;
    BigDecimal step;
    BigDecimal end;

    public Model(BigDecimal start, BigDecimal step, BigDecimal end) {
        this.start = start;
        this.step = step;
        this.end = end;
    }

    @Override
    public int getSize() {
        double value = Math.floor(end.subtract(start).divide(step, 2, RoundingMode.HALF_DOWN).doubleValue());
        return (int) ++value;
    }

    @Override
    public BigDecimal getElementAt(int index) {
        return new BigDecimal(index).multiply(step).add(start).setScale(2, RoundingMode.HALF_DOWN);
    }

}

class Number extends Model implements ComboBoxModel<BigDecimal> {

    private int selectedID;

    public Number(BigDecimal start, BigDecimal step, BigDecimal end) {
        super(start, step, end);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem instanceof BigDecimal) {
            BigDecimal curr = (BigDecimal) anItem;
            selectedID = curr.subtract(super.start).divide(super.step, 2, RoundingMode.HALF_DOWN).intValue();
        }
    }

    @Override
    public Object getSelectedItem() {
        return new BigDecimal(selectedID).multiply(super.step).add(super.start).setScale(1, RoundingMode.HALF_DOWN);
    }
}
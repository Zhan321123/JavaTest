package com.IOTest3;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * DataOutputStream数据输出流的测试
 * write各种类型，用于传输数据
 */
public class Test7 {
    public static void main(String[] args) {

        DataOutputStream dos = null;//DataOutputStream数据输出流对象的创建

        try {
            //new DataOutputStream（new FileOutputStream（String 路径））
            dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("D:\\idea-code\\TestT\\wer.txt")));
            /*
            write写入数据的方法有
            writeInt，writeChar等等各种类型
            输出的结果显示在txt上为乱码
            writeUTF为输出String
             */
            dos.writeChar('g');
            dos.writeInt(300);
            dos.writeBoolean(true);
            dos.writeDouble(Math.random());
            dos.writeUTF("我恨你，我要杀了你");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

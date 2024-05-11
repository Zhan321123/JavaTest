package com.IOTest1;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * FileOutputStream文件输出流的测试
 * 用于将FileInputStream读取的输出
 */
public class Test3 {
    public static void main(String[] args) {

        FileOutputStream f = null;//文件输出流对象的创建//FileOutputStream
        FileInputStream fIn = null;
        try {
            fIn = new FileInputStream("D:\\idea-code\\TestT\\sky.jpg");
            f = new FileOutputStream("D:\\idea-code\\TestT\\a.jpg");//文件输出流//FileOutputStream（文件路径）
            int i;
            while ((i=fIn.read()) != -1) {
                f.write(i);//write（字符）或write（int），都是输出字符到文件上
            }
            f.flush();//flush（），写入磁盘
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (fIn != null){
                    fIn.close();
                }
                if (f != null){
                    f.close();//close（），也需要关闭，避免占用太多空间
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

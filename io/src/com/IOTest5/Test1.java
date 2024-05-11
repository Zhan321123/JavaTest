package com.IOTest5;

import java.io.RandomAccessFile;

/**
 * RandomAccessFile随机访问流的测试
 * 不是随机访问，而是光标可动，可读可写
 */
public class Test1 {
    public static void main(String[] args) {

        RandomAccessFile raf = null;//RandomAccessFile对象的创建

        try {
            /*
            new RandomAccessFile（String 文件路径，String 访问与读写）
            ”r“只读不写，”rw"又写又读
             */
            raf = new RandomAccessFile("D:\\idea-code\\TestT\\ooo.txt", "rw");

            for (int i = 1; i <= 10; i++) {
                /*
                也有各种write方法
                 */
                raf.writeInt(i * 10);
            }
            /*
            seek（long）方法
            将光标指向某位置，默认是0
            开头是0，每个字节向后依次递增
             */
            raf.seek(8);
            System.out.println(raf.readInt());

            for (int i = 0; i < 10; i += 2) {
                raf.seek(i * 4L);
                System.out.println(raf.readInt());
            }

            System.out.println("-----------------");

            raf.seek(12);
            raf.writeInt(123);
            raf.seek(0);
            for (int i = 0; i < 10; i++) {
                System.out.println(raf.readInt());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}

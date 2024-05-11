package com.IOTest2;

import java.io.FileReader;

/**
 * FileReader文件读取类的测试
 * 读取也为数字
 */
public class Test1 {
    public static void main(String[] args) {

        FileReader fr = null;//字符输入流对象的创建FileReader

        try {
            fr = new FileReader("D:\\idea-code\\TestT\\asd.txt");//new FileReader（String 路径）
            int temp;
            /**
             * 与FileInputStream一样
             * 但是FileInputStream读取的是字符，返回最大255
             * 适用于以二进制的文件类型
             *
             * FileReader读取的是按照U-8，返回最大为6万多，中文可char强转为相对应的文字
             * 适用于文本的读取
             */
            //read（），文件读取单个字符，没了返回-1
            while((temp=fr.read()) !=-1) {
                System.out.print(temp+"    ");
                System.out.println((char)temp);
            }
            System.out.println("---------------------");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}

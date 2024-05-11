package com.IOTest1;

import java.io.FileInputStream;

/**
 * FileInputStream文件输入流的测试
 * 需要try catch finally
 * 读取为字符的int值
 */
public class Test1 {
    public static void main(String[] args) {

        FileInputStream f = null;//输入流对象的创建

        try {
           f = new FileInputStream("D:\\idea-code\\TestT\\asd.txt");//new FileInputStream("文件路径")
            int read = f.read();//read（），读取文件第一个字符，返回该字符的艾萨克值，int类型
            System.out.println(read);
            System.out.println(f.read());//每次读取下一个字符
            System.out.println(f.read());
            System.out.println(f.read());
            System.out.println(f.read());//读取完了返回-1
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("找不到文件");
        }finally {
            if (f != null){
                try {
                    f.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

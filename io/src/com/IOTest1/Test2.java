package com.IOTest1;

import java.io.FileInputStream;

/**
 * FileInputStream的测试2
 */
public class Test2 {
    public static void main(String[] args) {

        FileInputStream f = null;//文件输入流对象的创建//FileInputStream
        try  {
            f = new FileInputStream("D:\\idea-code\\TestT\\asd.txt");//new FileInputStream（文件路径）
            int i = -1;
            StringBuffer b = new StringBuffer();//可变字符串的创建//StringBuffer
            while((i = f.read()) != -1){//read（），读取文件字符
                System.out.println(i);
                b.append((char) i);
            }
            System.out.println(b);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (f != null){
                    f.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}

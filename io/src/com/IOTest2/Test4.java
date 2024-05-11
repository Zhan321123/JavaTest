package com.IOTest2;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * BufferedReader字符缓冲类的测试
 * 有readLine方法，返回String
 */
public class Test4 {
    public static void main(String[] args) {

        BufferedReader br = null;//BufferedReader对象的创建
        FileReader fr = null;

        try {
            fr = new FileReader("D:\\idea-code\\TestT\\asd.txt");
            br = new BufferedReader(fr);//new BufferedReader（FileReader），字符缓冲流
            /*
            readLine（），
            读取一行内容，返回String
            行数读取完了返回null
            效率高
             */
            for (String s; (s = br.readLine()) != null; ) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}

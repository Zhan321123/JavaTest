package com.IOTest2;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * FileReader和FileWriter在byte[]缓冲的测试
 */
public class Test3 {
    public static void main(String[] args) {

        String src = "D:\\idea-code\\TestT\\asd.txt";
        String des = "D:\\idea-code\\TestT\\FJ.txt";
        copy(src,des);


    }

    static void copy(String src, String des) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(src);
            fw = new FileWriter(des);
            char[] cs = new char[1024];
            /**
             * 如同FileOutputStream一样
             * FileWriter也可以将文件读取到char[]中
             * 实现缓冲流提高速度
             * write（char[],int start,int end）
             */
            for (int temp; (temp = fr.read(cs)) != -1; ) {
                fw.write(cs, 0, temp);
            }
            fw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

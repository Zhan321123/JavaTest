package com.IOTest2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 利用BufferedReader和BufferedWriter复制文本内容
 */
public class Test6 {
    public static void main(String[] args) {

        String src = "D:\\idea-code\\TestT\\asd.txt";
        String des = "D:\\idea-code\\TestT\\eee.txt";

        copyFile(src, des);


    }

    /**
     * 复制文本的方法
     */
    static void copyFile(String src, String des) {
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(src));
            bw = new BufferedWriter(new FileWriter(des));
            String s;
            while ((s = br.readLine()) != null) {
                bw.write(s);
                bw.newLine();
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}

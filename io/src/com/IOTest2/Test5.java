package com.IOTest2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * BufferedWriter字符输出流的测试
 * 一般用于将BufferedRead读取的字符写入
 */
public class Test5 {
    public static void main(String[] args) {

        BufferedReader br = null;
        BufferedWriter bw = null;//BufferedWriter字符输出流对象的创建
        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader("D:\\idea-code\\TestT\\asd.txt");
            fw = new FileWriter("D:\\idea-code\\TestT\\qwe.txt");
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);//new BufferedWriter（FileWriter），字符输出流
            String s;
            while ((s = br.readLine()) != null) {
                /*
                字符输出流writer（String）
                写入String
                newLine（），换行输入
                相当于writer（"\r\n");
                 */
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

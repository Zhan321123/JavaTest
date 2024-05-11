package com.IOTest2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 利用BufferedReader和BufferedWriter将文本内容每行的开头加上数字
 */
public class Test7 {
    public static void main(String[] args) {
        String src = "D:\\idea-code\\TestT\\asd.txt";
        String des = "D:\\idea-code\\TestT\\eee.txt";

        TargetLine(src, des);

    }

    static void TargetLine(String path, String des) {
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {
            bw = new BufferedWriter(new FileWriter(des));
            br = new BufferedReader(new FileReader(path));
            String s;
            for (int i = 1; (s = br.readLine()) != null; i++) {
                bw.write(i + "  ");
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

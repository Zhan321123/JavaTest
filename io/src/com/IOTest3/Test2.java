package com.IOTest3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 字节与字符的一个小项目
 */
public class Test2 {
    public static void main(String[] args) {
        BufferedWriter bw = null;
        BufferedReader br = null;

        try {

            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));

            /**
             * 键盘输入项目
             * 输入一句打印一句
             * 直到输入I love you则结束
             */
            while (true) {
                String s = br.readLine();
                bw.write(s);
                bw.newLine();
                bw.flush();
                if (s.equals("I love you")) {
                    break;
                }
            }

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

package com.IOTest3;

import java.io.*;

/**
 * PrintWriter类的测试
 * 适用于输出到控制台System.out就是PrintWriter
 */
public class Test4 {
    public static void main(String[] args) {

        BufferedReader br = null;
        PrintWriter pr = null;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\idea-code\\TestT\\asd.txt")));
            pr = new PrintWriter("D:\\idea-code\\TestT\\eee.txt");

            String s;
            int i = 1;
            while ((s = br.readLine()) != null) {
                /*
                println（String），将字符串输出
                 */
                pr.println(i + "   " + s);
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (pr != null) {
                    pr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}

package com.IOTest3;

import java.io.*;

/**
 * 字节流与字符流的转化
 * 中间管道为OutputStreamWriter和InputStreamReader
 */
public class Test3 {
    public static void main(String[] args) {

        BufferedWriter bw = null;
        BufferedReader br = null;

        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\idea-code\\TestT\\edc.txt")));
            br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\idea-code\\TestT\\asd.txt")));

            /**
             * 小项目
             * 在文本每行前加上行数
             */
            String s;
            for (int i=1;(s=br.readLine())!=null;i++){
                bw.write(i+"  "+s);
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
                if (br !=null){
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}

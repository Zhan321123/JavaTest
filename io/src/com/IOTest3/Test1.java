package com.IOTest3;

import java.io.*;

/**
 * System.in的使用
 * InputStream类的使用
 * 字符缓冲流与字节缓冲流的转换
 */
public class Test1 {
    public static void main(String[] args) {

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            /*
            InputStream对象的创建
             System.in就是System类下的InputStream
            */
            InputStream is = System.in;
            int put = is.read();//InputStream的方法read（），返回字符对应的int，读完了返回-1
            System.out.println((char) put);

            //new BufferedReader（new InputStreamReader（System.in））
            br = new BufferedReader(new InputStreamReader(System.in));
            String s1 = br.readLine();
            System.out.println(s1);

            //new BufferedWriter（new OutputStreamWriter（System.out））
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(s1);
            bw.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

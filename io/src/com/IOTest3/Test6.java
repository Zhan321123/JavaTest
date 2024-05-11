package com.IOTest3;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

/**
 * ByteArrayOutputStream字节数组输出流的测试
 */
public class Test6 {
    public static void main(String[] args) {

        ByteArrayOutputStream bos = null;//字节数组输出流对象的创建
        PrintWriter pw = null;
        StringBuilder sb = new StringBuilder();

        try {
            bos = new ByteArrayOutputStream();//new ByteArrayOutputStream（）
            pw = new PrintWriter(System.out);
            /*
            write（内容），将字符写到byte[]中
            最终能通过toByteArray（）方法将数组提取出来
             */
            bos.write('a');
            bos.write('b');
            bos.write('c');
            byte[] bs = bos.toByteArray();
            for (byte b : bs) {
                pw.println(b);
                sb.append((char) b);
            }
            pw.println(sb);
            pw.flush();

        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                if (pw != null) {
                    pw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}

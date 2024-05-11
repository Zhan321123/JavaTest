package com.IOTest3;

import java.io.ByteArrayInputStream;

/**
 * ByteArrayInputStream字节组与字节流的转换
 */
public class Test5 {
    public static void main(String[] args) {
        //String.getBytes（），将字符串的每个字符放到一个字符组里
        byte[] bs = "fuckyou".getBytes();
        ByteArrayInputStream bis = null;//ByteArrayInputStream对象的创建
        StringBuffer sb = new StringBuffer();

        try {
            bis = new ByteArrayInputStream(bs);//new ByteArrayInputStream（byte[]），字节数组流

            int i = 0;
            //read（），按照数组顺序读取元素，返回字节组中的元素，没有了则返回-1
            while ((i = bis.read()) != -1) {
                sb.append((char) i);
            }
            System.out.println(sb.toString());
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}

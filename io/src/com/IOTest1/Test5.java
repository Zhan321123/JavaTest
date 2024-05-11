package com.IOTest1;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 运用FileInputStream.available(),算出文件字节的大小
 * 直接将byte[]的大小定义为此，实现快速文件读写
 * 适合用于小文件，大文件byte[]会太大，占用内存资源
 */
public class Test5 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try{
            fos = new FileOutputStream("D:\\idea-code\\TestT\\a.jpg");
            fis = new FileInputStream("D:\\idea-code\\TestT\\sky.jpg");
            byte[] b = new byte[fis.available()];//available（），读取文件字节大小，返回int
            System.out.println(b.length);
            fos.write(b);
            fos.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (fos != null){
                    fos.close();
                }
                if (fis != null){
                    fis.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

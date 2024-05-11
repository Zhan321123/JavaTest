package com.IOTest1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * BufferedInputStream和BufferedOutputStream
 * 文件输入输出缓冲流对象的测试
 * 要try catch finally
 * 用于缓冲，相当于缓冲管道
 */
public class Test6 {
    public static void main(String[] args) {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;//BufferedInputStream对象的创建
        BufferedOutputStream bos = null;//BufferedOutputStream对象的创建

        try {
            fis = new FileInputStream("D:\\idea-code\\TestT\\sky.jpg");
            fos = new FileOutputStream("D:\\idea-code\\TestT\\fuck.jpg");
            bis = new BufferedInputStream(fis);//new BufferedInputStream（FileInputStream），创建输入缓冲流对象
            bos = new BufferedOutputStream(fos);//new BufferedOutputStream（FileOutputStream），创建输出缓冲流对象

            int temp;
            //输入输出缓冲流
            //read（），方法读取文件
            while ((temp = bis.read()) != -1) {
                bos.write(temp);//write（int），写入文件，可以不用字节组，速度也很快
            }
            //BufferedOutputStream.write（int）方法中的字节组大小为2^13

            bos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭时遵循后开先关的原则
                if (bos != null) {
                    bos.close();
                }
                if (bis != null) {
                    bis.close();
                }
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}

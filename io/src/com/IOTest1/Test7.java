package com.IOTest1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 用BufferedInputStream和BufferedOutputStream和FileInputStream和FileOutputStream
 * 完成的文件复制方法
 */
public class Test7 {
    public static void main(String[] args) {

        String src = "D:\\idea-code\\TestT\\sky.jpg";
        String des = "D:\\idea-code\\TestT\\ff.jpg";
        copy(src,des);


    }

    /**
     * 定义文件复制方法
     * @param startPath
     * @param endPath
     */
    static void copy(String startPath, String endPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;

        try {
            fis = new FileInputStream(startPath);
            fos = new FileOutputStream(endPath);
            bos = new BufferedOutputStream(fos);
            bis = new BufferedInputStream(fis);

            for (int temp;(temp = bis.read())!=-1;){
                bos.write(temp);
            }
            bos.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                if (bis != null) {
                    bis.close();
                }
                if (fos != null) {
                    fos.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

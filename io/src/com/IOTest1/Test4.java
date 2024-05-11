package com.IOTest1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileInputStream和FileOutputStream的测试
 * 运用字节缓冲对文件进行复制
 */
public class Test4 {
    public static void main(String[] args) {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("D:\\idea-code\\TestT\\sky.jpg");
            fos = new FileOutputStream("D:\\idea-code\\TestT\\s.jpg");
            byte[] b = new byte[1024];//定义字节组，大小要2的n次方为好
            int temp;
            //read（byte【】），读取文件到byte组中，byte【】没装满返回-1
            while((temp = fis.read(b)) != -1){
                //write（byte[],int start,int last），将byte【】中的从start到last的字符写入文件
                //write（byte【】），将byte【】中的字符写入文件
                fos.write(b,0,temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if (fis != null){
                    fis.close();
                }
                if (fos != null){
                    fos.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}

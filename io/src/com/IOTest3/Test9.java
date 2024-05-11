package com.IOTest3;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * ObjectOutputStream对象输出流的测试
 * 用于输出对象，writeObject
 */
public class Test9 {
    public static void main(String[] args) {

        ObjectOutputStream oos = null;//ObjectOutputStream对象的创建

        try{
            //new ObjectOutputStream（FileOutputStream（String 路径））
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("D:\\idea-code\\TestT\\yyy.txt")));
            /*
            也有各种write方法，写出来的同样是数据不是文本
             */
            oos.writeByte(3);
            oos.writeBoolean(false);
            oos.writeChar('V');
            oos.writeDouble(Math.E);
            oos.writeUTF("我恨死你了");
            oos.flush();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (oos!=null){
                    oos.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}

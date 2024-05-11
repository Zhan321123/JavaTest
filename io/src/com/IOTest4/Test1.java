package com.IOTest4;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * 使用ObjectOutputStream传输对象
 */
public class Test1 {
    public static void main(String[] args) {

        ObjectOutputStream oos = null;

        try{
            oos = new ObjectOutputStream(new FileOutputStream("D:\\idea-code\\TestT\\qwe.txt"));
            User user = new User(18,"liu GaoZhan",10001);
            /*
            直接使用writeObject（对象）输出
            输出结果该对象的信息
            将对象进行序列化
             */
            oos.writeObject(user);
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

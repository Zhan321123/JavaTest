package com.IOTest2;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * FileWriter文件写入类的测试
 * 用于将FileReader读取的写入
 */
public class Test2 {
    public static void main(String[] args) {

        FileReader fr = null;
        FileWriter fw = null;//FileWriter文件写入对象的创建

        FileWriter fw2 = null;

        try{
            fr = new FileReader("D:\\idea-code\\TestT\\asd.txt");
            String s = "D:\\idea-code\\TestT\\qqq.txt";
            fw = new FileWriter(s);//new FileWriter（String 路径）
            int temp ;
            while((temp = fr.read())!=-1){
                /**
                 * writer（int或字符）
                 * FileWriter与FileOutputStream的区别与FileReader与FileInputStream的区别类似
                 *
                 */
                fw.write(temp);
            }
            fw.write("\nFUCK YOU\n");
            fw.flush();//也要flush（），也要写入磁盘
            inorder(s);
            /**
             * new FileWriter（String 路径，boolean）
             * 为true时，不会覆盖文本
             * 为false时，会覆盖文本
             * 没有boolean时，默认会覆盖文本
             *
             */
            fw2 = new FileWriter(s,true);
            fw2.write("I Fuck you!\nI will grow you with a pot of shit");
            fw2.flush();
            inorder(s);

            fw2 = new FileWriter(s,false);
            fw2.write("I Fuck you!\nI will grow you with a pot of shit");
            fw2.flush();
            inorder(s);


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (fw !=null){
                    fw.close();
                }
                if (fr !=null){
                    fr.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }



    }

    /**
     * 遍历文件内容
     */
    static void inorder(String path){
        FileReader fr =null;
        try{
            fr = new FileReader(path);
            int temp;
            while((temp=fr.read())!=-1){
                System.out.print((char) temp);
            }
            System.out.println("\n----------------------");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (fr!=null){
                    fr.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

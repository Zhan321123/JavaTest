package com.test1Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 连接MySQL数据库操作
 * 在表中添加一行数据的操作
 */
public class Test1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //启动程序，在jar包里找到该类
        String driver = "com.mysql.cj.jdbc.Driver";
        Class.forName(driver);

        //连接数据库
        //DriverManager.getConnection（URL，String 用户名，String 密码），返回Connection连接
        //URL：jdbc:mysql:// + 地址：端口号/数据库名称 + 其他
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String user = "root";
        String password = "987654321asd";
        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println(connection);

        //获取向数据库发送指令的声明，Connection.createStatement（），返回声明Statement
        Statement statement = connection.createStatement();

        //发送指令
        //直接Statement.executeUpdate（String 指令），返回int，数据右变化的行数
        String sql1 = "insert into stus values(1212,'pp','f',null,'1999-9-9',1000,0,8)";
        int i = statement.executeUpdate(sql1);
        System.out.println(i);

        //关闭资源
        statement.close();
        connection.close();

    }
}

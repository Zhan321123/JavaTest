package com.test1Jdbc;

import java.sql.*;

/**
 * jdbc查询数据库的操作
 */
public class Test3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String driver="com.mysql.cj.jdbc.Driver";
        Class.forName(driver);

        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String user = "root";
        String password = "987654321asd";
        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();

        String sql = "Select * from study";
        //state.executeQuery（String select），返回ResultSet结果集合
        //不用手动关闭ResultSet资源，因为在关闭Statement时会关闭ResultSet
        ResultSet resultSet = statement.executeQuery(sql);
        //初始指针指向第0行数据
        //ResultSet.next（）后指向下一行数据，返回boolean下一行是否有数据
        while(resultSet.next()){
            //ResultSet.getDate、getString、getInt（列头名），返回指向行的对应列的数据
            //不用按顺序
            System.out.print(resultSet.getString("presentation")+"\t\t");
            System.out.print(resultSet.getDate("hiredate")+"\t\t");
            System.out.print(resultSet.getString("name")+"\t\t");
            System.out.println(resultSet.getInt("number"));
        }


    }
}

package com.test1Jdbc;

import java.sql.*;

/**
 * 像获取类信息一样获取数据库表的表信息
 */
public class Test8 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String driver="com.mysql.cj.jdbc.Driver";
        Class.forName(driver);

        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String user = "root";
        String password = "987654321asd";
        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();

        String sql = "Select * from stus";
        ResultSet resultSet = statement.executeQuery(sql);
        //ResultSet.getMetaData（），返回表信息ResultMetaData
        ResultSetMetaData metaData = resultSet.getMetaData();
        //ResultSetMetaData.getColumnCount（），返回列数
        //getColumnName（int），返回第int列的列头名
        //getColumnTypeName（int），返回第int列数据库数据类型名称
        //getColumnClassName（int），返回第int列数据库数据类型对应Java的数据类型名称
        System.out.println(metaData.getColumnCount());
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            System.out.println(metaData.getColumnName(i)+"  "
                    +metaData.getColumnTypeName(i)+"  "
                    + metaData.getColumnClassName(i));
        }
    }
}

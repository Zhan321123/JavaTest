package com.test1Jdbc;

import java.sql.*;

/**
 * 数据库安全问题“转账时异常”的解决
 * 内存资源的管理
 */
public class Test9 {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            String url = "jdbc:mysql://127.0.0.1:3306/test";
            String user = "root";
            String password = "987654321asd";
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

            //Connection.setAutoCommit（boolean）设置连接是否自动提交，默认是
            connection.setAutoCommit(false);

            String sql = "update money set money=money-1000 where name='lin'";
            statement.execute(sql);
//            int error = 1 / 0;
            sql = "update money set money=money+1000 where name='jin'";
            statement.execute(sql);

            //Connect.commit（），提交任务
            connection.commit();

        } catch (Exception e) {
            if (connection != null) {
                try {
                    //Connection.rollback（），事务回滚，事务取消
                    connection.rollback();
                } catch (SQLException ex) {
                    e.printStackTrace();
                }
            }
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}

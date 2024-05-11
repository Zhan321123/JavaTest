package com.test2Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * 连接池，一个放Connection的池子
 * 在大项目中可以节约时间
 */
public class ConnectionPool {
    LinkedList<Connection> list = new LinkedList<>();
    int size;

    public ConnectionPool(){
        init();
    }

    public ConnectionPool(int size){
        this.size = size;
        init();
    }

    private void init(){
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String user = "root";
        String password = "987654321asd";
        Connection connection = null;
        for (int i = 0; i < size; i++) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            list.add(connection);
        }
    }

    public synchronized Connection getConn(){
        if (list.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return list.removeFirst();
    }

    public synchronized void closeConn(Connection conn){
        list.addLast(conn);
        this.notify();
    }

    public static void main(String[] args) {
        ConnectionPool connectionPool = new ConnectionPool(30);
        for (int i = 0; i < 50; i++) {
            new Thread(()->{

                Connection conn = connectionPool.getConn();
                try {
                    conn.createStatement().execute("select * from stus");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println("ok");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                connectionPool.closeConn(conn);
            }).start();
        }
    }
}

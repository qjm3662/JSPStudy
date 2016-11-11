package com.qjm3662.entity.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by qjm3662 on 2016/11/11 0011.
 */
public class TransactionTest {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);//禁止事务的自动提交
            insertUserDate(conn);
            insertAddressDate(conn);
        } catch (SQLException e) {
            System.out.println("=========捕获到SQLExcrption===========");
            e.printStackTrace();
            try {
                conn.rollback();
                System.out.println("================事务回滚成功================");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void insertUserDate(Connection conn) throws SQLException {
        String sql = "INSERT INTO tbl_user(id, name, password, email)" +
                "VALUES(10, 'Tom', '123456', 'tom@gmail.com')";
        Statement statement = conn.createStatement();
        int count = statement.executeUpdate(sql);
        System.out.println("向用户表中插入了" + count + "条记录");
        conn.close();
    }

    public static void insertAddressDate(Connection conn) throws SQLException {
        String sql = "INSERT INTO tbl_user(id, city, country, user_id)" +
                "VALUES(1, 'Shanghai', 'China', '10')";
        Statement statement = conn.createStatement();
        int count = statement.executeUpdate(sql);
        System.out.println("向地址表中插入了" + count + "条记录");
        conn.close();
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db", "root", "123456");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return conn;
    }
}

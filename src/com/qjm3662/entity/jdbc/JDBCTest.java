package com.qjm3662.entity.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by qjm3662 on 2016/11/11 0011.
 */
public class JDBCTest {
    public static void main(String[] args) {
        insert();
        update();
//        delete();
    }

    public static void delete(){
        Connection conn = getConnection();
        try {
            String sql = "DELETE FROM tbl_user WHERE name = 'Tom'";
            Statement statement = conn.createStatement();
            int count = statement.executeUpdate(sql);
            System.out.println("向用户表中删除了" + count + "条记录");
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

        public static void insert(){
            Connection conn = getConnection();
            try {
                String sql = "INSERT INTO tbl_user(name, password, email)" +
                        "VALUES('Tom', '123456', 'tom@gmail.com')";
                Statement statement = conn.createStatement();
                int count = statement.executeUpdate(sql);
                System.out.println("向用户表中插入了" + count + "条记录");
                conn.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    public static void update(){
        Connection conn = getConnection();
        try {
            String sql = "UPDATE tbl_user SET email = 'tom@126.com' WHERE name = 'Tom'";
            Statement statement = conn.createStatement();
            int count = statement.executeUpdate(sql);
            System.out.println("向用户表中更新了" + count + "条记录");
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }


    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db", "root", "123456");

        } catch (Exception e) {
            // TODO: handle exception
        }
        return conn;
    }
}

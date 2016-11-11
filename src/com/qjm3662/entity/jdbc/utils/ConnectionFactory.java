package com.qjm3662.entity.jdbc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by qjm3662 on 2016/11/11 0011.
 */
public class ConnectionFactory {
    private static String driver;
    private static String dburl;
    private static String user;
    private static String password;
    private static ConnectionFactory factory = new ConnectionFactory();
    private Connection conn = null;

    //用java的静态代码块从属性文件中读取相关配置信息
    //静态代码块可以用于初始化类（在加载类的时候执行，所以静态代码块只会执行一次），可以为类的属性进行赋值
    static {
        Properties prop = new Properties();
        try {
            InputStream in = ConnectionFactory.class.getClassLoader()
                    .getResourceAsStream("dbconfig.properties");
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = prop.getProperty("driver");
        dburl = prop.getProperty("dburl");
        user = prop.getProperty("user");
        password = prop.getProperty("password");
    }

    private ConnectionFactory(){

    }

    public static ConnectionFactory getInstance(){
        return factory;
    }

    public Connection makeConnection(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(dburl, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

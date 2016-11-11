package com.qjm3662.entity.jdbc.Test;

import com.qjm3662.entity.jdbc.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by qjm3662 on 2016/11/11 0011.
 */
public class ConnectionFacoryTest {
    public static void main(String[] args) {
        ConnectionFactory cf = ConnectionFactory.getInstance();
        Connection connection = cf.makeConnection();
        try {
            System.out.println(connection.getAutoCommit());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package com.qjm3662.entity.jdbc.dao;

import com.qjm3662.entity.jdbc.Entity.User;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by qjm3662 on 2016/11/11 0011.
 */
public interface UserDao {
    public void save(Connection connection, User user) throws SQLException;
    public void update(Connection connection, Long id, User user) throws SQLException;
    public void delete(Connection connection, User user) throws SQLException;
}

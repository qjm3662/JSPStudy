package com.qjm3662.entity.jdbc.dao.mpl;

import com.qjm3662.entity.jdbc.Entity.User;
import com.qjm3662.entity.jdbc.dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by qjm3662 on 2016/11/11 0011.
 */
public class UserDaompl implements UserDao{

    /**
     * 插入用户信息
     * @param connection
     * @param user
     * @throws SQLException
     */
    @Override
    public void save(Connection connection, User user) throws SQLException {
        PreparedStatement ps = connection.prepareCall("INSERT INTO tbl_user(name, password, email) VALUES (?,?,?)");
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.execute();
    }

    /**
     * 更新用户信息
     * @param connection
     * @param id
     * @param user
     * @throws SQLException
     */
    @Override
    public void update(Connection connection, Long id, User user) throws SQLException {
        String updateSql = "UPDATE tbl_user SET name = ?, password = ?, email = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareCall(updateSql);
        //注意下标是从1开始的
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.setLong(4, user.getId());
        ps.execute();
    }

    /**
     * 删除用户信息
     * @param connection
     * @param user
     * @throws SQLException
     */
    @Override
    public void delete(Connection connection, User user) throws SQLException {
        String deleteSql = "DELETE FROM tbl_user WHERE id = ?";
        PreparedStatement ps = connection.prepareCall(deleteSql);
        ps.setLong(1, user.getId());
        ps.execute();
    }
}

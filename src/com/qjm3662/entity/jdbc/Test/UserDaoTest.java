package com.qjm3662.entity.jdbc.Test;

import com.qjm3662.entity.jdbc.Entity.User;
import com.qjm3662.entity.jdbc.dao.UserDao;
import com.qjm3662.entity.jdbc.dao.mpl.UserDaompl;
import com.qjm3662.entity.jdbc.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by qjm3662 on 2016/11/11 0011.
 */
public class UserDaoTest {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            //关闭自动commit
            conn.setAutoCommit(false);
            UserDao userDao = new UserDaompl();
            User tom = new User();
            tom.setName("tomm");
            tom.setPassword("12456");
            tom.setEmail("tom@gmail.com");
            userDao.save(conn, tom);
            conn.commit();
        } catch (SQLException e) {
            try {
                //如果发生错误，增加事务回滚
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }
}

package com.qjm3662.entity.jdbc.Entity;

/**
 *
 * Created by qjm3662 on 2016/11/11 0011.
 */

//所有实体类的父类(所有的数据表都会包含一个作为主键的id)
public abstract class IdEntity {
    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

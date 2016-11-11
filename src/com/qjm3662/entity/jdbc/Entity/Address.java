package com.qjm3662.entity.jdbc.Entity;

/**
 * Created by qjm3662 on 2016/11/11 0011.
 */
public class Address extends IdEntity {
    private String city;
    private String country;
    private long user_id;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", user_id=" + user_id +
                ", id='" + id + '\'' +
                '}';
    }
}

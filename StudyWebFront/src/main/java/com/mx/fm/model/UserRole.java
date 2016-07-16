package com.mx.fm.model;

/**
 * Created by Administrator on 2016-07-13.
 */
public class UserRole {

    private int id;
    private String name;
    private int roleid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roleid=" + roleid +
                '}';
    }
}

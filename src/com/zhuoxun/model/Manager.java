package com.zhuoxun.model;

import java.io.Serializable;

public class Manager implements Serializable {

    private int manager_id;
    private String username;
    private String password;
    private String mobile;
    private String email;
    private String note;
    private int status; // 0 表示正常，-1 表示锁定

    public int getManager_id() {
        return manager_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getNote() {
        return note;
    }

    public int getStatus() {
        return status;
    }
}

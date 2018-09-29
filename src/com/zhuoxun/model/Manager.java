package com.zhuoxun.model;

import java.io.Serializable;

public class Manager implements Serializable {

    private Integer manager_id;
    private String username;
    private String password;
    private String mobile;
    private String email;
    private String note;
    private Integer status; // 0 表示正常，-1 表示锁定

    @Override
    public String toString() {
        return "---\n[Obj] Manager \nid: " + manager_id + "\nusername: " + username + "\n---";
    }

    /*** Setters and getters ***/

    public Integer getManager_id() {
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

    public Integer getStatus() {
        return status;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

package com.klay.entity;

import lombok.Data;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/18 15:17
 **/
@Data
public class Admin {
    private long id;

    private String username;

    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

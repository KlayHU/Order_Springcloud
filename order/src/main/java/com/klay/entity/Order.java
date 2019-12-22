package com.klay.entity;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/18 22:47
 **/
@Data
public class Order {
    private long id;

    private User user;

    private Menu menu;      //mid映射成menu

    private Admin admin;

    private Date date;

    private int state;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}

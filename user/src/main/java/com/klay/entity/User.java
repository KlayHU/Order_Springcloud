package com.klay.entity;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/17 14:35
 **/
@Data
public class User {

    private long id;

    private String username;

    private String password;

    private String nickname;

    private String gender;

    private String telephone;

    private Date registerdate;

    private String address;
}

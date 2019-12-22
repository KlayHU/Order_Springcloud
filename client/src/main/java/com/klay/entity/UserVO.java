package com.klay.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/18 10:02
 **/
@Data
public class UserVO {
    private int code;
    private String msg;
    private int count;
    private List<User> data;
}

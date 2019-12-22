package com.klay.entity;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/15 1:43
 **/
@Data
public class MenuVO {

    private int code;

    private String msg;

    private int count;

    private List<Menu> data;

}

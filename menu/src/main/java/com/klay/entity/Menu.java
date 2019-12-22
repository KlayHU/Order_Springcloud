package com.klay.entity;

import lombok.Data;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/13 11:52
 **/
@Data
public class Menu {

    private long id;

    private String name;

    private double price;

    private String flavor;

    private Type type;

}

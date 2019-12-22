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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}

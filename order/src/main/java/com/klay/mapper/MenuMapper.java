package com.klay.mapper;

import com.klay.entity.Menu;

import java.util.List;

/**
 * @description: Menu增删改查
 * @author: KlayHu
 * @create: 2019/12/13 11:55
 **/
public interface MenuMapper {
    //分页查询
    public List<Menu> findAll(int index, int limit);

}

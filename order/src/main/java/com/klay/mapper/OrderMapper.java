package com.klay.mapper;

import com.klay.entity.Order;

import java.util.List;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/18 22:50
 **/
public interface OrderMapper {
    public void save(Order order);

    public List<Order> findByUid(int index,int limit,int uid);

    public int countByUid(long uid);

    public List<Order> findAll(int index,int limit);

    public void updateState(long id);

    public int count();
}

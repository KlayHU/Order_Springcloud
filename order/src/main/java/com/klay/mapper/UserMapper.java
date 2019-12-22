package com.klay.mapper;

import com.klay.entity.User;

import java.util.List;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/17 14:39
 **/
public interface UserMapper {

    public User findById(long id);

}

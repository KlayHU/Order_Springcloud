package com.klay.mapper;

import com.klay.entity.User;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/18 15:21
 **/
public interface UserMapper {

    public User login(String username , String password);

}

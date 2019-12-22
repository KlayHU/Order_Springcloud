package com.klay.mapper;

import com.klay.entity.Admin;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/18 15:21
 **/
public interface AdminMapper {

    public Admin login(String username,String password);

}

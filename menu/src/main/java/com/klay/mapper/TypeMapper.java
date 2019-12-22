package com.klay.mapper;

import com.klay.entity.Type;

import java.util.List;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/16 11:05
 **/
public interface TypeMapper {
    public Type findById(long id);

    public List<Type> findAll();

}

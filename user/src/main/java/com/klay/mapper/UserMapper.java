package com.klay.mapper;

import com.klay.entity.User;
import com.klay.entity.UserVO;

import java.util.List;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/17 14:39
 **/
public interface UserMapper {

    public List<User> findAll(int index, int limit);

    public User findById(long id);

    public  int count();

    public void save(User user);

    public void update(User user);

    public void deleteById(long id);
}

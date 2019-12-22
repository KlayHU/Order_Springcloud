package com.klay.controller;

import com.klay.entity.User;
import com.klay.entity.UserVO;
import com.klay.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/17 14:26
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/findAll/{index}/{limit}")
    public UserVO findAll(@PathVariable("index")int index, @PathVariable("limit")int limit){
        return new UserVO(0,"",userMapper.count(),userMapper.findAll(index,limit));
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id")long id){
        return userMapper.findById(id);
    }

    @GetMapping("/count")
    public int count(){
        return  userMapper.count();
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        userMapper.save(user);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user){
        userMapper.update(user);
    }

    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id")long id){
        userMapper.deleteById(id);
    }
}

package com.klay.controller;

import com.klay.mapper.AdminMapper;
import com.klay.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/18 15:20
 **/

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/login/{username}/{password}/{type}")
    public Object login(@PathVariable("username") String username ,@PathVariable("password") String password,@PathVariable("type")String type){
        Object object = null;
        switch(type){
            case "user":
                return object = userMapper.login(username, password);
            case "admin":
                return object = adminMapper.login(username, password);
        }
        return object;
    }
}

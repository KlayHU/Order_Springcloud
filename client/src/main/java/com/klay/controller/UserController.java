package com.klay.controller;

import com.klay.entity.User;
import com.klay.entity.UserVO;
import com.klay.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/17 22:08
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFeign userFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(@RequestParam("page")int page, @RequestParam("limit")int limit){
        int index= (page-1)*limit;
        return userFeign.findAll(index,limit);
    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location")String location){
        return location;
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id")long id){
        return userFeign.findById(id);
    }

    @GetMapping("/count")
    public int count(){
        return  userFeign.count();
    }

    @PostMapping("/save")
    public String save(User user){
        Date date = new Date();
        user.setRegisterdate(date);
        userFeign.save(user);
        return "redirect:/user/redirect/user_manage";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id")long id){
        userFeign.deleteById(id);
        return "redirect:/user/redirect/user_manage";
    }
}

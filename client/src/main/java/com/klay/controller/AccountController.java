package com.klay.controller;

import com.klay.entity.Admin;
import com.klay.entity.User;
import com.klay.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/18 17:34
 **/
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountFeign accountFeign;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session){
        Object object = accountFeign.login(username, password,type);
        LinkedHashMap<String,Object> hashMap =(LinkedHashMap)object;
        String result = null;
        if(object==null){
            result = "login";
        }else {
            switch (type){
                case "user":
                    User user = new User();
                    String idStr = hashMap.get("id")+"";
                    long id = Long.parseLong(idStr);
                    String nickname = (String) hashMap.get("nickname");
                    user.setId(id);
                    user.setNickname(nickname);
                    session.setAttribute("user",user);
                    result = "index";
                    break;
                case "admin":
                    Admin admin = new Admin();
                    String id1 = hashMap.get("id")+"";
                    long Id = Long.parseLong(id1);
                    String userName = (String) hashMap.get("username");
                    admin.setId(Id);
                    admin.setUsername(userName);
                    session.setAttribute("admin",admin);
                    result = "main";
                    break;
            }
        }
        return result;
    }
    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location")String location){
        return location;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();   //销毁session
        return "redirect:/account/redirect/login";
    }

}

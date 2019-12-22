package com.klay.controller;

import com.klay.entity.Menu;
import com.klay.entity.Order;
import com.klay.entity.OrderVO;
import com.klay.entity.User;
import com.klay.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/19 9:37
 **/
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/save/{mid}")
    public String save(@PathVariable("mid")long mid, HttpSession session){
        User user = (User) session.getAttribute("user");
        Order order = new Order();
        order.setUser(user);
        Menu menu = new Menu();
        menu.setId(mid);
        order.setMenu(menu);
        orderFeign.save(order);
        return "order";
    }

    @GetMapping("/findByUid")
    @ResponseBody
    public OrderVO findByUid(@RequestParam("page")int page,@RequestParam("limit")int limit, HttpSession session){ //从session里面拿uid,并且接收前端传来的page和limit
       User user =(User) session.getAttribute("user");
       //把user的id作为参数传下去
       int index = (page-1)*limit;
       return orderFeign.findByUid(index,limit,user.getId());
    }

    @GetMapping("/findAll")
    @ResponseBody
    public OrderVO findAll(@RequestParam("page")int page,@RequestParam("limit")int limit){
        int index = (page-1)*limit;
        return orderFeign.findAll(index,limit);
    }

    @GetMapping("/updateState/{id}")
    public String updateState(@PathVariable("id")long id){
        orderFeign.updateState(id);
        return "redirect:/menu/redirect/order_handler";
    }
}

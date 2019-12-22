package com.klay.controller;

import com.klay.entity.Order;
import com.klay.entity.OrderVO;
import com.klay.mapper.OrderMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/12 16:13
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @PostMapping("/save")
    public void save(@RequestBody Order order){
        Date date = new Date();
        order.setDate(date);
        orderMapper.save(order);
    }

    @GetMapping("/findByUid/{index}/{limit}/{uid}")
    public OrderVO findByUid(@PathVariable("index")int index, @PathVariable("limit")int limit, @PathVariable("uid")int uid){
        OrderVO orderVO = new OrderVO();
        orderVO.setCount(orderMapper.countByUid(uid));
        orderVO.setData(orderMapper.findByUid(index, limit, uid));
        orderVO.setMsg("");
        return orderVO;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public OrderVO findAll(@PathVariable("index")int index,@PathVariable("limit") int limit){
        OrderVO orderVO = new OrderVO();
        orderVO.setMsg("");
        orderVO.setCount(orderMapper.count());      //查出所有state=0的数据
        orderVO.setData(orderMapper.findAll(index,limit));
        return orderVO;
    }

    @PutMapping("/updateState/{id}")
    public void updateState(@PathVariable("id")long id){
        orderMapper.updateState(id);
    }

    @GetMapping("/countByUid/{uid}")
    public int countByUid(@PathVariable("uid")long uid){
        return orderMapper.countByUid(uid);
    }
}

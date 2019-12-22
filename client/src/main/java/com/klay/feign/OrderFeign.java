package com.klay.feign;

import com.klay.entity.Order;
import com.klay.entity.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/19 9:39
 **/
@FeignClient(value = "order")
public interface OrderFeign {

    @PostMapping("/order/save")
    public void save(@RequestBody Order order);

    @GetMapping("/order/findByUid/{index}/{limit}/{uid}")
    public OrderVO findByUid(@PathVariable("index")int index,@PathVariable("limit")int limit,@PathVariable("uid")long uid);

    @GetMapping("/order/findAll/{index}/{limit}")
    public OrderVO findAll(@PathVariable("index")int index,@PathVariable("limit")int limit);

    @PutMapping("/order/updateState/{id}")
    public void updateState(@PathVariable("id")long id);
}

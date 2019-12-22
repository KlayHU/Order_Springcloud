package com.klay.feign;

import com.klay.entity.Menu;
import com.klay.entity.MenuVO;
import com.klay.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/13 16:57
 **/
@FeignClient(value = "menu")    //直接关联服务提供者
public interface MenuFeign {

    @GetMapping("/menu/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @DeleteMapping("/menu/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id);

    @GetMapping("/menu/findTypes")
    public List<Type> findTypes();

    @PostMapping("/menu/save")
    public Menu save(Menu menu);

    @GetMapping("/menu/findById/{id}")
    public Menu findById(@PathVariable("id")long id);

    @PutMapping("/menu/update")
    public void update(Menu menu);
}
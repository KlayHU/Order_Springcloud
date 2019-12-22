package com.klay.controller;

import com.klay.entity.Menu;
import com.klay.entity.MenuVO;
import com.klay.entity.Type;
import com.klay.mapper.MenuMapper;
import com.klay.mapper.TypeMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/13 10:50
 **/
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired      //通过扫描的方式让IoC知道要扫进来
    private MenuMapper menuMapper;

    @Autowired
    private TypeMapper typeMapper;

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return this.port;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        //在建立MenuVO的时候使用了构造器注解
        return new MenuVO(0,"",menuMapper.count(),menuMapper.findAll(index,limit));
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id")long id){
        menuMapper.deleteById(id);
    }

    @GetMapping("/findTypes")
    public List<Type> findTypes(){
        return typeMapper.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuMapper.save(menu);
    }

   @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id")long id){
       return menuMapper.findById(id);
   }

   @PutMapping("/update")
   public void update(@RequestBody Menu menu){
        menuMapper.update(menu);
   }
}

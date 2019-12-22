package com.klay.controller;

import com.klay.entity.Menu;
import com.klay.entity.MenuVO;
import com.klay.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/15 0:19
 **/
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public MenuVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index = (page-1)*limit;
        return menuFeign.findAll(index,limit);
    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location")String location){
        return location;
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id")long id){
        menuFeign.deleteById(id);
        return "redirect:/menu/redirect/menu_manage";
    }

    //添加操作
    @GetMapping("/findTypes")
    public ModelAndView findTypes(){
      ModelAndView modelAndView = new ModelAndView();
      modelAndView.setViewName("menu_add");
      modelAndView.addObject("list",menuFeign.findTypes());     //模型数据,这里的list是所有Type的集合
         return modelAndView;
    }

    //结合视图展示
    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id")long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu_update");
        modelAndView.addObject("menu",menuFeign.findById(id));
        modelAndView.addObject("list",menuFeign.findTypes());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Menu menu){
        menuFeign.save(menu);
        return "redirect:/menu/redirect/menu_manage";
    }

    @PostMapping("/update")
    public String update(Menu menu){
        menuFeign.update(menu);
        return "redirect:/menu/redirect/menu_manage";
    }
}
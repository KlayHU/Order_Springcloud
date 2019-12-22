package com.klay.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/18 17:41
 **/
@FeignClient(value = "account")
public interface AccountFeign {

    @GetMapping("/account/login/{username}/{password}/{type}")
    public Object login(@PathVariable("username")String username,@PathVariable("password")String password,@PathVariable("type")String type);

}

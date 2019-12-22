package com.klay.feign;

import com.klay.entity.User;
import com.klay.entity.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/17 21:57
 **/
@FeignClient(value = "user")
public interface UserFeign {

    @GetMapping("/user/findAll/{index}/{limit}")
    public UserVO findAll(@PathVariable("index")int index, @PathVariable("limit")int limit);

    @GetMapping("/user/findById/{id}")
    public User findById(@PathVariable("id") long id);

    @GetMapping("/user/conut")
    public int count();

    @PostMapping("/user/save")
    public void save(User user);

    @PutMapping("/user/update")
    public void update(User user);

    @GetMapping("/user/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id);
}

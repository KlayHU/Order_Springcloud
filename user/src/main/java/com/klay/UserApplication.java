package com.klay;

import org.apache.catalina.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/17 14:25
 **/
@SpringBootApplication
@MapperScan("com.klay.mapper")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}

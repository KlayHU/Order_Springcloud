package com.klay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/13 10:49
 **/
@SpringBootApplication
@MapperScan("com.klay.mapper")      //扫描
public class MenuApplication {
    public static void main(String[] args) {
        SpringApplication.run(MenuApplication.class,args);
    }
}

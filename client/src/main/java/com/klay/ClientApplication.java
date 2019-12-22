package com.klay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description:
 * @author: KlayHu
 * @create: 2019/12/13 16:53
 **/
@SpringBootApplication
@EnableFeignClients             //Client通过Feign去调用服务提供者里的接口
@ServletComponentScan
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class,args);
    }
}

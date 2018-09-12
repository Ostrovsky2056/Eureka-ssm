package com.ostrovsky.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: eurekassm
 * @description: Eureka注册服务启动入口
 * @author: Ostrovsky
 * @create: 2018-09-12 17:27:48
 */
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}

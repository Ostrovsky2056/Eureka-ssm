package com.ostrovsky.serviceribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @program: eureka-ssm
 * @description: Ribbon服务启动入口
 * @author: Ostrovsky
 * @create: 2018-09-07 13:55:25
 */
@SpringBootApplication
@EnableEurekaClient
//开启对Hystrix短路器
@EnableHystrix
public class ServiceRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRibbonApplication.class, args);
    }
}

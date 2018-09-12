package com.ostrovsky.serviceribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: eurekassm
 * @description: RibbonConfig
 * @author: Ostrovsky
 * @create: 2018-09-12 19:02:43
 */
@Configuration
public class RibbonConfig {

    @Bean
    //让RestTemplate达到负载均衡的功能
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

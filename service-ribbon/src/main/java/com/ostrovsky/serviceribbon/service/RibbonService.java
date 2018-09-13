package com.ostrovsky.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ostrovsky.serviceribbon.Utils.URLUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @program: eurekassm
 * @description: RibbonService
 * @author: Ostrovsky
 * @create: 2018-09-13 09:08:00
 */
@Service
public class RibbonService {
    @Resource
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    public String testHytrix(String name){
        String url = URLUtil.getClientURL("/hello"+"/"+name);
        return restTemplate.getForObject(url, String.class);
    }

    public String error(String name){
        return "Sorry,"+name+". ERROR!";
    }
}

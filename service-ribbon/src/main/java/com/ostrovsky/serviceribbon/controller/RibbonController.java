package com.ostrovsky.serviceribbon.controller;

import com.ostrovsky.serviceribbon.Utils.URLUtil;
import com.ostrovsky.serviceribbon.service.RibbonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @program: eurekassm
 * @description: RibbonAPI
 * @author: Ostrovsky
 * @create: 2018-09-12 19:02:43
 */
@RestController
public class RibbonController {
    //注入RestTemplate负责负载均衡类
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private RibbonService ribbonService;

    /**
     * 通过此接口调用客户端接口
     * @return
     */
    @GetMapping("/hello/{name}")
    public String world(@PathVariable("name") String name){
        String apiUrl = "/hello";
        String url = URLUtil.getClientURL(apiUrl);
        return restTemplate.getForObject(url+"/"+name, String.class);
    }

    /**
     * 集群测试
     * @return
     */
    @GetMapping("/testRibbon/{name}")
    public String testRibbon(@PathVariable("name") String name){
        String url = URLUtil.getClientURL("/testRibbon"+"/"+name);
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/testHystrix/{name}")
    public String testHystrix(@PathVariable("name") String name){
        return ribbonService.testHytrix(name);
    }
}

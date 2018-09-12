package com.ostrovsky.serviceribbon.api;

import com.ostrovsky.serviceribbon.Utils.URLUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @program: eurekassm
 * @description: RibbonAPI
 * @author: Ostrovsky
 * @create: 2018-09-12 19:02:43
 */
public class RibbonAPI {
    //注入RestTemplate负责负载均衡类
    @Resource
    private RestTemplate restTemplate;

    /**
     * 通过此接口调用客户端接口
     * @return
     */
    @RequestMapping("/hello")
    public String world(){
        String apiUrl = "/hello";
        String url = URLUtil.getClientURL(apiUrl);
        return restTemplate.getForObject(url+"/Ostrovsky", String.class);
    }

    /**
     * 集群测试
     * @return
     */
    @GetMapping("/testRibbon")
    public String testRibbon(){
        String url = URLUtil.getClientURL("/testRibbon");
        return restTemplate.getForObject(url, String.class);
    }
}

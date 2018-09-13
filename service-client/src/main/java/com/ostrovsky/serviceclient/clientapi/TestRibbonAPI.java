package com.ostrovsky.serviceclient.clientapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: eureka-ssm
 * @description: 测试负载均衡API
 * @author: Ostrovsky
 * @create: 2018-09-07 14:48:15
 */
@RestController
public class TestRibbonAPI {

    /**
     * 提供Ribbon负载均衡以及客户端服务集群的测试接口
     *   打印当前服务的端口号
     * @param request 请求
     * @return 打印当前服务端口号
     */
    @GetMapping("/testRibbon/{name}")
    public String testRibbon(
            @PathVariable("name") String name,
            HttpServletRequest request){
        return "Hi"+"\t"+name+"\trequest from "+request.getServerPort();
    }
}

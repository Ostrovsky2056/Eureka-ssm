package com.ostrovsky.serviceclient.clientapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: eureka-ssm
 * @description: 客户端API
 * @author: Ostrovsky
 * @create: 2018-09-07 14:55:25
 */
@RestController
public class ClientAPI {
    //注入端口号
    @Value("${server.port}")
    private String port;

    /**
     * 测试客户端服务接口
     * @param name 姓名
     * @return 拼接后的字符串
     */
    @GetMapping("/hello/{name}")
    public String hello(
            @PathVariable("name") String name) {
        return "Hello"+"\t"+name+"!"+"\n"+"--from"+"\t"+port;
    }
}

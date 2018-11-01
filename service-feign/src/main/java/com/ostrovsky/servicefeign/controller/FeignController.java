package com.ostrovsky.servicefeign.controller;

import com.ostrovsky.servicefeign.service.FeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: eurekassm
 * @description: FeignController
 * @author: Ostrovsky
 * @create: 2018-09-12 21:43:25
 */
@RestController
public class FeignController {

    @Resource
    FeignService feignService;

    @GetMapping("/testFeign/{name}")
    public String testFeign(@PathVariable("name") String name){
        return feignService.testFeign(name);
    }

    @GetMapping("/testMock/{name}")
    public String testMock(@PathVariable("name") String name) {
        return name;
    }
}

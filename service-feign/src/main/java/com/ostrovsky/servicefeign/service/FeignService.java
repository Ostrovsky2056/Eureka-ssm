package com.ostrovsky.servicefeign.service;

import com.ostrovsky.servicefeign.hystriximpl.HystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: eurekassm
 * @description: FeignService
 * @author: Ostrovsky
 * @create: 2018-09-12 21:38:50
 */
@FeignClient(value = "service-client" , fallback = HystrixImpl.class)
public interface FeignService {

    @GetMapping("/hello/{name}")
    String testFeign(@PathVariable("name") String name);
}

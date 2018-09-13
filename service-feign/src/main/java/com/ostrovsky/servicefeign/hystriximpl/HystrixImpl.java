package com.ostrovsky.servicefeign.hystriximpl;

import com.ostrovsky.servicefeign.service.FeignService;
import org.springframework.stereotype.Component;

/**
 * @program: eurekassm
 * @description: HystrixImpl
 * @author: Ostrovsky
 * @create: 2018-09-13 09:23:31
 */
@Component
public class HystrixImpl implements FeignService {
    @Override
    public String testFeign(String name) {
        return "Sorry,"+name+". ERROR!";
    }
}

package com.service.feign.servicefeign.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: zhouhy
 * @Description:
 * @Date: Create in 17:27 2018/6/20
 * @Modified By
 */
@Service
@FeignClient(value = "service-hello" ,fallback = SchedualServiceHiHystric.class)
public interface HiService {



    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}

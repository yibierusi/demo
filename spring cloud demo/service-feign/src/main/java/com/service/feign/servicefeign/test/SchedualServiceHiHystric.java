package com.service.feign.servicefeign.test;

import org.springframework.stereotype.Component;

/**
 * @Auther: zhouhy
 * @Description:
 * @Date: Create in 13:28 2018/6/21
 * @Modified By
 */
@Component
public class SchedualServiceHiHystric implements HiService{
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry :" + name;
    }
}

package com.service.ribbon.serviceribbon.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: zhouhy
 * @Description:
 * @Date: Create in 17:50 2018/6/19
 * @Modified By
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String hiServer(String name) {
        return restTemplate.getForObject("http://service-hello/hi?name=" + name, String.class);
    }
}

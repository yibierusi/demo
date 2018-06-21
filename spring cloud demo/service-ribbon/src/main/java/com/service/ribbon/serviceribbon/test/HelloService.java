package com.service.ribbon.serviceribbon.test;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiServer(String name) {
        return restTemplate.getForObject("http://service-hello/hi?name=" + name, String.class);
    }


    public String hiError(String name) {
        return restTemplate.getForObject("http://service-hello/hi?name=" + name, String.class);
    }
}

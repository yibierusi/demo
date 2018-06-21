package com.service.ribbon.serviceribbon.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: zhouhy
 * @Description:
 * @Date: Create in 17:51 2018/6/19
 * @Modified By
 */
@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;

    @RequestMapping("hi")
    public String hi(@RequestParam String name){
        return helloService.hiServer(name);
    }
}

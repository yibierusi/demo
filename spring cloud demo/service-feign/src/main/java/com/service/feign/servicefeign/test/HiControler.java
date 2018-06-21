package com.service.feign.servicefeign.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: zhouhy
 * @Description:
 * @Date: Create in 17:26 2018/6/20
 * @Modified By
 */
@RestController
public class HiControler {
    @Autowired
    public HiService hiService;
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return hiService.sayHiFromClientOne(name);
    }

}

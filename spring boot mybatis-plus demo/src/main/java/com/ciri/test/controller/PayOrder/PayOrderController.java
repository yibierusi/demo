package com.ciri.test.controller.PayOrder;


import com.ciri.test.service.PayOrder.PayOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhouhy
 * @since 2018-06-13
 */
@Controller
@RequestMapping("/payOrder")
public class PayOrderController {

    @Autowired
    private PayOrderService payOrderService;


    public void test(){
        //payOrderService.
    }
	
}

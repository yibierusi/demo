package com.ciri.test.service.PayOrder.impl;

import com.ciri.test.entry.PayOrder.PayOrder;
import com.ciri.test.dao.PayOrder.PayOrderMapper;
import com.ciri.test.service.PayOrder.PayOrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouhy
 * @since 2018-06-13
 */
@Service
public class PayOrderServiceImpl extends ServiceImpl<PayOrderMapper, PayOrder> implements PayOrderService {
	
}

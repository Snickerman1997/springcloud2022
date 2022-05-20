package com.chy.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author Snickerman
 * @create 2022-05-17 15:41
 * @Description
 */
@Component
public class PaymentFallbackService implements PaymentFeignService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService fallback back-paymentInfo_Ok";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService back-paymentInfo_TimeOut";
    }
}

package com.chy.springcloud.controller;

import com.chy.springcloud.entities.CommonResult;
import com.chy.springcloud.entities.Payment;
import com.chy.springcloud.service.impl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Snickerman
 * @create 2022-05-09 16:29
 * @Description
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentServiceImpl paymentServiceImpl;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int result = paymentServiceImpl.create(payment);
        log.info("插入结果：" + result);
        if(result > 0){
            return new CommonResult<>(200,"插入数据库成功,serverPort:" + serverPort, result);
        }else{
            return new CommonResult<>(444, "插入数据不成功,serverPort:" + serverPort, null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentServiceImpl.getPaymentById(id);
        log.info("获取结果：" + payment);
        if(payment != null){
            return  new CommonResult<>(200, "查询成功,serverPort:" + serverPort, payment);
        }else {
            return  new CommonResult<>(444,"没有对应记录，查询ID:" + id, null);
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}

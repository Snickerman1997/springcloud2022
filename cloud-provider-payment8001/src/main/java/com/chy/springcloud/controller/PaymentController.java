package com.chy.springcloud.controller;

import com.chy.springcloud.entities.CommonResult;
import com.chy.springcloud.entities.Payment;
import com.chy.springcloud.service.impl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

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

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for(String service : services){
            log.info("service:" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance : instances){
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}

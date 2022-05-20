package com.chy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Snickerman
 * @create 2022-05-12 17:41
 * @Description
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    public static final String INVOKE_URL="http://cloud-provider-payment";

    @GetMapping("/consumer/payment/consul")
    public String paymentInfo(){
        return  restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
    }
}

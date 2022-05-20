package com.chy.springcloud;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.chy.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author Snickerman
 * @create 2022-05-09 17:33
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name="CLOUD_PAYMENT_SERVICE", configuration = MySelfRule.class)
public class OrderMain80 {

    public static void main(String[] args) {
        System.out.println("order80开始");
        SpringApplication.run(OrderMain80.class, args);
    }
}

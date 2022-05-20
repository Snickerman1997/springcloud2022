package com.chy.springcloud.service;

import com.chy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Snickerman
 * @create 2022-05-09 16:17
 * @Description
 */

public interface PaymentService {

    public int create(Payment payment);

    public  Payment getPaymentById(@Param("id") Long id);
}

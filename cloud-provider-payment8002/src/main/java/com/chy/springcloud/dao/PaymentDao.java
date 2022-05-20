package com.chy.springcloud.dao;

import com.chy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Snickerman
 * @create 2022-05-09 15:55
 * @Description
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public  Payment getPaymentById(@Param("id") Long id);

}

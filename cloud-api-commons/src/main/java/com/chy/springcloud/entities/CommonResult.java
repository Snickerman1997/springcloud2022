package com.chy.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Snickerman
 * @create 2022-05-08 21:10
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//类加泛型那么可以生成多个该类的子类 CommonResult<Payment>、 CommonResult<Order>等
//类加泛型，说明该类中的某个成员变量是泛型，定义时不知道啥类型，使用时可规定
public class CommonResult<T> {
    //404 not_found

    private Integer code;
    private String message;
    private T data;

    public  CommonResult(Integer code, String message){
        this(code, message,null);
    }

}

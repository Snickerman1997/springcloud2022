package com.chy.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Snickerman
 * @create 2022-05-12 21:12
 * @Description
 */
@Component
public class MyLB implements LoadBalancer{
    //原子整型，规定一个值
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        //CAS + 自旋锁
        do {
            //获取当前的原子整型值
            current = this.atomicInteger.get();
            //设置next的值
            next = current >= 2147483647 ? 0 : current + 1;

            //atomicInteger.compareAndSet(current, next) 该方法的第一个参数为期望值，第二个参数为要修改成为的值。
            //如果此时atomicInteger的值即current的值等于期望的值，current。因为牵扯到多线程的问题，先将atomicInteger
            //的值赋值给current作为期望值，如果此时其他的线程没有对atomic进行操作，那么与期望值相同，返回true。
            // 否则不相同，返回false
        }while (!this.atomicInteger.compareAndSet(current, next));
        return next;
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}

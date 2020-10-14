package com.cqaos.consumer;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RoutingConsumer {
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, // 创建临时队列
                    exchange = @Exchange(value = "directs", type = "direct"), // 绑定交换机
                    key = {"info", "error"}
            )
    })
    public void getMsg1(String msg) {
        System.out.println("消费者1：" + msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, // 创建临时队列
                    exchange = @Exchange(value = "directs", type = "direct"), // 绑定交换机
                    key = {"error"}
            )
    })
    public void getMsg2(String msg) {
        System.out.println("消费者2：" + msg);
    }
}

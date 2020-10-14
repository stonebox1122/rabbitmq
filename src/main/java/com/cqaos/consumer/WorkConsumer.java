package com.cqaos.consumer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkConsumer {
    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void getMsg1(String msg) {
        System.out.println("消费者1：" + msg);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void getMsg2(String msg) {
        System.out.println("消费者2：" + msg);
    }
}

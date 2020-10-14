package com.cqaos.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    // topic 动态路由
    @Test
    public void testTopic() {
//        rabbitTemplate.convertAndSend("topics", "user.save", "test topic");
//        rabbitTemplate.convertAndSend("topics", "order", "test topic");
        rabbitTemplate.convertAndSend("topics", "product.user.add", "test topic");
    }

    // routing 路由
    @Test
    public void testRouting() {
        rabbitTemplate.convertAndSend("directs", "error", "test routing");
    }

    // fanout 广播
    @Test
    public void testFanout() {
        rabbitTemplate.convertAndSend("logs", "", "test fanout");
    }


    // work
    @Test
    public void testWork() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work", "test work");
        }
    }

    // hello world
    @Test
    public void testHello() {
        rabbitTemplate.convertAndSend("hello", "test hello");
    }
}

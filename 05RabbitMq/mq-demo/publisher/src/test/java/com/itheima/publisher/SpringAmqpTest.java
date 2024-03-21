package com.itheima.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringAmqpTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void testSendMessage() {
        String queueName = "simple.queue";
        String msg = "hello amqp2";
        rabbitTemplate.convertAndSend(queueName, msg);
    }

    @Test
    void testWorkQueue() throws InterruptedException {
        String queueName = "work.queue";
        for (int i = 1; i <= 50; i++) {
            String msg = "hello msg_" + i;
            rabbitTemplate.convertAndSend(queueName, msg);
            Thread.sleep(20);
        }
    }

    @Test
    void testSendExchangeMessage() {
        String queueName = "hmall.fanout";
        String msg = "hello fanout";
        rabbitTemplate.convertAndSend(queueName,null, msg);
    }

    @Test
    void testSendDirectMessage() {
        String queueName = "hmall.direct";
        String msg = "红色警报!!!";
        rabbitTemplate.convertAndSend(queueName,"blue", msg);
    }

    @Test
    void testSendTopicMessage() {
        String queueName = "hmall.topic";
        String msg = "天气!!!";
        rabbitTemplate.convertAndSend(queueName,"china.weather", msg);
    }
}

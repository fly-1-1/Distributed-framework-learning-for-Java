package com.jy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jy.rabbit.config.RabbitMQConfig.Exchange_Name;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProducerTest {

    //注入RabbitTemplate
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSend(){
        rabbitTemplate.convertAndSend(Exchange_Name,"boot.haha","boot mq hello...");
    }
}

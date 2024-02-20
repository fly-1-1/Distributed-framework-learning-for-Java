package com.jy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "spring-rabbitmq-producer.xml")
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("spring_fanout_exchange","","spring fanout...");
        
    }

    @Test
    public void TopicFanout(){
        rabbitTemplate.convertAndSend("spring_topic_exchange","heima.hehe.haha","spring topic...");

    }

}

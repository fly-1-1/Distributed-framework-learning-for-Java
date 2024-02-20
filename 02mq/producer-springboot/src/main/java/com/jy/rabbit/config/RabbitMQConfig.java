package com.jy.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String Exchange_Name ="boot_topic_exchange";
    public static final String Queue_Name ="boot_queue";


    //交换机
    @Bean("bootExchange")
    public Exchange bootExchange(){
        return ExchangeBuilder.topicExchange(Exchange_Name).durable(true).build();
    }
    //队列
    @Bean("bootQueue")
    public Queue bootQueue(){
        return QueueBuilder.durable(Queue_Name).build();
    }

    //队列和交换机绑定
    @Bean
    public Binding bindingQueueExchange(@Qualifier("bootQueue") Queue queue,@Qualifier("bootExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("boot.#").noargs();
    }



}

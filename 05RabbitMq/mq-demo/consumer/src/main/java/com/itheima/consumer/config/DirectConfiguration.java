package com.itheima.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfiguration {

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("hmall.direct");
    }

    @Bean
    public Queue directQueue1() {
        return new Queue("direct.queue1");
    }


    @Bean
    public Binding directQueue1BindingRed(Queue directQueue1,DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue1).to(directExchange).with("red");
    }

    @Bean
    public Binding directQueue1BindingBlue(Queue directQueue1,DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue1).to(directExchange).with("blue");
    }


    @Bean
    public Queue directQueue2() {
        return new Queue("direct.queue2");
    }


    @Bean
    public Binding directQueue2BindingRed(Queue directQueue2,DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue2).to(directExchange).with("red");
    }

    @Bean
    public Binding directQueue2BindingYellow(Queue directQueue2,DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue2).to(directExchange).with("yellow");
    }


}

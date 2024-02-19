package com.jy.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer_HelloWorld {

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory=new ConnectionFactory();
        //设置参数
        factory.setHost("");
        //创建连接
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("guest");
        factory.setPassword("guest");
        //创建channel
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //创建队列
        channel.queueDeclare("hello_world",true,false,false,null);

        String body="hello mq";

        //发送消息
        channel.basicPublish("","hello_world",null,body.getBytes());

        //释放资源
        channel.close();
        connection.close();
    }

}

package com.jy.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer_WorkQueues1 {

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
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
        channel.queueDeclare("work_queues", true, false, false, null);

        for (int i = 0; i <= 10; i++) {
            String body = i + "work_queues";
            //发送消息
            channel.basicPublish("", "work_queues", null, body.getBytes());
        }


        //释放资源
        channel.close();
        connection.close();
    }

}

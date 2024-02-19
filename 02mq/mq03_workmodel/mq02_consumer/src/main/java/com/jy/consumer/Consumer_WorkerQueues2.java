package com.jy.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer_WorkerQueues2 {
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

        channel.queueDeclare("work_queues",true,false,false,null);

        DefaultConsumer consumer = new DefaultConsumer(channel){
            //当收到消息后会自动执行该方法
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("consumerTag:"+consumerTag);
                System.out.println("body:"+new String(body));
            }
        };
        channel.basicConsume("work_queues",true,consumer);
    }
}

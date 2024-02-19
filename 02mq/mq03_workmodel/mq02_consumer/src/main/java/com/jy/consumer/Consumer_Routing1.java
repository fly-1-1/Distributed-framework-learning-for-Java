package com.jy.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer_Routing1 {
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory=new ConnectionFactory();
        //设置参数
        factory.setHost("192.168.238.145");
        //创建连接
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("guest");
        factory.setPassword("guest");
        //创建channel
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        String queue1Name="test_direct_queue1";
        String queue2Name="test_direct_queue2";



        DefaultConsumer consumer = new DefaultConsumer(channel){
            //当收到消息后会自动执行该方法
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //System.out.println("consumerTag:"+consumerTag);
                System.out.println("body:"+new String(body));
                System.out.println("存储到数据库");
            }
        };
        channel.basicConsume(queue1Name,true,consumer);
    }
}

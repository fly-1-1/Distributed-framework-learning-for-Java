package com.jy.producer;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer_Routing {

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
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

        String exchangeName = "test_direct";
        //创建交换机
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.DIRECT,true,false,false,null);
        //创建队列
        String queue1Name="test_direct_queue1";
        String queue2Name="test_direct_queue2";
        channel.queueDeclare(queue1Name,true,false,false,null);
        channel.queueDeclare(queue2Name,true,false,false,null);

        //绑定队列和交换机
        channel.queueBind(queue1Name,exchangeName,"error");

        channel.queueBind(queue2Name,exchangeName,"info");
        channel.queueBind(queue2Name,exchangeName,"warning");
        channel.queueBind(queue2Name,exchangeName,"error");


        String body="日志 张三调用了Delete..";

        //发送资源
        channel.basicPublish(exchangeName,"error",null,body.getBytes());

        //释放资源
        channel.close();
        connection.close();
    }

}

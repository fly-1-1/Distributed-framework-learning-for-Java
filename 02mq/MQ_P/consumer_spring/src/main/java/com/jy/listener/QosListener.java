package com.jy.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/***
 * Consumer 限流机制
 * 确保ack机制为手动确认
 * 配置属性 listener-container perfetch =1 表示消费端每次从mq拉去一条消息消费 消费完成再消费下一条
 */


@Component
public class QosListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {

        //获取消息
        System.out.println(new String(message.getBody()));
        //处理业务逻辑

        //签收
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);


    }
}

package com.jy.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.SQLOutput;

/***
 * Consumer Ack机制
 * 设置手动签收 acknowledge="manual"
 *  让监听器类实现接口 ChannelAwareMessageListener
 *  如果消息成功处理则调用channel的basicAck()签收
 *  basicNack拒绝签收 broker重新发送给consumer
 */


@Component
public class AckListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {

        long deliveryTag = message.getMessageProperties().getDeliveryTag();

        try {
            System.out.println(new String(message.getBody()));

            //处理业务逻辑
            System.out.println("处理业务逻辑");

            //手动签收
            channel.basicAck(deliveryTag,true);
        } catch (IOException e) {

            //拒绝签收

           channel.basicNack(deliveryTag,true,true);
        }
    }
}

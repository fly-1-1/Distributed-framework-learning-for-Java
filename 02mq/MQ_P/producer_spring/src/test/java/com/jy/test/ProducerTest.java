package com.jy.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("spring-rabbitmq-producer.xml")
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 确认模式
     **/
    @Test
    public void testConfirm() {
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            /***
             * @param correlationData 相关配置信息
             * @param ack             交换机是否成功收到消息了
             * @param cause           失败的原因
             */
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println("confirm方法执行...");
                if (ack) {
                    System.out.println("接收成功消息" + cause);
                } else {
                    System.out.println("接收失败消息" + cause);
                }
            }
        });

        rabbitTemplate.convertAndSend("test_exchange_confirm", "confirm", "message confirm...");

    }


    /**
     * 回退模式
     * 消息发送给exchange后 exchange到queue失败时才会执行ReturnCallBack
     * 开启回退模式
     * 设置returnCallBack
     * 设置exchange处理消息的模式
     * 如果没有路由到queue则丢弃消息
     * 如果没有路由到queue则返回消息发送方 returnCallBack
     **/
    @Test
    public void testReturn() {

        //设置交换机处理失败消息的模式
        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            /***
             * @param message 消息对象
             * @param i       错误
             * @param s       错误信息
             * @param s1      交换机
             * @param s2      路由键
             */
            @Override
            public void returnedMessage(Message message, int i, String s, String s1, String s2) {
                System.out.println("return 执行了....");

                System.out.println(message);
                System.out.println(i);
                System.out.println(s);
                System.out.println(s1);
                System.out.println(s2);
            }
        });

        rabbitTemplate.convertAndSend("test_exchange_confirm", "confirm", "message confirm...");

    }


    @Test
    public void testSend() {


        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("test_exchange_confirm", "confirm", "message confirm...");
        }



    }

    /***
     * 队列统一过期
     *
     * 单一消息过期
     */


    @Test
    public void testTtl() {


//        for (int i = 0; i < 10; i++) {
//            rabbitTemplate.convertAndSend("test_exchange_ttl", "ttl.hehe", "message ttl...");
//        }

        //消息单独过期
        rabbitTemplate.convertAndSend("test_exchange_ttl", "ttl.hehe", "message ttl...", new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //设置message信息
                message.getMessageProperties().setExpiration("5000");
                return message;
            }
        });


    }

}

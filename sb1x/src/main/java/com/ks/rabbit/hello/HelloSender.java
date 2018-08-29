package com.ks.rabbit.hello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Title: 发送者 <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月29日 16:48
 * @Verdion 1.0 版本
 * ${tags}
 */
@Component
public class HelloSender {

    /**
     * rabbitTemplate是springboot 提供的默认实现
     */
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }



}

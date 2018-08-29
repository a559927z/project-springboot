package com.ks.rabbit.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月29日 18:06
 * @Verdion 1.0 版本
 * ${tags}
 */
@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 会匹配到topic.#
     * 所以 TopicReceiver2 会接收到
     */
    public void send() {
        String context = "hi, i am message all";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.1", context);
    }

    /**
     * 会匹配到topic.#和topic.message 两个Receiver都可以收到消息
     * 所以 TopicReceiver1、TopicReceiver2 会接收到
     */
    public void send1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", context);
    }

    /**
     * 会匹配到topic.#
     * 所以 TopicReceiver2 会接收到
     */
    public void send2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", context);
    }
}
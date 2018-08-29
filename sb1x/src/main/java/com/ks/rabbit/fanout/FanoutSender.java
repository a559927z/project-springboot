package com.ks.rabbit.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月29日 18:29
 * @Verdion 1.0 版本
 * ${tags}
 */
@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 这里使用了A、B、C三个队列绑定到Fanout交换机上面，发送端的routing_key写任何字符都会被忽略：
     */
    public void send() {
        String context = "hi, fanout msg ";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange", "", context);
    }

}
package com.ks.rabbit.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月29日 17:10
 * @Verdion 1.0 版本
 * ${tags}
 */
@Component
public class KsSender2 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i) {
        String context = "spirng boot ks queue" + " ****** " + i;
        System.out.println("Sender2 : " + context);
        this.rabbitTemplate.convertAndSend("ks", context);
    }
}

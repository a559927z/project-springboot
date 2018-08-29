package com.ks.rabbit.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月29日 17:12
 * @Verdion 1.0 版本
 * ${tags}
 */
@Component
@RabbitListener(queues = "ks")
public class KsReceiver1 {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("Receiver 1: " + msg);
    }

}

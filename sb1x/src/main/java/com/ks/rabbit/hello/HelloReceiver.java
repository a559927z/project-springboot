package com.ks.rabbit.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Title: 接收者 <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月29日 16:50
 * @Verdion 1.0 版本
 * ${tags}
 */

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }

}

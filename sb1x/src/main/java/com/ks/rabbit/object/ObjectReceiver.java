package com.ks.rabbit.object;

import com.ks.dto.SbUser;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月29日 17:55
 * @Verdion 1.0 版本
 * ${tags}
 */
@Component
@RabbitListener(queues = "object")
public class ObjectReceiver {

    @RabbitHandler
    public void process(SbUser user) {
        System.out.println("Receiver object : " + user);
    }


}

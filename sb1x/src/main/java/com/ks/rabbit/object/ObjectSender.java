package com.ks.rabbit.object;

import com.ks.dto.SbUser;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ObjectSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(SbUser user) {
        System.out.println("Sender object: " + user.toString());
        this.rabbitTemplate.convertAndSend("object", user);
    }


}

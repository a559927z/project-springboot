package com.ks.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Title: 队列配置 <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月29日 16:46
 * @Verdion 1.0 版本
 * ${tags}
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    @Bean
    public Queue ksQueue() {
        return new Queue("ks");
    }

    @Bean
    public Queue objectQueue() {
        return new Queue("object");
    }

}

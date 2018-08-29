package com.ks.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Title: 主题 <br/>
 * <p>
 * Description: <br/>
 * topic 是RabbitMQ中最灵活的一种方式，可以根据routing_key自由的绑定不同的队列
 *
 * @author jxzhang
 * @DATE 2018年08月29日 18:02
 * @Verdion 1.0 版本
 * ${tags}
 */
@Configuration
public class RabbitTopicConfig {

    final static String message = "topic.message";
    final static String messages = "topic.messages";

    @Bean
    public Queue queueMessage() {
        return new Queue(RabbitTopicConfig.message);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(RabbitTopicConfig.messages);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}

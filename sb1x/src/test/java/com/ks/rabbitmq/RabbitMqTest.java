package com.ks.rabbitmq.hello;

import com.ks.dto.SbUser;
import com.ks.rabbit.fanout.FanoutSender;
import com.ks.rabbit.hello.HelloSender;
import com.ks.rabbit.many.KsSender1;
import com.ks.rabbit.many.KsSender2;
import com.ks.rabbit.object.ObjectSender;
import com.ks.rabbit.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月29日 16:53
 * @Verdion 1.0 版本
 * ${tags}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {


    @Autowired
    private HelloSender helloSender;

    @Autowired
    private KsSender1 ksSender1;

    @Autowired
    private KsSender2 ksSender2;

    @Autowired
    private ObjectSender objectSender;

    @Autowired
    private TopicSender topicSender;

    @Autowired
    private FanoutSender fanoutSender;


    /**
     * 简单使用
     *
     * @throws Exception
     */
    @Test
    public void hello() throws Exception {
        helloSender.send();
    }

    /**
     * 一对多
     * 一个发送者，N个接受者,经过测试会均匀的将消息发送到N个接收者中
     *
     * @throws Exception
     */
    @Test
    public void oneToMany() throws Exception {
        for (int i = 0; i < 100; i++) {
            ksSender1.send(i);
        }
    }

    /**
     * 多对多
     * 复制了一份发送者，加入标记，在一百个循环中相互交替发送
     * 和一对多一样，接收端仍然会均匀接收到消息
     *
     * @throws Exception
     */
    @Test
    public void manyToMany() throws Exception {
        for (int i = 0; i < 100; i++) {
            ksSender1.send(i);
            ksSender2.send(i);
        }
    }

    /**
     * 对象的支持
     * springboot以及完美的支持对象的发送和接收，不需要格外的配置。
     *
     * @throws Exception
     */
    @Test
    public void sendOject() throws Exception {
        SbUser user = new SbUser("ks", "123456");
        objectSender.send(user);
    }


    /**
     * 会匹配到topic.#
     *
     * @throws Exception
     */
    @Test
    public void topic() throws Exception {
        topicSender.send();
    }

    /**
     * 会匹配到topic.#和topic.message 两个Receiver都可以收到消息
     *
     * @throws Exception
     */
    @Test
    public void topic1() throws Exception {
        topicSender.send1();
    }

    /**
     * 会匹配到topic.#
     *
     * @throws Exception
     */
    @Test
    public void topic2() throws Exception {
        topicSender.send2();
    }


    /**
     * 广播模式或者订阅模式
     * 绑定到fanout交换机上面的队列都收到了消息
     *
     * @throws Exception
     */
    @Test
    public void fanoutSender() throws Exception {
        fanoutSender.send();
    }
}

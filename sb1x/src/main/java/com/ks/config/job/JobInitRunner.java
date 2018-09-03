package com.ks.config.job;

import com.ks.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月20日 19:01
 * @Verdion 1.0 版本
 * ${tags}
 */
@Component("JobInitRunner")
@Order(100)
@Slf4j
public class JobInitRunner implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private JobService jobService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //root application context 没有parent，他就是老大.
        if (event.getApplicationContext().getParent() == null) {
            //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
            log.info("job initAllJob run");
            jobService.initAllJOb();
        }
    }
}

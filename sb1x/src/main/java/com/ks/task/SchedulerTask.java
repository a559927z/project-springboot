package com.ks.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月29日 22:20
 * @Verdion 1.0 版本
 * ${tags}
 */
@Component
public class SchedulerTask {

    private int count = 0;

    /**
     * 每隔六秒
     */
    @Scheduled(cron = "*/6 * * * * ?")
    private void process() {
        System.out.println("this is scheduler task runing  " + (count++));
    }

}

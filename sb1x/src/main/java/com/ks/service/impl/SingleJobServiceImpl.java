package com.ks.service.impl;

import com.ks.dto.JobInfo;
import com.ks.service.SingleJobService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月20日 19:11
 * @Verdion 1.0 版本
 * ${tags}
 */
@Slf4j
@Service("singleJobService")
public class SingleJobServiceImpl implements SingleJobService {

    private final String JOB_SUFFIX = "_job";
    private final String TRIGGER_SUFFIX = "_trig";
    private final String JOB_GROUP = "DictGroup";

//    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @Override
    public void deleteJob(JobInfo jobInfo) {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = getTriggerKey(jobInfo);
        if (checkJobExist(jobInfo, scheduler)) {
            try {
                scheduler.unscheduleJob(triggerKey);
            } catch (SchedulerException e) {
                e.printStackTrace();
                log.error("删除作业，作业对象" + jobInfo + "\ne=" + e);
            }
        }

    }

    @Override
    public void initJob(JobInfo jobInfo) throws SchedulerException, ClassNotFoundException {
        // 获取调度器
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        // 创建一项作业
        JobDetail jobDetail = getJobDetail(jobInfo);
        // 创建一个触发器
        Trigger trigger = getTrigger(jobInfo);
        // 判断原来的触发器是否存在，若存在则删除重新加入
        if (checkJobExist(jobInfo, scheduler)) {
            TriggerKey triggerKey = getTriggerKey(jobInfo);
            scheduler.rescheduleJob(triggerKey, trigger);
            return;
        }
        // 告诉调度器使用该触发器来安排作业
        scheduler.scheduleJob(jobDetail, trigger);
    }

    @Override
    public void reLoadJob(JobInfo jobInfo) throws SchedulerException, ClassNotFoundException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = getTriggerKey(jobInfo);
        Trigger trigger = getTrigger(jobInfo);
        log.info("重新加载作业 -- " + jobInfo.getJobGroup() + "." + jobInfo.getJobName() + "cron changed to:" + jobInfo.getCronExpression());
        scheduler.rescheduleJob(triggerKey, trigger);
    }

    @Override
    public void runJob(String group, String name) throws SchedulerException, ClassNotFoundException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        log.info("作业运行中 --" + group + "." + name);
        scheduler.triggerJob(JobKey.jobKey(name, group));
    }


    /**
     * 判断原来的触发器是否存在
     *
     * @param jobInfo
     * @param scheduler
     * @return
     */
    private boolean checkJobExist(JobInfo jobInfo, Scheduler scheduler) {
        boolean jobExist = false;
        try {
            if (scheduler.checkExists(
                    JobKey.jobKey(jobInfo.getJobName() + JOB_SUFFIX, JOB_GROUP))
                    ||
                    scheduler.checkExists(TriggerKey.triggerKey(jobInfo.getJobName() + TRIGGER_SUFFIX, JOB_GROUP))) {
                jobExist = true;
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
            log.error("检查出错， e=" + e);
        }
        return jobExist;
    }

    private Trigger getTrigger(JobInfo jobInfo) {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(jobInfo.getCronExpression());
        return TriggerBuilder.newTrigger().withIdentity(jobInfo.getJobName() + TRIGGER_SUFFIX, JOB_GROUP).startNow()
                .withSchedule(cronScheduleBuilder).withDescription(jobInfo.getJobDescription()).build();
    }

    private JobDetail getJobDetail(JobInfo jobInfo) throws ClassNotFoundException {
        log.info("初始化作业:{}", jobInfo.getJobName());
        Class jobClass = Class.forName(jobInfo.getJobExecuteClass());
        return JobBuilder.newJob(jobClass).withIdentity(jobInfo.getJobName() + JOB_SUFFIX, JOB_GROUP).build();
    }


    /**
     * 触发器key
     *
     * @param jobInfo
     * @return
     */
    private TriggerKey getTriggerKey(JobInfo jobInfo) {
        return TriggerKey.triggerKey(jobInfo.getJobName() + TRIGGER_SUFFIX, JOB_GROUP);
    }
}

package com.ks.service;

import com.ks.dto.JobInfo;
import org.quartz.SchedulerException;

/**
 * Title: 单例JobService <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月20日 19:09
 * @Verdion 1.0 版本
 * ${tags}
 */
public interface SingleJobService {

    void deleteJob(JobInfo jobInfo);

    /**
     * 初始化scheduler中的任务
     *
     * @param jobInfo
     * @throws SchedulerException
     * @throws ClassNotFoundException
     */
    void initJob(JobInfo jobInfo) throws SchedulerException, ClassNotFoundException;

    /**
     * 重新加载scheduler中的任务
     *
     * @param jobInfo
     * @throws SchedulerException
     * @throws ClassNotFoundException
     */
    void reLoadJob(JobInfo jobInfo) throws SchedulerException, ClassNotFoundException;

    void runJob(String group, String name) throws SchedulerException, ClassNotFoundException;

}

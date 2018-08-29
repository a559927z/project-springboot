package com.ks.service.impl;

import com.ks.dto.JobInfo;
import com.ks.mapper.JobMapper;
import com.ks.service.JobService;
import com.ks.service.SingleJobService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月20日 19:08
 * @Verdion 1.0 版本
 * ${tags}
 */
@Slf4j
@Service("jobService")
public class JobServiceImpl implements JobService {

    @Autowired
    private SingleJobService singleJobService;

    @Autowired
    private JobMapper jobMapper;

    @Override
    public void initAllJOb() {
        // 获取所有定时任务
        List<JobInfo> jobInfoList = jobMapper.getAllEffectiveJob();
        if (ObjectUtils.isEmpty(jobInfoList)) {
            log.info("没有任务配置");
            return;
        }
        System.out.println("所有任务配置来自: \n" + jobInfoList);
        for (JobInfo jobInfo : jobInfoList) {
            if ("0".equals(jobInfo.getJobStatus())) {
                try {
                    singleJobService.initJob(jobInfo);
                } catch (SchedulerException e) {
                    e.printStackTrace();
                    log.error("初始化错误, jobInfo=" + jobInfo + "\ne=" + e);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    log.error("初始化错误, jobInfo=" + jobInfo + "\ne=" + e);
                }
            }
        }

    }

    @Override
    public void addJob(JobInfo jobInfo) {
        try {
            singleJobService.initJob(jobInfo);
        } catch (SchedulerException e) {
            e.printStackTrace();
            log.error("添加错误, jobInfo=" + jobInfo + "\ne=" + e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            log.error("添加错误, jobInfo=" + jobInfo + "\ne=" + e);
        }
    }

    @Override
    public void updateJob(JobInfo jobInfo) {
        try {
            singleJobService.reLoadJob(jobInfo);
        } catch (SchedulerException e) {
            e.printStackTrace();
            log.error("更新错误, jobInfo=" + jobInfo + "\ne=" + e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            log.error("更新错误, jobInfo=" + jobInfo + "\ne=" + e);
        }
    }
}

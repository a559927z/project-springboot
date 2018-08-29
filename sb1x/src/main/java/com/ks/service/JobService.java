package com.ks.service;

import com.ks.dto.JobInfo;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月20日 19:04
 * @Verdion 1.0 版本
 * ${tags}
 */
public interface JobService {

    void initAllJOb();

    void addJob(JobInfo jobInfo);

    void updateJob(JobInfo jobInfo);
}

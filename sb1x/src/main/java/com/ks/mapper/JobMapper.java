package com.ks.mapper;

import com.ks.dto.JobInfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月20日 19:33
 * @Verdion 1.0 版本
 * ${tags}
 */
@Repository("jobMapper")
public interface JobMapper {

    List<JobInfo> getAllEffectiveJob();

    JobInfo getJobInfo(HashMap<String, String> param);

    void insertJobInfo(JobInfo jobInfo);

    void deleteJobInfo(JobInfo jobInfo);

    void updateJobInfo(JobInfo jobInfo);
}

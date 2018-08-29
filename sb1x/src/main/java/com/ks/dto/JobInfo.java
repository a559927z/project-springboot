package com.ks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月20日 19:05
 * @Verdion 1.0 版本
 * ${tags}
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class JobInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String jobName;
    private String jobGroup;
    private String jobDescription;
    private String jobStatus;
    private String cronExpression;
    private String jobExecuteClass;

}

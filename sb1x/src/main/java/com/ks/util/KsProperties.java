package com.ks.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月24日 01:46
 * @Verdion 1.0 版本
 * ${tags}
 */
@Data
@Component
public class KsProperties {

    @Value("${com.ks.title}")
    private String title;
    @Value("${com.ks.description}")
    private String description;
}

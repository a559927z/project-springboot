package com.ks.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Calendar;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月27日 14:32
 * @Verdion 1.0 版本
 * ${tags}
 */
@Data
public class SbMessage {

    private Long id;

    @NotEmpty(message = "Text is required.")
    private String text;

    @NotEmpty(message = "Summary is required.")
    private String summary;

    private Calendar created = Calendar.getInstance();

}

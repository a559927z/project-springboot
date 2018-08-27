package com.ks.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 * maxInactiveIntervalInSeconds: 设置Session失效时间，
 * 使用Redis Session之后，原Boot的server.session.timeout属性不再生效
 *
 * @author jxzhang
 * @DATE 2018年08月27日 11:18
 * @Verdion 1.0 版本
 * ${tags}
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400 * 30)
public class SessionConfig {

}
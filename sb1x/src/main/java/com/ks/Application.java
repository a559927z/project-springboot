package com.ks;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * (一、二)
 * http://www.ityouknow.com/springboot/2016/02/03/spring-boot-web.html
 * (三)
 * http://www.ityouknow.com/springboot/2016/03/06/spring-boot-redis.html
 * (四)
 * http://www.ityouknow.com/springboot/2016/05/01/spring-boot-thymeleaf.html
 * (六)
 * http://www.ityouknow.com/springboot/2016/11/06/spring-boo-mybatis.html
 * <p>
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月27日 16:29
 * @Verdion 1.0 版本
 * ${tags}
 */
@MapperScan("com.ks.mapper")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

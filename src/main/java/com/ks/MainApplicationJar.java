package com.ks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jxzhang on 2018年06月18
 * @Verdion 1.0版本
 */
//@SpringBootApplication(scanBasePackages = {"com.ks"}, exclude = {})
@SpringBootApplication
public class MainApplicationJar {


    public static void main(String[] args) {
        SpringApplication.run(MainApplicationJar.class, args);
    }


}
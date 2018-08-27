package com.ks.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月27日 11:57
 * @Verdion 1.0 版本
 * ${tags}
 */
@RequestMapping("/redis")
@RestController
public class SessionRedisController {


    /**
     * 分布式系统中，sessiong共享有很多的解决方案，其中托管到缓存中应该是最常用的方案之一，
     * http://emacoo.cn/backend/spring-redis/
     * <p>
     * step1 : pom.xml 引用 spring-session-data-redis
     * step2 : 实现SessionConfig类
     * step3 : 简单的请求从httpSession session里设置uid
     * <p>
     * 这里已经完成了把session放上redis里。
     * <p>
     * 只要这请求
     * http://localhost:8080/uid
     * 登录redis 输入 keys '*sessions*'
     *
     * @param session
     * @return
     */
    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

}

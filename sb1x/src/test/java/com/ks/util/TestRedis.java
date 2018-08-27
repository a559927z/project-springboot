package com.ks.util;

import com.ks.dto.SbUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月27日 10:48
 * @Verdion 1.0 版本
 * ${tags}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    /**
     * redisTemplate API
     * https://blog.csdn.net/qq_25135655/article/details/80357137
     *
     * @throws Exception
     */
    @Test
    public void testObj() throws Exception {
        SbUser user = new SbUser("aa@126.com", "aa1", "aa", "aa123456", "123");
        ValueOperations<String, SbUser> operations = redisTemplate.opsForValue();
        //  新增一个字符串类型的值,key是键，value是值。
        operations.set("com.ks.dto", user);
        // 设置变量值的过期时间。 1 秒
        operations.set("com.ks.dto.f", user, 1, TimeUnit.SECONDS);


        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        boolean exists = redisTemplate.hasKey("com.ks.dto.f");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
        Assert.assertEquals("aa", operations.get("com.ks.dto").getUserName());
    }


}
package com.ks.dao;

import com.ks.dto.SbUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userRepository.save(new SbUser("aa@126.com", "aa1", "aa", "aa123456", formattedDate));
        userRepository.save(new SbUser("bb@126.com", "bb2", "bb", "bb123456", formattedDate));
        userRepository.save(new SbUser("cc@126.com", "cc3", "cc", "cc123456", formattedDate));

        Assert.assertEquals(9, userRepository.findAll().size());
        Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "cc@126.com").getNickName());
        userRepository.delete(userRepository.findByUserName("aa"));
    }

}
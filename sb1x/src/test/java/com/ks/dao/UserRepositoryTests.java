package com.ks.dao;

import com.ks.dto.SbUser;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;


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


    /**
     * 基本查询
     *
     * @throws Exception
     */
    @Test
    public void testBaseQuery() throws Exception {
        System.out.println(userRepository.findAll());
        System.out.println(userRepository.findOne(1l));

        SbUser user = new SbUser("test@126.com", "test", "test", "cc123456", "2018-01-01");
        userRepository.save(user);
        userRepository.delete(user);

        System.out.println(userRepository.count());
        System.out.println(userRepository.exists(1l));
    }

    /**
     * 分页查询
     *
     * @throws Exception
     */
    @Test
    public void testPageQuery() throws Exception {
//        Pageable pageable = new PageRequest(1, 20);
//        userRepository.findALL(pageable);
//        int page = 1, size = 2;
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
//        Pageable pageable = new PageRequest(page, size, sort);
//        userRepository.findALL(pageable);
//        userRepository.findByUserName("testName", pageable);
    }
}
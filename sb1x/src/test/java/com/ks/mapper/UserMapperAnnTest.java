package com.ks.mapper;

import com.ks.dto.SbUser;
import com.ks.enums.UserSexEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月28日 23:02
 * @Verdion 1.0 版本
 * ${tags}
 */

@RunWith(SpringRunner.class)
@SpringBootTest //(classes = Application.class)
public class UserMapperAnnTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() throws Exception {
        userMapper.insert(new SbUser("aa", "a123456", UserSexEnum.MAN));
        userMapper.insert(new SbUser("bb", "b123456", UserSexEnum.WOMAN));
        userMapper.insert(new SbUser("cc", "b123456", UserSexEnum.WOMAN));

        Assert.assertEquals(3, userMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<SbUser> users = userMapper.getAll();
        System.out.println(users.toString());
    }


    @Test
    public void testUpdate() throws Exception {
        SbUser user = userMapper.getOne(3l);
        System.out.println(user.toString());
        user.setNickName("ks");
        userMapper.update(user);
        Assert.assertTrue(("ks".equals(userMapper.getOne(3l).getNickName())));
    }
}

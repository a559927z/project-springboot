package com.ks.service.impl;

import com.ks.dao.UserRepository;
import com.ks.dto.SbUser;
import com.ks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月27日 16:35
 * @Verdion 1.0 版本
 * ${tags}
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<SbUser> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public SbUser findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(SbUser user) {
        userRepository.save(user);
    }

    @Override
    public void edit(SbUser user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }
}

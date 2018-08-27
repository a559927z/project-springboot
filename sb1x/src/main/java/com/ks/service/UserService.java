package com.ks.service;

import com.ks.dto.SbUser;

import java.util.List;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月27日 16:34
 * @Verdion 1.0 版本
 * ${tags}
 */
public interface UserService {

    List<SbUser> getUserList();

    SbUser findUserById(long id);

    void save(SbUser user);

    void edit(SbUser user);

    void delete(long id);

}

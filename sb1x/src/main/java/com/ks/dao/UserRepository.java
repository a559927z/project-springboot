package com.ks.dao;

import com.ks.dto.SbUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 * 可以根据方法名来自动的生产SQL，
 * 比如findByUserName 会自动生产一个以 userName 为参数的查询方法，比如 findAlll 自动会查询表里面的所有数据，比如自动分页等等。。
 *
 * @author jxzhang
 * @DATE 2018年08月24日 02:13
 * @Verdion 1.0 版本
 * ${tags}
 */
public interface UserRepository extends JpaRepository<SbUser, Long> {

    SbUser findByUserName(String userName);

    SbUser findByUserNameOrEmail(String username, String email);

    SbUser findById(long id);

    Long deleteById(Long id);


}
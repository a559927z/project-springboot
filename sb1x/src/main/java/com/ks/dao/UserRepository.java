package com.ks.dao;

import com.ks.dto.SbUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 * 可以根据方法名来自动的生产SQL，
 * 比如findByUserName 会自动生产一个以 userName 为参数的查询方法，比如 findAlll 自动会查询表里面的所有数据，比如自动分页等等。。
 * <p>
 * <p>
 * 自定义简单查询
 * 自定义的简单查询就是根据方法名来自动生成SQL，主要的语法是findXXBy,readAXXBy,queryXXBy,countXXBy, getXXBy后面跟属性名称：
 * 也使用一些加一些关键字And、 Or
 * <p>
 * 基本上SQL体系中的关键词都可以使用，例如：LIKE、 IgnoreCase、 OrderBy。
 *
 * @author jxzhang
 * @DATE 2018年08月24日 02:13
 * @Verdion 1.0 版本
 * ${tags}
 */
public interface UserRepository extends JpaRepository<SbUser, Long> {

    /**
     * 主要的语法是findXXBy,readAXXBy,queryXXBy,countXXBy, getXXBy后面跟属性名称
     *
     * @param userName
     * @return
     */
    SbUser findByUserName(String userName);

    SbUser findById(long id);

    Long deleteById(Long id);

    Long countByUserName(String userName);


    /**
     * 一些关键字And、 Or
     */
    SbUser findByUserNameOrEmail(String username, String email);


    //    基本上SQL体系中的关键词都可以使用，例如：LIKE、 IgnoreCase、 OrderBy。
//    List<SbUser> findByEmailLike(String email);
//    SbUser findByUserNameIgnoreCase(String userName);
//    List<SbUser> findByUserNameOrderByEmailDesc(String email);


    /**
     * 分页查询
     * 需要传入参数Pageable ,当查询中有多个参数的时候Pageable建议做为最后一个参数传入
     *
     * @param pageable
     * @return
     */
//    Page<SbUser> findALL(Pageable pageable);
//    Page<SbUser> findByUserName(String userName, Pageable pageable);


    //    限制查询
//    有时候我们只需要查询前N个元素，或者支取前一个实体。
//    SbUser findFirstByOrderByLastnameAsc();
//    SbUser findTopByOrderByAgeDesc();
//    Page<SbUser> queryFirst10ByLastname(String lastname, Pageable pageable);
//    List<SbUser> findFirst10ByLastname(String lastname, Sort sort);
//    List<SbUser> findTop10ByLastname(String lastname, Pageable pageable);


    //    自定义SQL查询
//    在SQL的查询方法上面使用@Query注解，如涉及到删除和修改在需要加上@Modifying.也可以根据需要添加 @Transactional 对事物的支持，查询超时的设置等
//    @Modifying
//    @Query("update SbUser u set u.userName = ?1 where u.id = ?2")
//    int modifyByIdAndUserId(String userName, Long id);
//
//    @Transactional
//    @Modifying
//    @Query("delete from SbUser where id = ?1")
//    void deleteByUserId(Long id);
//
//    @Transactional(timeout = 10)
//    @Query("select u from SbUser u where u.emailAddress = ?1")
//    SbUser findByEmailAddress(String emailAddress);
}
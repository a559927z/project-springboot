package com.ks.mapper;

import com.ks.dto.SbUser;
import com.ks.enums.UserSexEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月28日 22:58
 * @Verdion 1.0 版本
 * ${tags}
 */
//@Mapper
//@Repository
public interface UserMapper {

    @Select("SELECT * FROM sb_user")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    List<SbUser> getAll();

    @Select("SELECT * FROM sb_user WHERE id = #{id}")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    SbUser getOne(Long id);

    @Insert("INSERT INTO sb_user(user_name,password,user_sex) VALUES(#{userName}, #{password}, #{userSex})")
    void insert(SbUser user);

    @Update("UPDATE sb_user SET user_name=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(SbUser user);

    @Delete("DELETE FROM sb_user WHERE id =#{id}")
    void delete(Long id);
}

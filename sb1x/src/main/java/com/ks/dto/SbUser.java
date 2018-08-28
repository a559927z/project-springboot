package com.ks.dto;

import com.ks.enums.UserSexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月24日 01:31
 * @Verdion 1.0 版本
 * ${tags}
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class SbUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = true, unique = true)
    private String nickName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String regTime;

    @Column(nullable = false, unique = true)
    private String userName;

    private int age;

    private UserSexEnum userSex;

    public SbUser(String email, String nickName, String userName, String password, String regTime) {
        super();
        this.email = email;
        this.nickName = nickName;
        this.password = password;
        this.userName = userName;
        this.regTime = regTime;
    }

    public SbUser(String userName, String password, UserSexEnum userSexEnum) {
        super();
        this.userName = userName;
        this.password = password;
        this.userSex = userSexEnum;
    }
}
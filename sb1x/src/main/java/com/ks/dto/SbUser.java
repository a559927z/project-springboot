package com.ks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    private String userName;
    @Column(nullable = false)
    private String passWord;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = true, unique = true)
    private String nickName;
    @Column(nullable = false)
    private String regTime;

    public SbUser(String email, String nickName, String userName, String passWord, String regTime) {
        super();
        this.email = email;
        this.nickName = nickName;
        this.passWord = passWord;
        this.userName = userName;
        this.regTime = regTime;
    }
}
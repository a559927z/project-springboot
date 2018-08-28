package com.ks.mapper;

import com.ks.dto.SbUser;

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
public interface UserXmlMapper {

    List<SbUser> getAll();

    SbUser getOne(Long id);

    void insert(SbUser user);

    void update(SbUser user);

    void delete(Long id);
}

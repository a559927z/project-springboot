package com.ks.dao;

import com.ks.dto.SbMessage;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月27日 14:45
 * @Verdion 1.0 版本
 * ${tags}
 */
public interface MessageRepository {

    Iterable<SbMessage> findAll();

    SbMessage save(SbMessage message);

    SbMessage findMessage(Long id);

    void deleteMessage(Long id);
}

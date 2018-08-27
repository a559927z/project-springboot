package com.ks.dao;

import com.ks.dto.SbMessage;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月27日 15:36
 * @Verdion 1.0 版本
 * ${tags}
 */
public class InMemoryMessageRepository implements MessageRepository {

    private static AtomicLong counter = new AtomicLong();

    private final ConcurrentMap<Long, SbMessage> messages = new ConcurrentHashMap<>();

    @Override
    public Iterable<SbMessage> findAll() {
        return this.messages.values();
    }

    @Override
    public SbMessage save(SbMessage SbMessage) {
        Long id = SbMessage.getId();
        if (id == null) {
            id = counter.incrementAndGet();
            SbMessage.setId(id);
        }
        this.messages.put(id, SbMessage);
        return SbMessage;
    }

    @Override
    public SbMessage findMessage(Long id) {
        return this.messages.get(id);
    }

    @Override
    public void deleteMessage(Long id) {
        this.messages.remove(id);
    }
}

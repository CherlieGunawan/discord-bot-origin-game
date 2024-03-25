package com.cherlie.game.Repository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.cherlie.game.Entity.BuffEntity;

@ApplicationScoped
public class BuffRepository {
    @Transactional
    public BuffEntity fetchBuff(String buffId) {
        return BuffEntity.findById(buffId);
    }
}

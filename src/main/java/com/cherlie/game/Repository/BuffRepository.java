package com.cherlie.game.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import com.cherlie.game.Entity.BuffEntity;

@ApplicationScoped
public class BuffRepository {
    @Transactional
    public BuffEntity fetchBuff(String buffId) {
        return BuffEntity.findById(buffId);
    }
}

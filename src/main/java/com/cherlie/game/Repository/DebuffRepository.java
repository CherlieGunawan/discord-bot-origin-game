package com.cherlie.game.Repository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.cherlie.game.Entity.DebuffEntity;

@ApplicationScoped
public class DebuffRepository {
    @Transactional
    public DebuffEntity fetchDebuff(String debuffId) {
        return DebuffEntity.findById(debuffId);
    }
}

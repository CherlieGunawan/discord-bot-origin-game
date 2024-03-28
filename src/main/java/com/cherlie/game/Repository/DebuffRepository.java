package com.cherlie.game.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import com.cherlie.game.Entity.DebuffEntity;

@ApplicationScoped
public class DebuffRepository {
    @Transactional
    public DebuffEntity fetchDebuff(String debuffId) {
        return DebuffEntity.findById(debuffId);
    }
}

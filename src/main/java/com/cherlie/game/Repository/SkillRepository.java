package com.cherlie.game.Repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.cherlie.game.Entity.SkillEntity;

@ApplicationScoped
public class SkillRepository {
    @Transactional
    public List<SkillEntity> fetchAll() {
        return SkillEntity.listAll();
    }
}

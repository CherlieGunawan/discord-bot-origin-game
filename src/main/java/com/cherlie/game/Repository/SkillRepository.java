package com.cherlie.game.Repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import com.cherlie.game.Entity.SkillBuffEntity;
import com.cherlie.game.Entity.SkillConfigEntity;
import com.cherlie.game.Entity.SkillDebuffEntity;
import com.cherlie.game.Entity.SkillEntity;
import com.cherlie.game.Entity.SkillPrerequisiteEntity;

@ApplicationScoped
public class SkillRepository {
    @Transactional
    public List<SkillEntity> fetchSkills() {
        return SkillEntity.listAll();
    }

    @Transactional
    public List<SkillPrerequisiteEntity> fetchSkillPrerequisites(String skillId) {
        return SkillPrerequisiteEntity.list("skillId = ?1", skillId);
    }

    @Transactional
    public List<SkillConfigEntity> fetchSkillConfigs(String skillId) {
        return SkillConfigEntity.list("skillId = ?1", skillId);
    }

    @Transactional
    public List<SkillBuffEntity> fetchSkillBuffs(String skillId, int triggerOrder) {
        return SkillBuffEntity.list("skillId = ?1 AND triggerOrder = ?2", skillId, triggerOrder);
    }

    @Transactional
    public List<SkillDebuffEntity> fetchSkillDebuffs(String skillId, int triggerOrder) {
        return SkillDebuffEntity.list("skillId = ?1 AND triggerOrder = ?2", skillId, triggerOrder);
    }
}

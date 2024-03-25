package com.cherlie.game.Repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

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
        return SkillPrerequisiteEntity.list("skill_id = ?1", skillId);
    }

    @Transactional
    public List<SkillConfigEntity> fetchSkillConfigs(String skillId) {
        return SkillConfigEntity.list("skill_id = ?1", skillId);
    }

    @Transactional
    public List<SkillBuffEntity> fetchSkillBuffs(String skillId, int triggerOrder) {
        return SkillBuffEntity.list("skill_id = ?1 AND trigger_order = ?2", skillId, triggerOrder);
    }

    @Transactional
    public List<SkillDebuffEntity> fetchSkillDebuffs(String skillId, int triggerOrder) {
        return SkillDebuffEntity.list("skill_id = ?1 AND trigger_order = ?2", skillId, triggerOrder);
    }
}

package com.cherlie.game.Service.Entity;

import java.util.HashMap;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.cherlie.game.Entity.SkillBuffEntity;
import com.cherlie.game.Entity.SkillConfigEntity;
import com.cherlie.game.Entity.SkillDebuffEntity;
import com.cherlie.game.Entity.SkillEntity;
import com.cherlie.game.Global.GlobalVariable;
import com.cherlie.game.Model.SkillBuffModel;
import com.cherlie.game.Model.SkillConfigModel;
import com.cherlie.game.Model.SkillDebuffModel;
import com.cherlie.game.Model.SkillModel;
import com.cherlie.game.Repository.BuffRepository;
import com.cherlie.game.Repository.DebuffRepository;
import com.cherlie.game.Repository.SkillRepository;

@ApplicationScoped
public class SkillService {
    @Inject
    SkillRepository skillRepository;

    @Inject
    BuffRepository buffRepository;

    @Inject
    DebuffRepository debuffRepository;

    public void initialize() {
        List<SkillEntity> skillEntities = skillRepository.fetchSkills();
        HashMap<String, SkillModel> skills = new HashMap<>();
        for(SkillEntity skillEntity : skillEntities) {
            List<SkillConfigEntity> skillConfigEntities = skillRepository.fetchSkillConfigs(skillEntity.id);
            List<SkillConfigModel> skillConfigs = List.of();
            for(SkillConfigEntity skillConfigEntity : skillConfigEntities) {
                List<SkillBuffEntity> skillBuffEntities = skillRepository.fetchSkillBuffs(skillConfigEntity.skillId, skillConfigEntity.triggerOrder);
                List<SkillBuffModel> skillBuffs = List.of();
                for(SkillBuffEntity skillBuffEntity : skillBuffEntities) {
                    skillBuffs.add(new SkillBuffModel(skillBuffEntity, buffRepository.fetchBuff(skillBuffEntity.buffId)));
                }
                
                List<SkillDebuffEntity> skillDebuffEntities = skillRepository.fetchSkillDebuffs(skillConfigEntity.skillId, skillConfigEntity.triggerOrder);
                List<SkillDebuffModel> skillDebuffs = List.of();
                for(SkillDebuffEntity skillDebuffEntity : skillDebuffEntities) {
                    skillDebuffs.add(new SkillDebuffModel(skillDebuffEntity, debuffRepository.fetchDebuff(skillDebuffEntity.debuffId)));
                }

                skillConfigs.add(new SkillConfigModel(skillConfigEntity, skillBuffs, skillDebuffs));
            }
            
            skills.put(skillEntity.id, new SkillModel(skillEntity, skillConfigs, skillRepository.fetchSkillPrerequisites(skillEntity.id)));
        }

        GlobalVariable.skills = skills;
    }
}

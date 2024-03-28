package com.cherlie.game.Service.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.cherlie.game.Entity.SkillBuffEntity;
import com.cherlie.game.Entity.SkillConfigEntity;
import com.cherlie.game.Entity.SkillDebuffEntity;
import com.cherlie.game.Entity.SkillEntity;
import com.cherlie.game.Entity.SkillPrerequisiteEntity;
import com.cherlie.game.Global.GlobalVariable;
import com.cherlie.game.Model.SkillBuffModel;
import com.cherlie.game.Model.SkillConfigModel;
import com.cherlie.game.Model.SkillDebuffModel;
import com.cherlie.game.Model.SkillModel;
import com.cherlie.game.Model.Custom.SkillTreeModel;
import com.cherlie.game.Repository.BuffRepository;
import com.cherlie.game.Repository.DebuffRepository;
import com.cherlie.game.Repository.SkillRepository;

import io.vertx.core.json.JsonObject;

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
        HashMap<String, SkillTreeModel> skillTreeEntities = new HashMap<>();
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
            
            List<SkillPrerequisiteEntity> prerequisites = skillRepository.fetchSkillPrerequisites(skillEntity.id);
            skills.put(skillEntity.id, new SkillModel(skillEntity, skillConfigs, prerequisites));
            saveSkillTree(skillTreeEntities, skillEntity.id, null, prerequisites);
        }

        GlobalVariable.skills = skills;
        GlobalVariable.skillTreeEntities = skillTreeEntities;
    }

    private void saveSkillTree(HashMap<String, SkillTreeModel> skillTreeEntities, String skillId, String nextSkillId, List<SkillPrerequisiteEntity> prerequisites) {
        SkillTreeModel skillTreeEntity;
        if(skillTreeEntities.containsKey(skillId))
            skillTreeEntity = skillTreeEntities.get(skillId);
        else
            skillTreeEntity = new SkillTreeModel(skillId);

        if(!prerequisites.isEmpty()) {
            List<String> prerequisiteIds = getPrerequisiteIds(prerequisites);
            skillTreeEntity.previousSkillIds = prerequisiteIds;
            for(String prerequisiteId : prerequisiteIds) {
                saveSkillTree(skillTreeEntities, prerequisiteId, skillId, new ArrayList<>());
            }
        }

        if(nextSkillId != null)
            skillTreeEntity.nextSkillIds.add(nextSkillId);

        skillTreeEntities.put(skillId, skillTreeEntity);
    }

    private List<String> getPrerequisiteIds(List<SkillPrerequisiteEntity> prerequisites) {
        List<String> prerequisiteIds = new ArrayList<>();
        for(SkillPrerequisiteEntity prerequisite: prerequisites) {
            prerequisiteIds.add(prerequisite.prerequisiteId);
        }

        return prerequisiteIds;
    }

    // public List<SkillModel> getLearnables() {
        
    // }
}

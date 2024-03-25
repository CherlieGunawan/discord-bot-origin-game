package com.cherlie.game.Model;

import java.util.List;

import com.cherlie.game.Entity.SkillEntity;
import com.cherlie.game.Entity.SkillPrerequisiteEntity;

public class SkillModel {
    public SkillEntity skill;
    public List<SkillConfigModel> skillConfigs;
    public List<SkillPrerequisiteEntity> prerequisites;

    public SkillModel(SkillEntity skill, List<SkillConfigModel> skillConfigs, List<SkillPrerequisiteEntity> prerequisites) {
        this.skill = skill;
        this.skillConfigs = skillConfigs;
        this.prerequisites = prerequisites;
    }
}

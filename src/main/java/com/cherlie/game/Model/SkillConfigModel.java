package com.cherlie.game.Model;

import java.util.List;

import com.cherlie.game.Entity.SkillConfigEntity;

public class SkillConfigModel {
    public SkillConfigEntity skillConfig;
    public List<SkillBuffModel> skillBuffs;
    public List<SkillDebuffModel> skillDebuffs;

    public SkillConfigModel(SkillConfigEntity skillConfig, List<SkillBuffModel> skillBuffs, List<SkillDebuffModel> skillDebuffs) {
        this.skillConfig = skillConfig;
        this.skillBuffs = skillBuffs;
        this.skillDebuffs = skillDebuffs;
    }
}

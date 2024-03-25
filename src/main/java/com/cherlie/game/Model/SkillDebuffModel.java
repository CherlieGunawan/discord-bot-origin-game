package com.cherlie.game.Model;

import com.cherlie.game.Entity.DebuffEntity;
import com.cherlie.game.Entity.SkillDebuffEntity;

public class SkillDebuffModel {
    public SkillDebuffEntity skillDebuff;
    public DebuffEntity debuff;

    public SkillDebuffModel(SkillDebuffEntity skillDebuff, DebuffEntity debuff) {
        this.skillDebuff = skillDebuff;
        this.debuff = debuff;
    }
}

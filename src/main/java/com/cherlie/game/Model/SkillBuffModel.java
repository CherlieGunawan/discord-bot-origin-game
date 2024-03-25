package com.cherlie.game.Model;

import com.cherlie.game.Entity.BuffEntity;
import com.cherlie.game.Entity.SkillBuffEntity;

public class SkillBuffModel {
    public SkillBuffEntity skillBuff;
    public BuffEntity buff;

    public SkillBuffModel(SkillBuffEntity skillBuff, BuffEntity buff) {
        this.skillBuff = skillBuff;
        this.buff = buff;
    }
}

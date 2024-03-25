package com.cherlie.game.Entity.CompositeKeys;

import java.io.Serializable;

public class SkillStackKey implements Serializable {
    private String skillId;
    private String stackId;

    public SkillStackKey() {}

    public SkillStackKey(String skillId, String stackId) {
        this.skillId = skillId;
        this.stackId = stackId;
    }
}

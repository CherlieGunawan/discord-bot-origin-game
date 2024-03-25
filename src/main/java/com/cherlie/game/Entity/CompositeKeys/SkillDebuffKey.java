package com.cherlie.game.Entity.CompositeKeys;

import java.io.Serializable;

public class SkillDebuffKey implements Serializable {
    private String skillId;
    private int triggerOrder;
    private String debuffId;

    public SkillDebuffKey() {}

    public SkillDebuffKey(String skillId, int triggerOrder, String debuffId) {
        this.skillId = skillId;
        this.triggerOrder = triggerOrder;
        this.debuffId = debuffId;
    }
}

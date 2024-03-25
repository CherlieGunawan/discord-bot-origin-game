package com.cherlie.game.Entity.CompositeKeys;

import java.io.Serializable;

public class SkillConfigKey implements Serializable {
    private String skillId;
    private int triggerOrder;

    public SkillConfigKey() {}

    public SkillConfigKey(String skillId, int triggerOrder) {
        this.skillId = skillId;
        this.triggerOrder = triggerOrder;
    }
}

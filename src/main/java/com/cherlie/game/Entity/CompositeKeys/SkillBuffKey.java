package com.cherlie.game.Entity.CompositeKeys;

import java.io.Serializable;

public class SkillBuffKey implements Serializable {
    private String skillId;
    private int triggerOrder;
    private String buffId;

    public SkillBuffKey() {}

    public SkillBuffKey(String skillId, int triggerOrder, String buffId) {
        this.skillId = skillId;
        this.triggerOrder = triggerOrder;
        this.buffId = buffId;
    }
}

package com.cherlie.game.Entity.CompositeKeys;

import java.io.Serializable;

public class StackSkillTriggerKey implements Serializable {
    private String stackId;
    private int triggerOrder;
    private String triggerSkillId;

    public StackSkillTriggerKey() {}

    public StackSkillTriggerKey(String stackId, int triggerOrder, String triggerSkillId) {
        this.stackId = stackId;
        this.triggerOrder = triggerOrder;
        this.triggerSkillId = triggerSkillId;
    }
}

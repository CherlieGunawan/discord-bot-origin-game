package com.cherlie.game.Entity.CompositeKeys;

import java.io.Serializable;

public class SkillPrerequisiteKey implements Serializable {
    private String skillId;
    private String prerequisiteId;

    public SkillPrerequisiteKey() {}

    public SkillPrerequisiteKey(String skillId, String prerequisiteId) {
        this.skillId = skillId;
        this.prerequisiteId = prerequisiteId;
    }
}

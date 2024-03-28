package com.cherlie.game.Model.Custom;

import java.util.ArrayList;
import java.util.List;

public class SkillTreeModel {
    public String skillId;
    public List<String> previousSkillIds;
    public List<String> nextSkillIds;

    public SkillTreeModel(String skillId) {
        this.skillId = skillId;
        this.previousSkillIds = new ArrayList<>();
        this.nextSkillIds = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "SkillTreeModel [skillId=" + skillId + ", previousSkillIds=" + previousSkillIds + ", nextSkillIds="
                + nextSkillIds + "]";
    }
}

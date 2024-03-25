package com.cherlie.game.Entity.CompositeKeys;

import java.io.Serializable;

public class PlayerSkillKey implements Serializable {
    private String playerId;
    private String skillId;

    public PlayerSkillKey() {}

    public PlayerSkillKey(String playerId, String skillId) {
        this.playerId = playerId;
        this.skillId = skillId;
    }
}

package com.cherlie.game.Model;

import java.util.List;

import com.cherlie.game.Entity.PlayerEntity;
import com.cherlie.game.Entity.PlayerSkillEntity;

public class PlayerModel {
    public PlayerEntity player;
    public List<PlayerSkillEntity> playerSkills;

    public PlayerModel(PlayerEntity player, List<PlayerSkillEntity> playerSkills) {
        this.player = player;
        this.playerSkills = playerSkills;
    }
}
package com.cherlie.game.Repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import com.cherlie.game.Entity.PlayerEntity;
import com.cherlie.game.Entity.PlayerSkillEntity;

@ApplicationScoped
public class PlayerRepository {
    @Transactional
    public PlayerEntity fetchPlayer(String playerId) {
        return PlayerEntity.findById(playerId);
    }

    @Transactional
    public List<PlayerSkillEntity> fetchPlayerSkills(String playerId) {
        return PlayerSkillEntity.list("playerId = ?1", playerId);
    }

    @Transactional
    public PlayerEntity save(String playerId, String name) {
        PlayerEntity player = new PlayerEntity();
        player.id = playerId;
        player.name = name;
        player.level = 1;
        player.statusPoint = 0;
        player.skillPoint = 0;
        player.strength = 1;
        player.intelligence = 1;
        player.vitality = 1;
        player.agility = 1;
        player.dexterity = 1;

        player.persist();

        return player;
    }
}

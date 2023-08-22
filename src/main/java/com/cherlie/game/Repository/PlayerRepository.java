package com.cherlie.game.Repository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.cherlie.game.Constant.ConstantVariable;
import com.cherlie.game.Entity.PlayerEntity;

@ApplicationScoped
public class PlayerRepository {
    @Transactional
    public PlayerEntity fetch(String playerId) {
        return PlayerEntity.findById(playerId);
    }

    @Transactional
    public PlayerEntity save(String playerId, String name) {
        PlayerEntity player = new PlayerEntity();
        player.playerId = playerId;
        
        player.skillsString = ConstantVariable.EMPTY_JSON_STRING;
        player.equipmentsString = ConstantVariable.EMPTY_JSON_STRING;
        
        player.name = name;
        player.level = 1;
        
        player.statusPoints = 0;
        player.skillPoints = 0;

        player.strength = 1;
        player.intelligence = 1;
        player.agility = 1;
        player.dexterity = 1;
        player.vitality = 1;

        player.persist();

        return player;
    }
}

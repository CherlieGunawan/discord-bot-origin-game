package com.cherlie.game.Service.Entity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.cherlie.game.Entity.PlayerEntity;
import com.cherlie.game.Global.ConstantVariable;
import com.cherlie.game.Model.PlayerModel;

@ApplicationScoped
public class PlayerService {
    @Transactional
    public PlayerModel savePlayer(String playerId, String name) {
        PlayerEntity player = new PlayerEntity();
        player.playerId = playerId;
        
        player.skillsString = ConstantVariable.emptyJson;
        player.equipmentsString = ConstantVariable.emptyJson;
        
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

        return new PlayerModel(player);
    }
}

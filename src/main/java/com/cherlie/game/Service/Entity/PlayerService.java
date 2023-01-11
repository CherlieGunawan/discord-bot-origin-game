package com.cherlie.game.Service.Entity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.cherlie.game.Model.PlayerModel;
import com.cherlie.game.Repository.PlayerRepository;

@ApplicationScoped
public class PlayerService {
    @Inject
    PlayerRepository playerRepository;

    @Transactional
    public PlayerModel savePlayer(String playerId, String name) {
        return new PlayerModel(playerRepository.save(playerId, name));
    }
}

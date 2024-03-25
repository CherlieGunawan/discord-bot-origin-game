package com.cherlie.game.Service.Game;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.cherlie.game.Entity.PlayerSkillEntity;
import com.cherlie.game.Global.GlobalFunction;
import com.cherlie.game.Global.GlobalVariable;
import com.cherlie.game.Model.PlayerModel;
import com.cherlie.game.Service.Discord.MessageService;
import com.cherlie.game.Service.Entity.PlayerService;

import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.channel.MessageChannel;
import io.quarkus.arc.ArcUndeclaredThrowableException;

@ApplicationScoped
public class GameService {
    @Inject
    MessageService messageService;

    @Inject
    ServerService serverService;

    @Inject
    PlayerService playerService;

    public void initialize(Guild guild, MessageChannel channel) {
        boolean serverInit = false;

        if(GlobalVariable.channelsList.containsKey(guild.getId().asString())) {
            messageService.sendMessage(messageService.formatCodeBlock("Skipping server initialization"), channel);
            serverInit = true;
        }
        else {
            messageService.sendMessage(messageService.formatCodeBlock("Initializing server..."), channel);
            serverInit = serverService.initialize(guild, channel);
            
            if(serverInit)
                messageService.sendMessage(messageService.formatCodeBlock("Server initialized"), channel);
            else {
                messageService.sendMessage(messageService.formatCodeBlock("Failed to initialize server"), channel);
    
                return;
            }
        }
        
        // init others

        messageService.sendMessage(messageService.formatCodeBlock("Game is ready"), channel);
    }

    public void register(String id, String name, MessageChannel channel) {
        messageService.sendMessage(messageService.formatQuote("Registering player..."), channel);
        
        try {
            playerService.savePlayer(id, name);
        }
        catch(ArcUndeclaredThrowableException ex) {
            if(GlobalFunction.isOfException(ex, "ConstraintViolationException"))
                messageService.sendMessage(messageService.formatQuote("You're already registered!"), channel);
            else
                messageService.sendMessage(messageService.formatCodeBlock("Sorry, it seems like there's something wrong with the server right now"), channel); //TODO: Save to db log

            return;
        }

        messageService.sendMessage(messageService.formatQuote("Successfully registered ".concat(messageService.formatBold(name)).concat(", welcome to the game")), channel);
    }

    public void fetchPlayerStatus(String playerId, MessageChannel channel) {
        messageService.sendMessage(messageService.formatQuote("Fetching status..."), channel);
        
        try {
            PlayerModel player = playerService.fetchPlayer(playerId);

            String message = "Skills:\n";
            for(PlayerSkillEntity playerSkillEntity : player.playerSkills) {
                message += playerSkillEntity.skillId + "\n";
            }

            messageService.sendMessage(message, channel);
        }
        catch(ArcUndeclaredThrowableException ex) {
            if(GlobalFunction.isOfException(ex, "ConstraintViolationException"))
                messageService.sendMessage(messageService.formatQuote("You're already registered!"), channel);
            else
                messageService.sendMessage(messageService.formatCodeBlock("Sorry, it seems like there's something wrong with the server right now"), channel); //TODO: Save to db log

            return;
        }
    }
}

package com.cherlie.game.Service.Game;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.HashMap;
import java.util.Map;

import com.cherlie.game.Entity.PlayerSkillEntity;
import com.cherlie.game.Global.GlobalFunction;
import com.cherlie.game.Global.GlobalVariable;
import com.cherlie.game.Model.PlayerModel;
import com.cherlie.game.Model.Custom.SkillTreeModel;
import com.cherlie.game.Service.Discord.MessageService;
import com.cherlie.game.Service.Entity.PlayerService;
import com.cherlie.game.Util.MessageUtil;

import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.channel.MessageChannel;
import io.quarkus.arc.ArcUndeclaredThrowableException;

@ApplicationScoped
public class GameService {
    @Inject
    MessageService messageService;

    @Inject
    MessageUtil messageUtil;

    @Inject
    ServerService serverService;

    @Inject
    PlayerService playerService;

    public void initialize(Guild guild, MessageChannel channel) {
        boolean serverInit = false;

        if(GlobalVariable.channelsList.containsKey(guild.getId().asString())) {
            messageService.sendMessage(messageUtil.formatCodeBlock("Skipping server initialization"), channel);
            serverInit = true;
        }
        else {
            messageService.sendMessage(messageUtil.formatCodeBlock("Initializing server..."), channel);
            serverInit = serverService.initialize(guild, channel);
            
            if(serverInit)
                messageService.sendMessage(messageUtil.formatCodeBlock("Server initialized"), channel);
            else {
                messageService.sendMessage(messageUtil.formatCodeBlock("Failed to initialize server"), channel);
    
                return;
            }
        }
        
        // init others

        messageService.sendMessage(messageUtil.formatCodeBlock("Game is ready"), channel);
    }

    public void register(String id, String name, MessageChannel channel) {
        messageService.sendMessage(messageUtil.formatQuote("Registering player..."), channel);
        
        try {
            playerService.savePlayer(id, name);
        }
        catch(ArcUndeclaredThrowableException ex) {
            if(GlobalFunction.isOfException(ex, "ConstraintViolationException"))
                messageService.sendMessage(messageUtil.formatQuote("You're already registered!"), channel);
            else
                messageService.sendMessage(messageUtil.formatCodeBlock("Sorry, it seems like there's something wrong with the server right now"), channel); //TODO: Save to db log

            return;
        }

        messageService.sendMessage(messageUtil.formatQuote("Successfully registered ".concat(messageUtil.formatBold(name)).concat(", welcome to the game")), channel);
    }

    public void fetchPlayerStatus(String playerId, MessageChannel channel) {
        messageService.sendMessage(messageUtil.formatQuote("Fetching status..."), channel);
        
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
                messageService.sendMessage(messageUtil.formatQuote("You're already registered!"), channel);
            else
                messageService.sendMessage(messageUtil.formatCodeBlock("Sorry, it seems like there's something wrong with the server right now"), channel); //TODO: Save to db log

            return;
        }
    }

    public void fetchSkillTree(MessageChannel channel) {
        messageService.sendMessage(messageUtil.formatQuote("Fetching skill tree..."), channel);
        
        try {
            String message = "Skill Tree:\n";
            for(Map.Entry<String, SkillTreeModel> entry : GlobalVariable.skillTreeEntities.entrySet()) {
                message += entry.getKey() + ": " + entry.getValue() + "\n";
            }

            messageService.sendMessage(message, channel);
        }
        catch(ArcUndeclaredThrowableException ex) {
            if(GlobalFunction.isOfException(ex, "ConstraintViolationException"))
                messageService.sendMessage(messageUtil.formatQuote("You're already registered!"), channel);
            else
                messageService.sendMessage(messageUtil.formatCodeBlock("Sorry, it seems like there's something wrong with the server right now"), channel); //TODO: Save to db log

            return;
        }
    }
}

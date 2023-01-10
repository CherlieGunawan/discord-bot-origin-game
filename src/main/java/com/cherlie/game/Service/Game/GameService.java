package com.cherlie.game.Service.Game;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.cherlie.game.Global.GlobalVariable;
import com.cherlie.game.Service.Discord.MessageService;

import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.channel.MessageChannel;

@ApplicationScoped
public class GameService {
    @Inject
    MessageService messageService;

    @Inject
    ServerService serverService;

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
}

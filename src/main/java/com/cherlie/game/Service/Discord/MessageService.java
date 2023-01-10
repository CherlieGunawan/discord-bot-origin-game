package com.cherlie.game.Service.Discord;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.cherlie.game.Global.GlobalVariable;
import com.cherlie.game.Service.Game.GameService;

import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import reactor.core.publisher.Mono;

@ApplicationScoped
public class MessageService {
    @Inject
    GameService gameService;

    public Mono<Object> handleMessage(Message message) {
        if(!message.getAuthor().get().getDiscriminator().equals(GlobalVariable.selfDiscriminator)) {
            processMessage(message);
            return Mono.empty();
        }
        else
            return Mono.empty();
    }

    public void processMessage(Message message) {
        String messageString = message.getContent();

        if(messageString.equalsIgnoreCase("init") || messageString.equalsIgnoreCase("initialize")) {
            Guild guild = message.getGuild().block();
            MessageChannel channel = message.getChannel().block();

            gameService.initialize(guild, channel);
        }
        else if(messageString.startsWith("register ")) {
            MessageChannel channel = message.getChannel().block();

            String name = messageString.split("register ")[1];
            if(name.isBlank()) {
                sendMessage("Name can't be empty\n".concat(formatQuote("Command: 'register <name>'")), channel);
                return;
            }
            
            String id = message.getAuthorAsMember().block().getId().asString();
            
            gameService.register(id, name, channel);
        }
    }

    public String formatCodeBlock(String message) {
        return "```".concat(message).concat("```");
    }

    public String formatCodeLine(String message) {
        return "`".concat(message).concat("`");
    }

    public String formatQuote(String message) {
        return "> ".concat(message);
    }

    public String formatBold(String message) {
        return "**".concat(message).concat("**");
    }

    public String formatItalic(String message) {
        return "*".concat(message).concat("*");
    }

    public String formatUnderline(String message) {
        return "__".concat(message).concat("__");
    }

    public void sendMessage(String message, Mono<MessageChannel> channel) {
        channel.flatMap(channelVar -> channelVar.createMessage(message)).subscribe();
    }

    public void sendMessage(String message, MessageChannel channel) {
        channel.createMessage(message).subscribe();
    }
}

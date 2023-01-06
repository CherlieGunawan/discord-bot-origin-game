package com.cherlie.game.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.cherlie.game.Global.GlobalVariable;

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
        Mono<MessageChannel> channel = message.getChannel();

        if(messageString.equalsIgnoreCase("start"))
            sendMessage("AAA", channel);
        else if(messageString.equalsIgnoreCase("init") || messageString.equalsIgnoreCase("initialize")) {
            Mono<Guild> messageGuild = message.getGuild();
            Mono<MessageChannel> messageChannel = message.getChannel();

            gameService.initialize(messageGuild, messageChannel);
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

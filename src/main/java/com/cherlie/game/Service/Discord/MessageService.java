package com.cherlie.game.Service.Discord;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.cherlie.game.Constant.ConstantVariable;
import com.cherlie.game.Global.GlobalVariable;
import com.cherlie.game.Service.Game.GameService;
import com.cherlie.game.Service.Game.Menu.MenuService;

import discord4j.core.object.component.LayoutComponent;
import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import reactor.core.publisher.Mono;

@ApplicationScoped
public class MessageService {
    @Inject
    GameService gameService;

    @Inject
    ButtonService buttonService;

    @Inject
    MenuService menuService;

    public Mono<Object> handleMessage(Message message) {
        if(message.getAuthor().isPresent() && !message.getAuthor().get().getDiscriminator().equals(GlobalVariable.selfDiscriminator)) {
            processMessage(message);
            return Mono.empty();
        }
        else
            return Mono.empty();
    }

    public void processMessage(Message message) {
        Guild guild = message.getGuild().block();
        MessageChannel channel = message.getChannel().block();
        Member author = message.getAuthorAsMember().block();
        
        String messageString = message.getContent();

        if(messageString.equalsIgnoreCase("init") || messageString.equalsIgnoreCase("initialize")) {
            gameService.initialize(guild, channel);
        }
        else if(messageString.startsWith("register ")) {
            String name = messageString.split("register ")[1];
            String id = message.getAuthorAsMember().block().getId().asString();
            
            gameService.register(id, name, channel);
        }
        // TODO: Delete, for testing only
        else if(messageString.equals("test button")) {
            sendButton("Test Buttons", menuService.createButtons(ConstantVariable.BUTTON_TYPE_MAIN, author.getId().asString()), channel);
        }
    }

    public void sendMessage(String message, MessageChannel channel) {
        channel.createMessage(message).subscribe();
    }

    public void sendButton(String message, List<LayoutComponent> buttons, MessageChannel channel) {
        channel.createMessage(message).withComponents(buttons).subscribe();
    }

    // Legacy functions
    public void sendMessage(String message, Mono<MessageChannel> channel) {
        channel.flatMap(channelVar -> channelVar.createMessage(message)).subscribe();
    }
}

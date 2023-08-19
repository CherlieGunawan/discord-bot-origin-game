package com.cherlie.game.Service.Discord;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.cherlie.game.Global.GlobalVariable;
import com.cherlie.game.Service.Game.GameService;

import discord4j.core.object.component.ActionRow;
import discord4j.core.object.component.Button;
import discord4j.core.object.component.LayoutComponent;
import discord4j.core.object.component.SelectMenu;
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
            String id = message.getAuthorAsMember().block().getId().asString();
            
            gameService.register(id, name, channel);
        }
    }

    public void sendMessage(String message, MessageChannel channel) {
        channel.createMessage(message).subscribe();
    }

    public void sendButton(String message, MessageChannel channel) {
        Button button1 = Button.secondary("id-test1", "Test Button 1");
        Button button2 = Button.secondary("id-test2", "Test Button 2");
        Button button3 = Button.secondary("id-test3", "Test Button 3");
        Button button4 = Button.secondary("id-test4", "Test Button 4");
        Button button5 = Button.secondary("id-test5", "Test Button 5");
        List<Button> row1 = new ArrayList<>();
        row1.add(button1);
        row1.add(button2);
        List<Button> row2 = new ArrayList<>();
        row2.add(button3);
        row2.add(button4);

        ActionRow actRow1 = ActionRow.of(row1);
        ActionRow actRow2 = ActionRow.of(row2);

        List<ActionRow> actRows = new ArrayList<>();
        actRows.add(actRow1);
        actRows.add(actRow2);

        //===
        SelectMenu selectMenu = SelectMenu.of("select-id",
            SelectMenu.Option.of("menu 1", "menu1"),
            SelectMenu.Option.of("menu 2", "menu2")
        );
        //===

        List<LayoutComponent> layoutComponents = new ArrayList<>();
        layoutComponents.add(actRow1);
        layoutComponents.add(actRow2);

        channel.createMessage(message).withComponents(layoutComponents).subscribe();
    }



    // Legacy functions
    public void sendMessage(String message, Mono<MessageChannel> channel) {
        channel.flatMap(channelVar -> channelVar.createMessage(message)).subscribe();
    }
}

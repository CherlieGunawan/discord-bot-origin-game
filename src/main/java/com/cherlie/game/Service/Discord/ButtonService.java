package com.cherlie.game.Service.Discord;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.cherlie.game.Constant.ConstantVariable;
import com.cherlie.game.Service.Game.Menu.MenuService;

import discord4j.common.util.Snowflake;
import discord4j.core.event.domain.interaction.ButtonInteractionEvent;
import discord4j.core.object.command.Interaction;
import discord4j.core.object.component.ActionRow;
import discord4j.core.object.component.Button;
import discord4j.core.object.component.LayoutComponent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import io.vertx.core.json.JsonObject;
import reactor.core.publisher.Mono;

@ApplicationScoped
public class ButtonService {
    @Inject
    MessageService messageService;

    @Inject
    MenuService menuService;

    public Mono<Void> handleButton(ButtonInteractionEvent event) {
        Interaction interaction = event.getInteraction();

        String messageId = interaction.getData().message().get().id().asString();

        MessageChannel channel = interaction.getChannel().block();
        Mono<Message> message = channel.getMessageById(Snowflake.of(messageId));

        JsonObject buttonData = new JsonObject(interaction.getData().data().get().customId().get());

        String interactorId = interaction.getData().member().get().user().id().asString();
        String targetPlayerId = buttonData.getString("playerId");

        if(!targetPlayerId.equals(interactorId)) {
            return event.reply("It's not your turn yet!").withEphemeral(true);
        }

        message.block().delete().subscribe();

        String buttonId = buttonData.getString("buttonId");

        if(buttonId.equals("attack")) {
            List<LayoutComponent> buttons = menuService.createButtons(ConstantVariable.BUTTON_TYPE_ATTACK, interactorId);
            messageService.sendButton("Test Attack Buttons", buttons, channel);
        }
        else {
            messageService.sendMessage("Interaction not yet available", channel);
        }

        return Mono.empty();
    }

    public List<ActionRow> createRows(List<Button> buttons, int columns) {
        List<ActionRow> rows = new ArrayList<>();
        List<Button> row = new ArrayList<>();

        for(int i = 0; i < buttons.size(); i++) {
            if(row.size() >= columns) {
                rows.add(ActionRow.of(row));
                row.clear();
            }

            row.add(buttons.get(i));
        }

        if(row.size() > 0) {
            rows.add(ActionRow.of(row));
        }

        return rows;
    }
}

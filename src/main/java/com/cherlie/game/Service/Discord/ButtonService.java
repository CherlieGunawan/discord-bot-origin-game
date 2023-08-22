package com.cherlie.game.Service.Discord;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import discord4j.common.util.Snowflake;
import discord4j.core.event.domain.interaction.ButtonInteractionEvent;
import discord4j.core.object.command.Interaction;
import discord4j.core.object.component.ActionRow;
import discord4j.core.object.component.Button;
import discord4j.core.object.component.LayoutComponent;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import io.vertx.core.json.JsonObject;
import reactor.core.publisher.Mono;

@ApplicationScoped
public class ButtonService {
    @Inject
    MessageService messageService;

    @Inject
    ButtonService buttonService;

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
            List<LayoutComponent> buttons = buttonService.createAttackButtons(interactorId);
            messageService.sendButton("Test Attack Buttons", buttons, channel);
        }
        else {
            messageService.sendMessage("Interaction not yet available", channel);
        }
        
        return Mono.empty();
    }

    public List<LayoutComponent> createMainButtons(String playerId) {
        List<Button> buttons = new ArrayList<>();
        buttons.add(craftSecondaryButton("attack", playerId, "Attack"));
        buttons.add(craftSecondaryButton("skill", playerId, "Skill"));
        buttons.add(craftSecondaryButton("item", playerId, "Item"));
        buttons.add(craftSecondaryButton("defend", playerId, "Defend"));

        List<ActionRow> rows = createRows(buttons, 2);
        List<LayoutComponent> layout = new ArrayList<>();
        for(int i = 0; i < rows.size(); i++) {
            layout.add(rows.get(i));
        }

        return layout;
    }

    public List<LayoutComponent> createAttackButtons(String playerId) {
        List<Button> buttons = new ArrayList<>();
        buttons.add(craftSecondaryButton("Target 1", playerId, "monsterId1"));
        buttons.add(craftSecondaryButton("Target 2", playerId, "monsterId2"));
        buttons.add(craftSecondaryButton("Target 3", playerId, "monsterId3"));

        List<ActionRow> rows = createRows(buttons, 2);
        List<LayoutComponent> layout = new ArrayList<>();
        for(int i = 0; i < rows.size(); i++) {
            layout.add(rows.get(i));
        }

        return layout;
    }

    private List<ActionRow> createRows(List<Button> buttons, int columns) {
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

    private Button craftSecondaryButton(String buttonId, String playerId, String label) {
        JsonObject jsonId = new JsonObject();
        jsonId.put("buttonId", buttonId);
        jsonId.put("playerId", playerId);

        return Button.secondary(jsonId.encode(), label);
    }
}

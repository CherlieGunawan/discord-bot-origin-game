package com.cherlie.game.Service.Discord;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import discord4j.core.object.command.Interaction;
import discord4j.core.object.component.ActionRow;
import discord4j.core.object.component.Button;
import discord4j.core.object.component.LayoutComponent;
import io.vertx.core.json.JsonObject;
import reactor.core.publisher.Mono;

@ApplicationScoped
public class ButtonService {
    @Inject
    MessageService messageService;

    public Mono<Object> handleButton(Interaction interaction) {
        // messageService.sendMessage(interaction.toString(), interaction.getChannel().block());
        // messageService.sendMessage(interaction.getMember().get().toString(), interaction.getChannel().block());
        messageService.sendMessage(interaction.getMember().get().getNickname().get(), interaction.getChannel().block());
        // messageService.sendMessage(interaction.getMessage().get().getContent(), interaction.getChannel().block());
        return Mono.empty();
    }

    public List<LayoutComponent> createMainButtons(String playerId) {
        List<Button> buttons = new ArrayList<>();
        buttons.add(craftSecondaryButton("attack", playerId, "Attack"));
        buttons.add(craftSecondaryButton("skill", playerId, "Skill"));
        buttons.add(craftSecondaryButton("item", playerId, "Item"));
        buttons.add(craftSecondaryButton("defend", playerId, "Defend"));

        List<ActionRow> rows = createRows(buttons, 4);
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

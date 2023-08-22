package com.cherlie.game.Service.Game.Menu;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.cherlie.game.Service.Discord.ButtonService;
import com.cherlie.game.Util.ButtonUtil;

import discord4j.core.object.component.ActionRow;
import discord4j.core.object.component.Button;
import discord4j.core.object.component.LayoutComponent;

@ApplicationScoped
public class AttackMenuService {
    @Inject
    ButtonService buttonService;

    @Inject
    ButtonUtil buttonUtil;

    public List<LayoutComponent> createAttackButtons(String playerId) {
        List<Button> buttons = new ArrayList<>();
        buttons.add(buttonUtil.craftSecondaryButton("Target 1", playerId, "monsterId1"));
        buttons.add(buttonUtil.craftSecondaryButton("Target 2", playerId, "monsterId2"));
        buttons.add(buttonUtil.craftSecondaryButton("Target 3", playerId, "monsterId3"));

        List<ActionRow> rows = buttonService.createRows(buttons, 2);
        List<LayoutComponent> layout = new ArrayList<>();
        for(int i = 0; i < rows.size(); i++) {
            layout.add(rows.get(i));
        }

        return layout;
    }
}

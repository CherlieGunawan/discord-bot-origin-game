package com.cherlie.game.Service.Game.Menu;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.cherlie.game.Constant.ConstantVariable;

import discord4j.core.object.component.LayoutComponent;

@ApplicationScoped
public class MenuService {
    @Inject
    MainMenuService mainMenuService;

    @Inject
    AttackMenuService attackMenuService;

    public List<LayoutComponent> createButtons(String type, String playerId) {
        if(type.equals(ConstantVariable.BUTTON_TYPE_MAIN))
            return mainMenuService.createMainButtons(playerId);
        else if(type.equals(ConstantVariable.BUTTON_TYPE_ATTACK))
            return attackMenuService.createAttackButtons(playerId);

        return null;
    }
}

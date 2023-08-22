package com.cherlie.game.Util;

import javax.enterprise.context.ApplicationScoped;

import discord4j.core.object.component.Button;
import io.vertx.core.json.JsonObject;

@ApplicationScoped
public class ButtonUtil {
    public Button craftSecondaryButton(String buttonId, String playerId, String label) {
        JsonObject jsonId = new JsonObject();
        jsonId.put("buttonId", buttonId);
        jsonId.put("playerId", playerId);

        return Button.secondary(jsonId.encode(), label);
    }
}

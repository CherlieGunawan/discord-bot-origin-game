package com.cherlie.game.Constant;

import io.vertx.core.json.JsonObject;

public class ConstantVariable {
    public static final String EMPTY_JSON_STRING = new JsonObject().encode();

    // Button Types
    public static final String BUTTON_TYPE_MAIN = "main";
    public static final String BUTTON_TYPE_ATTACK = "attack";
}

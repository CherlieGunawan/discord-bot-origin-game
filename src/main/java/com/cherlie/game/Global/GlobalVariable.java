package com.cherlie.game.Global;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public class GlobalVariable {
    public static String selfDiscriminator = "";

    public static JsonArray gameChannelNames = new JsonArray();
    public static JsonObject channelsList = new JsonObject();

    public static JsonArray skills = new JsonArray();
    public static JsonArray equipments = new JsonArray();
}

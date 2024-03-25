package com.cherlie.game.Global;

import java.util.HashMap;

import com.cherlie.game.Model.SkillModel;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public class GlobalVariable {
    public static String selfDiscriminator = "";

    public static JsonArray gameChannelNames = new JsonArray();
    public static JsonObject channelsList = new JsonObject();

    public static HashMap<String, SkillModel> skills = new HashMap<>();
}

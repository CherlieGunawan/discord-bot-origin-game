package com.cherlie.game.Model;

import com.cherlie.game.Entity.PlayerEntity;

import io.vertx.core.json.JsonObject;

public class PlayerModel {
    public PlayerEntity player;
    public JsonObject skills;
    public JsonObject equipments;

    public PlayerModel(PlayerEntity player) {
        this.player = player;
        this.skills = new JsonObject(player.skillsString);
        this.equipments = new JsonObject(player.equipmentsString);
    }
}

//===== Equipments example start
// {
//     "head":"head-00001",
//     "body":"body-00003",
//     "legs":"legs-00001",
//     "gloves":"",
//     "shoes":"",
//     "ring1":"ring-00001",
//     "ring2":"ring-00001",
//     "necklace":"",
//     "back":"",
//     "leftHand":"-",
//     "rightHand":"bow-00002",
//     "ammo":"arrow-00001"
// }
//===== Equipments example end

//===== Skills example start
// {
//     "warrior-001":3,
//     "priest-001":5,
//     "priest-002":1,
//     "knight-001":2
// }
//===== Skills example end

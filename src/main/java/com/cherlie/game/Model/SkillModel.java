package com.cherlie.game.Model;

import com.cherlie.game.Entity.SkillEntity;

import io.vertx.core.json.JsonObject;

public class SkillModel {
    public SkillEntity skill;
    public JsonObject damage;

    public SkillModel(SkillEntity skill) {
        this.skill = skill;
        this.damage = new JsonObject(skill.damage);
    }
}

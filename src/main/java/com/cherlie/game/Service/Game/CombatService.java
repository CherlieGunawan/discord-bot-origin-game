package com.cherlie.game.Service.Game;

import javax.enterprise.context.ApplicationScoped;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.cherlie.game.Model.PlayerModel;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

@ApplicationScoped
public class CombatService {
    // damageJson = GlobalVariable.skills.getJsonObject(skillId).getJsonObject("damage");
    // skillLevel = player.skills.getFloat(skillId);
    public JsonObject calculateDamage(PlayerModel player, JsonObject damageJson, int skillLevel) throws ScriptException {
        JsonObject finalDamage = new JsonObject();
      
        JsonArray baseDamageJson = damageJson.getJsonArray("base");
        JsonArray levelDamageJson = damageJson.getJsonArray("level");
      
        for(int i = 0; i < baseDamageJson.size(); i++) {
            String damageType = baseDamageJson.getJsonObject(i).getString("type");
            float damage = calculateDamage(levelDamageJson.getJsonObject(i), player, 1);
        
            finalDamage.put(damageType, finalDamage.containsKey(damageType) ? finalDamage.getFloat(damageType) + damage : damage);
        }

        for(int i = 0; i < levelDamageJson.size(); i++) {
            String damageType = baseDamageJson.getJsonObject(i).getString("type");
            float damage = calculateDamage(levelDamageJson.getJsonObject(i), player, skillLevel);
        
            finalDamage.put(damageType, finalDamage.containsKey(damageType) ? finalDamage.getFloat(damageType) + damage : damage);
        }
      
        return finalDamage;
    }

    private float calculateDamage(JsonObject damageJsonObject, PlayerModel player, int multiplier) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        
        String formula = damageJsonObject.getString("formula");
        String damageType = damageJsonObject.getString("type");
        String damageValue = String.valueOf(damageJsonObject.getFloat("value"));

        float damage = (float) engine.eval(craftStringFormula(formula, damageType, damageValue, player));

        return damage * multiplier;
    }
      
    private String craftStringFormula(String formula, String damageType, String damageValue, PlayerModel player) {
        String finalFormula = formula;
        finalFormula = finalFormula.replace("{damage}", "(".concat(damageType.equals("flat") ? damageValue : damageValue.concat("/100")).concat(")"));
        finalFormula = finalFormula.replace("{str}", String.valueOf(player.player.strength));
        finalFormula = finalFormula.replace("{int}", String.valueOf(player.player.intelligence));
        finalFormula = finalFormula.replace("{agi}", String.valueOf(player.player.agility));
        finalFormula = finalFormula.replace("{dex}", String.valueOf(player.player.dexterity));
        finalFormula = finalFormula.replace("{vit}", String.valueOf(player.player.vitality));

        return finalFormula;
    }
}

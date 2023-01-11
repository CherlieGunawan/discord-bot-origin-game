package com.cherlie.game.Service.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.cherlie.game.Model.SkillModel;
import com.cherlie.game.Repository.SkillRepository;

import io.vertx.core.json.JsonArray;

@ApplicationScoped
public class SkillService {
    @Inject
    SkillRepository skillRepository;

    public JsonArray initialize() {
        List<SkillModel> skills = new ArrayList<>();
        skillRepository.fetchAll().forEach(skill -> {
            skills.add(new SkillModel(skill));
        });

        return new JsonArray(skills);
    }
}

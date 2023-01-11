package com.cherlie.game.Service.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.cherlie.game.Model.EquipmentModel;
import com.cherlie.game.Repository.EquipmentRepository;

import io.vertx.core.json.JsonArray;

@ApplicationScoped
public class EquipmentService {
    @Inject
    EquipmentRepository equipmentRepository;

    public JsonArray initialize() {
        List<EquipmentModel> equipments = new ArrayList<>();
        equipmentRepository.fetchAll().forEach(equipment -> {
            equipments.add(new EquipmentModel(equipment));
        });

        return new JsonArray(equipments);
    }
}

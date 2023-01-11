package com.cherlie.game.Repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.cherlie.game.Entity.EquipmentEntity;

@ApplicationScoped
public class EquipmentRepository {
    @Transactional
    public List<EquipmentEntity> fetchAll() {
        return EquipmentEntity.listAll();
    }
}

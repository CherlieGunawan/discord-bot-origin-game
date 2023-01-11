package com.cherlie.game.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "equipment")
public class EquipmentEntity extends PanacheEntityBase {
    @Id
    @Column(name = "equipment_id")
    public String equipmentId;
}

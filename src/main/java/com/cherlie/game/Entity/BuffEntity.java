package com.cherlie.game.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "buff")
public class BuffEntity extends PanacheEntityBase {
    @Id
    @Column(name = "id")
    public String id;

    @Column(name = "name")
    public String name;

    @Column(name = "trigger_interval")
    public int triggerInterval;
    
    @Column(name = "effect_type")
    public String effectType;
    
    @Column(name = "effect_target")
    public String effectTarget;
}
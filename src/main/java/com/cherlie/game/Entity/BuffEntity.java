package com.cherlie.game.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
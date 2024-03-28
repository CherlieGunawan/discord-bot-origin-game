package com.cherlie.game.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import com.cherlie.game.Entity.CompositeKeys.StackChangeConfigKey;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "stack_change_config")
@IdClass(StackChangeConfigKey.class)
public class StackChangeConfigEntity extends PanacheEntityBase {
    @Id
    @Column(name = "stack_id")
    public String stackId;

    @Id
    @Column(name = "event")
    public String event;

    @Column(name = "stack_type")
    public String stackType;

    @Column(name = "base_change_value")
    public int baseChangeValue;

    @Column(name = "power_change_value")
    public double powerChangeValue;

    @Column(name = "max_change_value")
    public int maxChangeValue;
}
package com.cherlie.game.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.cherlie.game.Entity.CompositeKeys.StackConfigKey;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "stack_config")
@IdClass(StackConfigKey.class)
public class StackConfigEntity extends PanacheEntityBase {
    @Id
    @Column(name = "stack_id")
    public String stackId;

    @Id
    @Column(name = "trigger_order")
    public int triggerOrder;

    @Column(name = "trigger_type")
    public String triggerType;

    @Column(name = "stack_type")
    public String stackType;

    @Column(name = "base_value")
    public int baseValue;

    @Column(name = "stack_value")
    public int stackValue;

    @Column(name = "value_type")
    public String valueType;
}
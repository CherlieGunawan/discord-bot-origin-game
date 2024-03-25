package com.cherlie.game.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.cherlie.game.Entity.CompositeKeys.StackStackTriggerKey;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "stack_stack_trigger")
@IdClass(StackStackTriggerKey.class)
public class StackStackTriggerEntity extends PanacheEntityBase {
    @Id
    @Column(name = "stack_id")
    public String stackId;

    @Id
    @Column(name = "trigger_order")
    public int triggerOrder;

    @Id
    @Column(name = "trigger_stack_id")
    public String triggerStackId;
    
    @Column(name = "amount")
    public int amount;
}
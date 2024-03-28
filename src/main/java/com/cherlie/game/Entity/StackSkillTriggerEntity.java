package com.cherlie.game.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import com.cherlie.game.Entity.CompositeKeys.StackSkillTriggerKey;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "stack_skill_trigger")
@IdClass(StackSkillTriggerKey.class)
public class StackSkillTriggerEntity extends PanacheEntityBase {
    @Id
    @Column(name = "stack_id")
    public String stackId;

    @Id
    @Column(name = "trigger_order")
    public int triggerOrder;

    @Id
    @Column(name = "trigger_skill_id")
    public String triggerSkillId;
    
    @Column(name = "level")
    public int level;
}
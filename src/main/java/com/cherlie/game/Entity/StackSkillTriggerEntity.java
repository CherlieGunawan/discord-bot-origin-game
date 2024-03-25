package com.cherlie.game.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

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
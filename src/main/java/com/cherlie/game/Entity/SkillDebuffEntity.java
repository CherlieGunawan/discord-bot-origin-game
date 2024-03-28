package com.cherlie.game.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import com.cherlie.game.Entity.CompositeKeys.SkillDebuffKey;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "skill_debuff")
@IdClass(SkillDebuffKey.class)
public class SkillDebuffEntity extends PanacheEntityBase {
    @Id
    @Column(name = "skill_id")
    public String skillId;

    @Id
    @Column(name = "trigger_order")
    public int triggerOrder;

    @Id
    @Column(name = "debuff_id")
    public String debuffId;

    @Column(name = "base_duration")
    public int baseDuration;
    
    @Column(name = "level_duration")
    public int levelDuration;
}
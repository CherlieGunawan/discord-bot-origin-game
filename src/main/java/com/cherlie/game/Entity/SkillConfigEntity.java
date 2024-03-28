package com.cherlie.game.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import com.cherlie.game.Entity.CompositeKeys.SkillConfigKey;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "skill_config")
@IdClass(SkillConfigKey.class)
public class SkillConfigEntity extends PanacheEntityBase {
    @Id
    @Column(name = "skill_id")
    public String skillId;

    @Id
    @Column(name = "trigger_order")
    public int triggerOrder;

    @Column(name = "effect_type")
    public String effectType;

    @Column(name = "base_value")
    public int baseValue;

    @Column(name = "level_value")
    public int levelValue;

    @Column(name = "value_type")
    public String valueType;

    @Column(name = "target")
    public String target;

    @Column(name = "targeting_type")
    public String targetingType;

    @Column(name = "min_target")
    public int minTarget;

    @Column(name = "max_target")
    public int maxTarget;
}
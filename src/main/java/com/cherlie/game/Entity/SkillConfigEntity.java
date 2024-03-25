package com.cherlie.game.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "skill_config")
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
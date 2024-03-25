package com.cherlie.game.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.cherlie.game.Entity.CompositeKeys.SkillBuffKey;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "skill_buff")
@IdClass(SkillBuffKey.class)
public class SkillBuffEntity extends PanacheEntityBase {
    @Id
    @Column(name = "skill_id")
    public String skillId;

    @Id
    @Column(name = "trigger_order")
    public int triggerOrder;

    @Id
    @Column(name = "buff_id")
    public String buffId;

    @Column(name = "base_duration")
    public int baseDuration;
    
    @Column(name = "level_duration")
    public int levelDuration;
}
package com.cherlie.game.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import com.cherlie.game.Entity.CompositeKeys.SkillStackKey;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "skill_stack")
@IdClass(SkillStackKey.class)
public class SkillStackEntity extends PanacheEntityBase {
    @Id
    @Column(name = "skill_id")
    public String skillId;

    @Id
    @Column(name = "stack_id")
    public String stackId;

    @Column(name = "change_type")
    public String changeType;
    
    @Column(name = "base_change")
    public int baseChange;
    
    @Column(name = "level_change")
    public int levelChange;
}
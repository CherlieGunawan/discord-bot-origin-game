package com.cherlie.game.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "skill_stack")
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
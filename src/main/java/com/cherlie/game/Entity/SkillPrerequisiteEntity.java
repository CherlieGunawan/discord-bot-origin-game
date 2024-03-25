package com.cherlie.game.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "skill_prerequisite")
public class SkillPrerequisiteEntity extends PanacheEntityBase {
    @Id
    @Column(name = "skill_id")
    public String skillId;

    @Id
    @Column(name = "prerequisite_id")
    public String prerequisiteId;

    @Column(name = "prerequisite_level")
    public int prerequisiteLevel;
}
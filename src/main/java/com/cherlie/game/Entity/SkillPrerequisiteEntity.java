package com.cherlie.game.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import com.cherlie.game.Entity.CompositeKeys.SkillPrerequisiteKey;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "skill_prerequisite")
@IdClass(SkillPrerequisiteKey.class)
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
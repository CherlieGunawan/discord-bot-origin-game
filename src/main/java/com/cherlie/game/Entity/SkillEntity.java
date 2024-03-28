package com.cherlie.game.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "skill")
public class SkillEntity extends PanacheEntityBase {
    @Id
    @Column(name = "id")
    public String id;

    @Column(name = "name")
    public String name;

    @Column(name = "description")
    public String description;

    @Column(name = "max_level")
    public int maxLevel;
}
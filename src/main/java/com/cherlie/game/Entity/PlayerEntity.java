package com.cherlie.game.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "player")
public class PlayerEntity extends PanacheEntityBase {
    @Id
    @Column(name = "id")
    public String id;

    @Column(name = "name")
    public String name;

    @Column(name = "level")
    public int level;

    @Column(name = "status_point")
    public int statusPoint;

    @Column(name = "skill_point")
    public int skillPoint;

    @Column(name = "strength")
    public int strength;
    
    @Column(name = "intelligence")
    public int intelligence;

    @Column(name = "vitality")
    public int vitality;

    @Column(name = "agility")
    public int agility;

    @Column(name = "dexterity")
    public int dexterity;
}
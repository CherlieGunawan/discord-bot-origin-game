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
    @Column(name = "player_id")
    public String playerId;

    @Column(name = "skills")
    public String skillsString;
    @Column(name = "equipments")
    public String equipmentsString;

    @Column(name = "name")
    public String name;
    @Column(name = "level")
    public String level;

    @Column(name = "status_points")
    public int statusPoints;
    @Column(name = "skill_points")
    public int skillPoints;

    @Column(name = "strength")
    public int strength;
    @Column(name = "intelligence")
    public int intelligence;
    @Column(name = "agility")
    public int agility;
    @Column(name = "dexterity")
    public int dexterity;
    @Column(name = "vitality")
    public int vitality;
}

//===== Equipments example start
// {
//     "head":"head-00001",
//     "body":"body-00003",
//     "legs":"legs-00001",
//     "gloves":"",
//     "shoes":"",
//     "ring1":"ring-00001",
//     "ring2":"ring-00001",
//     "necklace":"",
//     "back":"",
//     "leftHand":"-",
//     "rightHand":"bow-00002",
//     "ammo":"arrow-00001"
// }
//===== Equipments example end

//===== Skills example start
// {
//     "warrior-001":3,
//     "priest-001":5,
//     "priest-002":1,
//     "knight-001":2
// }
//===== Skills example end

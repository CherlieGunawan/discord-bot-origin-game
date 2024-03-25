package com.cherlie.game.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "player_skill")
public class PlayerSkillEntity extends PanacheEntityBase {
    @Id
    @Column(name = "player_id")
    public String playerId;

    @Id
    @Column(name = "skill_id")
    public String skillId;

    @Column(name = "level")
    public int level;
}
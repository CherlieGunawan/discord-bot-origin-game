package com.cherlie.game.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import com.cherlie.game.Entity.CompositeKeys.PlayerSkillKey;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "player_skill")
@IdClass(PlayerSkillKey.class)
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
package com.cherlie.game.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "skill")
public class SkillEntity extends PanacheEntityBase {
    @Id
    @Column(name = "skill_id")
    public String skillId;

    @Column(name = "skill_name")
    public String skillName;

    @Column(name = "max_level")
    public int maxLevel;

    @Column(name = "type") // Offensive, Defensive, Heal, Buff, Debuff
    public String type;

    @Column(name = "damage") // Offensive, Heal, some Debuff
    public String damage;

    // TODO: continue
}

//===== Damage example start
// {
//     "base": [
//         {
//             "type": "flat",
//             "value": 100,
//             "element": "none",
//             "formula": "{damage}"
//         },
//         {
//             "type": "percent",
//             "value": 5,
//             "element": "fire",
//             "formula": "{damage}*{int}"
//         },
//         {
//             "type": "percent",
//             "value": 5,
//             "element": "water",
//             "formula": "{damage}*{int}"
//         }
//     ],
//     "level": [
//         {
//             "type": "percent",
//             "value": 2,
//             "element": "fire",
//             "formula": "{damage}*{int}"
//         },
//         {
//             "type": "percent",
//             "value": 2,
//             "element": "water",
//             "formula": "{damage}*{int}"
//         }
//     ]
// }
//===== Damage example end

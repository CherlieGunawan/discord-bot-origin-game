DROP TABLE IF EXISTS origin.skill_debuff;

CREATE TABLE origin.skill_debuff (
    skill_id VARCHAR(50),
    trigger_order INT,
    debuff_id VARCHAR(50),
    base_duration INT NOT NULL,
    level_duration INT NOT NULL,
    PRIMARY KEY(skill_id, trigger_order, debuff_id),
    CONSTRAINT fk_skill_config
        FOREIGN KEY(skill_id, trigger_order)
            REFERENCES origin.skill_config(skill_id, trigger_order),
    CONSTRAINT fk_debuff
        FOREIGN KEY(debuff_id)
            REFERENCES origin.debuff(id)
);
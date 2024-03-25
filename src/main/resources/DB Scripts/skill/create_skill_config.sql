DROP TABLE IF EXISTS origin.skill_config;

CREATE TABLE origin.skill_config (
    skill_id VARCHAR(50),
    trigger_order INT,
    effect_type VARCHAR(10) NOT NULL,
    base_value INT NOT NULL,
    level_value INT NOT NULL,
    value_type VARCHAR(10) NOT NULL,
    target VARCHAR(10) NOT NULL,
    targeting_type VARCHAR(10) NOT NULL,
    min_target INT NOT NULL DEFAULT 1,
    max_target INT NOT NULL DEFAULT 1,
    PRIMARY KEY(skill_id, trigger_order),
    CONSTRAINT fk_skill
        FOREIGN KEY(skill_id)
            REFERENCES origin.skill(id)
);
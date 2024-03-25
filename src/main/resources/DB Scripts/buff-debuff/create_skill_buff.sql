DROP TABLE IF EXISTS origin.skill_buff;

CREATE TABLE origin.skill_buff (
    skill_id VARCHAR(50),
    trigger_order INT,
    buff_id VARCHAR(50),
    base_duration INT NOT NULL,
    level_duration INT NOT NULL,
    PRIMARY KEY(skill_id, trigger_order, buff_id),
    CONSTRAINT fk_skill_config
        FOREIGN KEY(skill_id, trigger_order)
            REFERENCES origin.skill_config(skill_id, trigger_order),
    CONSTRAINT fk_buff
        FOREIGN KEY(buff_id)
            REFERENCES origin.buff(id)
);
DROP TABLE IF EXISTS origin.stack_skill_trigger;

CREATE TABLE origin.stack_skill_trigger (
    stack_id VARCHAR(50),
    trigger_order INT,
    trigger_skill_id VARCHAR(50),
    level INT NOT NULL,
    PRIMARY KEY(stack_id, trigger_order, trigger_skill_id),
    CONSTRAINT fk_stack_config
        FOREIGN KEY(stack_id, trigger_order)
            REFERENCES origin.stack_config(stack_id, trigger_order),
    CONSTRAINT fk_skill
        FOREIGN KEY(trigger_skill_id)
            REFERENCES origin.skill(id)
);
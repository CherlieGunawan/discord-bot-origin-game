DROP TABLE IF EXISTS origin.stack_debuff;

CREATE TABLE origin.stack_debuff (
    stack_id VARCHAR(50),
    trigger_order INT,
    debuff_id VARCHAR(50),
    base_duration INT NOT NULL,
    level_duration INT NOT NULL,
    PRIMARY KEY(stack_id, trigger_order, debuff_id),
    CONSTRAINT fk_stack_config
        FOREIGN KEY(stack_id, trigger_order)
            REFERENCES origin.stack_config(stack_id, trigger_order),
    CONSTRAINT fk_debuff
        FOREIGN KEY(debuff_id)
            REFERENCES origin.debuff(id)
);
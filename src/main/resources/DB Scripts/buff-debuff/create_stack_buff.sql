DROP TABLE IF EXISTS origin.stack_buff;

CREATE TABLE origin.stack_buff (
    stack_id VARCHAR(50),
    trigger_order INT,
    buff_id VARCHAR(50),
    base_duration INT NOT NULL,
    level_duration INT NOT NULL,
    PRIMARY KEY(stack_id, trigger_order, buff_id),
    CONSTRAINT fk_stack_config
        FOREIGN KEY(stack_id, trigger_order)
            REFERENCES origin.stack_config(stack_id, trigger_order),
    CONSTRAINT fk_buff
        FOREIGN KEY(buff_id)
            REFERENCES origin.buff(id)
);
DROP TABLE IF EXISTS origin.stack_stack_trigger;

CREATE TABLE origin.stack_stack_trigger (
    stack_id VARCHAR(50),
    trigger_order INT,
    trigger_stack_id VARCHAR(50),
    amount INT NOT NULL,
    PRIMARY KEY(stack_id, trigger_order, trigger_stack_id),
    CONSTRAINT fk_stack_config
        FOREIGN KEY(stack_id, trigger_order)
            REFERENCES origin.stack_config(stack_id, trigger_order),
    CONSTRAINT fk_stack
        FOREIGN KEY(trigger_stack_id)
            REFERENCES origin.stack(id)
);
DROP TABLE IF EXISTS origin.stack_config;

CREATE TABLE origin.stack_config (
    stack_id VARCHAR(50),
    trigger_order INT,
    trigger_type VARCHAR(20) NOT NULL,
    stack_type VARCHAR(10) NOT NULL,
    base_value INT NOT NULL,
    stack_value INT NOT NULL,
    value_type VARCHAR(10) NOT NULL,
    PRIMARY KEY(stack_id, trigger_order),
    CONSTRAINT fk_stack
        FOREIGN KEY(stack_id)
            REFERENCES origin.stack(id)
);
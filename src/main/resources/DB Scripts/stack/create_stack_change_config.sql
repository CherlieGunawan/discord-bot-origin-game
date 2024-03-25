DROP TABLE IF EXISTS origin.stack_change_config;

CREATE TABLE origin.stack_change_config (
    stack_id VARCHAR(50),
    event VARCHAR(20),
    stack_type VARCHAR(10) NOT NULL,
    base_change_value INT NOT NULL DEFAULT 0,
    power_change_value NUMERIC(5, 2) NOT NULL,
    max_change_value INT NOT NULL DEFAULT 0,
    PRIMARY KEY(stack_id, event),
    CONSTRAINT fk_stack
        FOREIGN KEY(stack_id)
            REFERENCES origin.stack(id)
);
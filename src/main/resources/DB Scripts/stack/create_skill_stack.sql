DROP TABLE IF EXISTS origin.skill_stack;

CREATE TABLE origin.skill_stack (
    skill_id VARCHAR(50),
    stack_id VARCHAR(50),
    change_type VARCHAR(10) NOT NULL,
    base_change INT NOT NULL,
    level_change INT NOT NULL,
    PRIMARY KEY(skill_id, stack_id),
    CONSTRAINT fk_skill
        FOREIGN KEY(skill_id)
            REFERENCES origin.skill(id),
    CONSTRAINT fk_stack
        FOREIGN KEY(stack_id)
            REFERENCES origin.stack(id)
);
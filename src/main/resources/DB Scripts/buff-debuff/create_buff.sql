DROP TABLE IF EXISTS origin.buff;

CREATE TABLE origin.buff (
    id VARCHAR(50),
    name VARCHAR(100) NOT NULL,
    trigger_interval INT NOT NULL DEFAULT 0,
    effect_type VARCHAR(10) NOT NULL,
    effect_target VARCHAR(20) NOT NULL,
    PRIMARY KEY(id)
);
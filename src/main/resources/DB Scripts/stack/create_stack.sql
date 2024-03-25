DROP TABLE IF EXISTS origin.stack;

CREATE TABLE origin.stack (
    id VARCHAR(50),
    name VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    trigger_amount INT NOT NULL DEFAULT 0,
    PRIMARY KEY(id)
);
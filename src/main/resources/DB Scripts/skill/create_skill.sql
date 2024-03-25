DROP TABLE IF EXISTS origin.skill;

CREATE TABLE origin.skill (
    id VARCHAR(50),
    name VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    PRIMARY KEY(id)
);
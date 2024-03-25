DROP TABLE IF EXISTS origin.player;

CREATE TABLE origin.player (
    id VARCHAR(20),
    name VARCHAR(100) NOT NULL,
    level INT NOT NULL DEFAULT 1,
    status_point INT NOT NULL DEFAULT 0,
    skill_point INT NOT NULL DEFAULT 0,
    strength INT NOT NULL DEFAULT 1,
    intelligence INT NOT NULL DEFAULT 1,
    vitality INT NOT NULL DEFAULT 1,
    agility INT NOT NULL DEFAULT 1,
    dexterity INT NOT NULL DEFAULT 1,
    PRIMARY KEY(id)
);
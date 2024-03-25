DROP TABLE IF EXISTS origin.player_skill;

CREATE TABLE origin.player_skill (
    player_id VARCHAR(20),
    skill_id VARCHAR(50),
    level INT NOT NULL DEFAULT 1,
    PRIMARY KEY(player_id, skill_id),
    CONSTRAINT fk_player
        FOREIGN KEY(player_id)
            REFERENCES origin.player(id),
    CONSTRAINT fk_skill
        FOREIGN KEY(skill_id)
            REFERENCES origin.skill(id)
);
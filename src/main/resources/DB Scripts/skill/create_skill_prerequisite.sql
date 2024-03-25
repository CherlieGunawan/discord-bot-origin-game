DROP TABLE IF EXISTS origin.skill_prerequisite;

CREATE TABLE origin.skill_prerequisite (
    skill_id VARCHAR(50),
    prerequisite_id VARCHAR(50),
    prerequisite_level INT NOT NULL,
    PRIMARY KEY(skill_id, prerequisite_id),
    CONSTRAINT fk_skill
        FOREIGN KEY(skill_id)
            REFERENCES origin.skill(id),
    CONSTRAINT fk_prerequisite
        FOREIGN KEY(prerequisite_id)
            REFERENCES origin.skill(id)
);
CREATE TABLE matcher.competencies
(
    competence_id serial       NOT NULL,
    name          varchar(255) NOT NULL,
    CONSTRAINT competencies_pk PRIMARY KEY (competence_id)
);

CREATE TABLE matcher.user_competencies
(
    user_id       integer NOT NULL,
    competence_id integer NOT NULL,
    PRIMARY KEY (user_id, competence_id)
);

ALTER TABLE matcher.user_competencies
    ADD CONSTRAINT user_competencies_fk0 FOREIGN KEY (user_id) REFERENCES matcher.users (user_id);
ALTER TABLE matcher.user_competencies
    ADD CONSTRAINT user_competencies_fk1 FOREIGN KEY (competence_id) REFERENCES matcher.competencies (competence_id);
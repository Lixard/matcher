ALTER TABLE matcher.user_project_competencies
DROP
CONSTRAINT IF EXISTS user_project_competencies_fk0;

ALTER TABLE matcher.user_project_competencies
DROP
CONSTRAINT IF EXISTS user_project_competencies_fk1;

ALTER TABLE matcher.user_project_competencies
DROP
CONSTRAINT IF EXISTS user_project_competencies_fk2;

DROP TABLE IF EXISTS matcher.competencies;

DROP TABLE IF EXISTS matcher.user_project_competencies;
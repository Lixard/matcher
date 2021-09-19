ALTER TABLE matcher.projects
    DROP CONSTRAINT IF EXISTS project_fk1;

ALTER TABLE matcher.projects
    DROP COLUMN org_id;

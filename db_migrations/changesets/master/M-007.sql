ALTER TABLE matcher.projects ADD COLUMN org_id INTEGER;
ALTER TABLE matcher.projects
    ADD CONSTRAINT project_fk1 FOREIGN KEY (org_id) REFERENCES matcher.organizations (org_id);

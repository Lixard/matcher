ALTER TABLE matcher.users
    DROP CONSTRAINT IF EXISTS users_fk0;

ALTER TABLE matcher.organizations
    DROP CONSTRAINT IF EXISTS organizations_fk0;

ALTER TABLE matcher.organizations
    DROP CONSTRAINT IF EXISTS organizations_fk1;

ALTER TABLE matcher.projects
    DROP CONSTRAINT IF EXISTS projects_fk0;

ALTER TABLE matcher.user_organizations
    DROP CONSTRAINT IF EXISTS user_organizations_fk0;

ALTER TABLE matcher.user_organizations
    DROP CONSTRAINT IF EXISTS user_organizations_fk1;

ALTER TABLE matcher.project_participation
    DROP CONSTRAINT IF EXISTS project_participations_fk0;

ALTER TABLE matcher.project_participation
    DROP CONSTRAINT IF EXISTS project_participations_fk1;

DROP TABLE IF EXISTS matcher.users;

DROP TABLE IF EXISTS matcher.organizations;

DROP TABLE IF EXISTS matcher.projects;

DROP TABLE IF EXISTS matcher.files;

DROP TABLE IF EXISTS matcher.user_organizations;

DROP TABLE IF EXISTS matcher.project_participations;

DROP TABLE IF EXISTS matcher.org_types;

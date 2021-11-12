ALTER TABLE matcher.requests
    DROP CONSTRAINT IF EXISTS project_fk0;
ALTER TABLE matcher.requests
    DROP CONSTRAINT IF EXISTS user_fk1;

DROP TABLE IF EXISTS matcher.requests;

ALTER TABLE matcher.project_files
    DROP CONSTRAINT IF EXISTS project_files_fk0;
ALTER TABLE matcher.project_files
    DROP CONSTRAINT IF EXISTS project_files_fk1;

DROP TABLE IF EXISTS matcher.project_files;

DROP TABLE IF EXISTS matcher.files;
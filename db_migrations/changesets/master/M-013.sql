ALTER TABLE matcher.pictures
    RENAME CONSTRAINT files_pk TO pictures_pk;

CREATE TABLE matcher.project_files
(
    project_id INTEGER    NOT NULL,
    file_id    INTEGER    NOT NULL,
    CONSTRAINT project_files_pk PRIMARY KEY (project_id, file_id)
);

CREATE TABLE matcher.files
(
    file_id    serial       NOT NULL,
    name       varchar(250) NOT NULL,
    type       varchar(100) NOT NULL,
    size       BIGINT       NOT NULL,
    created_at DATE DEFAULT CURRENT_TIMESTAMP,
    data       bytea        NOT NULL,
    CONSTRAINT files_pk PRIMARY KEY (file_id)
);

ALTER TABLE matcher.project_files
    ADD CONSTRAINT project_files_fk0 FOREIGN KEY (project_id) REFERENCES matcher.projects (project_id);
ALTER TABLE matcher.project_files
    ADD CONSTRAINT project_files_fk1 FOREIGN KEY (file_id) REFERENCES matcher.files (file_id) ON DELETE CASCADE;
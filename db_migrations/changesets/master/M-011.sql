CREATE TABLE matcher.requests
(
    request_id  serial   NOT NULL,
    project_id  integer,
    user_id     integer,
    message     varchar(1024),
    CONSTRAINT requests_pk PRIMARY KEY (request_id)
);

ALTER TABLE matcher.requests
    ADD CONSTRAINT project_fk0 FOREIGN KEY (project_id) REFERENCES matcher.projects (project_id);
ALTER TABLE matcher.requests
    ADD CONSTRAINT user_fk1 FOREIGN KEY (user_id) REFERENCES matcher.users (user_id);

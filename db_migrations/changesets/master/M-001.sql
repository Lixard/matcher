CREATE TABLE matcher.users
(
    user_id     serial      NOT NULL,
    picture_id  integer,
    login       varchar(50) NOT NULL,
    password    char(60)    NOT NULL,
    first_name  varchar(50) NOT NULL,
    last_name   varchar(50) NOT NULL,
    second_name varchar(50),
    email       varchar(50),
    phone       varchar(20),
    CONSTRAINT users_pk PRIMARY KEY (user_id)
);



CREATE TABLE matcher.organizations
(
    org_id      serial       NOT NULL,
    picture_id  integer,
    name        varchar(100) NOT NULL,
    org_type_id integer      NOT NULL,
    description TEXT,
    url         varchar(200) NOT NULL,
    email       varchar(50)  NOT NULL,
    address     varchar(150) NOT NULL,
    CONSTRAINT organizations_pk PRIMARY KEY (org_id)
);



CREATE TABLE matcher.projects
(
    project_id  serial       NOT NULL,
    picture_id  integer,
    name        varchar(100) NOT NULL,
    description TEXT,
    is_active   BOOLEAN      NOT NULL DEFAULT 'true',
    CONSTRAINT projects_pk PRIMARY KEY (project_id)
);



CREATE TABLE matcher.files
(
    file_id serial       NOT NULL,
    name    varchar(100) NOT NULL,
    type    varchar(100) NOT NULL,
    data    bytea        NOT NULL,
    CONSTRAINT files_pk PRIMARY KEY (file_id)
);



CREATE TABLE matcher.user_organizations
(
    user_id    integer NOT NULL,
    org_id     integer NOT NULL,
    start_date DATE    NOT NULL,
    end_date   DATE,
    is_admin   BOOLEAN NOT NULL DEFAULT 'false',
    CONSTRAINT user_organizations_pk PRIMARY KEY (user_id, org_id)
);



CREATE TABLE matcher.project_participation
(
    user_id    serial  NOT NULL,
    project_id integer NOT NULL,
    start_date DATE    NOT NULL,
    end_date   DATE,
    is_admin   BOOLEAN NOT NULL DEFAULT 'false',
    CONSTRAINT project_participation_pk PRIMARY KEY (user_id, project_id)
);

CREATE TABLE matcher.org_types
(
    org_type_id integer     NOT NULL,
    name        varchar(20) NOT NULL,
    CONSTRAINT org_types_pk PRIMARY KEY (org_type_id)
);



ALTER TABLE matcher.users
    ADD CONSTRAINT users_fk0 FOREIGN KEY (picture_id) REFERENCES matcher.files (file_id);

ALTER TABLE matcher.organizations
    ADD CONSTRAINT organizations_fk0 FOREIGN KEY (picture_id) REFERENCES matcher.files (file_id);
ALTER TABLE matcher.organizations
    ADD CONSTRAINT organizations_fk1 FOREIGN KEY (org_type_id) REFERENCES matcher.org_types (org_type_id);

ALTER TABLE matcher.projects
    ADD CONSTRAINT projects_fk0 FOREIGN KEY (picture_id) REFERENCES matcher.files (file_id);


ALTER TABLE matcher.user_organizations
    ADD CONSTRAINT user_organizations_fk0 FOREIGN KEY (user_id) REFERENCES matcher.users (user_id);
ALTER TABLE matcher.user_organizations
    ADD CONSTRAINT user_organizations_fk1 FOREIGN KEY (org_id) REFERENCES matcher.organizations (org_id);

ALTER TABLE matcher.project_participation
    ADD CONSTRAINT project_participation_fk0 FOREIGN KEY (user_id) REFERENCES matcher.users (user_id);
ALTER TABLE matcher.project_participation
    ADD CONSTRAINT project_participation_fk1 FOREIGN KEY (project_id) REFERENCES matcher.projects (project_id);

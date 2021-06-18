CREATE TABLE matcher.user_types
(
    user_type_id int not null,
    name varchar(50) not null,
    CONSTRAINT user_types_pk PRIMARY KEY (user_type_id)
);

ALTER TABLE matcher.users
    ADD user_type_id int not null default 0;

ALTER TABLE matcher.users
    ADD CONSTRAINT users_fk1 FOREIGN KEY (user_type_id) REFERENCES matcher.user_types (user_type_id);

INSERT INTO matcher.user_types (user_type_id, name)
values (1, 'STUDENT');
INSERT INTO matcher.user_types (user_type_id, name)
values (2, 'EMPLOYEE');

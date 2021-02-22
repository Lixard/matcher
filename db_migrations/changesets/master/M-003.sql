ALTER TABLE matcher.users
    ADD CONSTRAINT unique_login UNIQUE (login);

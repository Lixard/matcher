DELETE FROM matcher.user_types WHERE user_type_id = 1;
DELETE FROM matcher.user_types WHERE user_type_id = 2;

ALTER TABLE matcher.users
    DROP CONSTRAINT IF EXISTS users_fk1;

ALTER TABLE matcher.users
    DROP COLUMN user_type_id;

DROP TABLE IF EXISTS matcher.user_types;

DO
$$
    BEGIN
        IF (SELECT last_value = 4 FROM matcher.organizations_org_id_seq) THEN
            PERFORM setval('matcher.organizations_org_id_seq', 1);
        END IF;
    END
$$;

DO
$$
    BEGIN
        IF (SELECT last_value = 4 FROM matcher.project_participation_user_id_seq) THEN
            PERFORM setval('matcher.project_participation_user_id_seq', 1);
        END IF;
    END
$$;

DO
$$
    BEGIN
        IF (SELECT last_value = 4 FROM matcher.users_user_id_seq) THEN
            PERFORM setval('matcher.users_user_id_seq', 1);
        END IF;
    END
$$;

DO
$$
    BEGIN
        IF (SELECT last_value = 3 FROM matcher.projects_project_id_seq) THEN
            PERFORM setval('matcher.projects_project_id_seq', 1);
        END IF;
    END
$$;

INSERT INTO matcher.users (user_id, login, password, first_name, last_name, second_name, email, phone, user_type_id) VALUES (2147483647, 'lixard', '$2a$10$LnCs.XCEWwGhOEL9xMVVLu.k1yW5uLTlN6syVebPEmYDKetX4AtlS', 'Максим', 'Борисов', 'Андреевич',  'mba@gmail.com', '87027772727', 2);
INSERT INTO matcher.users (user_id, login, password, first_name, last_name, second_name, email, phone, user_type_id) VALUES (2147483646, 'liliolus', '$2a$10$LnCs.XCEWwGhOEL9xMVVLu.k1yW5uLTlN6syVebPEmYDKetX4AtlS', 'Юлия', 'Ильенко', 'Витальевна',  'jiv@gmail.com', '89017978799', 2);
INSERT INTO matcher.users (user_id, login, password, first_name, last_name, second_name, email, phone, user_type_id) VALUES (2147483645, 'arishaa', '$2a$10$LnCs.XCEWwGhOEL9xMVVLu.k1yW5uLTlN6syVebPEmYDKetX4AtlS', 'Арина', 'Ишкова', 'Денисовна',  'aid@gmail.com', '85015758725', 1);
INSERT INTO matcher.users (user_id, login, password, first_name, last_name, second_name, email, phone, user_type_id) VALUES (2147483644, 'max', '$2a$10$LnCs.XCEWwGhOEL9xMVVLu.k1yW5uLTlN6syVebPEmYDKetX4AtlS', 'Максим', 'Комов', 'Андреевич',  'mka@gmail.com', '87117171127', 2);
INSERT INTO matcher.users (user_id, login, password, first_name, last_name, second_name, email, phone, user_type_id) VALUES (2147483643, 'shved', '$2a$10$LnCs.XCEWwGhOEL9xMVVLu.k1yW5uLTlN6syVebPEmYDKetX4AtlS', 'Николай', 'Шведов', 'Николаевич',  'nshsh@gmail.com', '87111178727', 1);
INSERT INTO matcher.users (user_id, login, password, first_name, last_name, second_name, email, phone, user_type_id) VALUES (2147483642, 'karelin', '$2a$10$LnCs.XCEWwGhOEL9xMVVLu.k1yW5uLTlN6syVebPEmYDKetX4AtlS', 'Михаил', 'Бирюков', 'Юрьевич',  'mbu@gmail.com', '87417171421', 1);
INSERT INTO matcher.users (user_id, login, password, first_name, last_name, second_name, email, phone, user_type_id) VALUES (2147483641, 'AAA', '$2a$10$LnCs.XCEWwGhOEL9xMVVLu.k1yW5uLTlN6syVebPEmYDKetX4AtlS', 'Александр', 'Артуров', 'Александрович',  'aaa@gmail.com', '88888888881', 2);
INSERT INTO matcher.users (user_id, login, password, first_name, last_name, second_name, email, phone, user_type_id) VALUES (2147483640, 'BBB', '$2a$10$LnCs.XCEWwGhOEL9xMVVLu.k1yW5uLTlN6syVebPEmYDKetX4AtlS', 'Борис', 'Борисов', 'Борисович',  'bbb@gmail.com', '85555555551', 2);
INSERT INTO matcher.users (user_id, login, password, first_name, last_name, second_name, email, phone, user_type_id) VALUES (2147483639, 'CCC', '$2a$10$LnCs.XCEWwGhOEL9xMVVLu.k1yW5uLTlN6syVebPEmYDKetX4AtlS', 'Светлана', 'Сидорова', 'Светлановна',  'ccc@gmail.com', '87777777772', 1);
INSERT INTO matcher.users (user_id, login, password, first_name, last_name, second_name, email, phone, user_type_id) VALUES (2147483638, 'DDD', '$2a$10$LnCs.XCEWwGhOEL9xMVVLu.k1yW5uLTlN6syVebPEmYDKetX4AtlS', 'Дмитрий', 'Долженков', 'Дмитриевич',  'ddd@gmail.com', '86666666662', 1);

INSERT INTO matcher.organizations (org_id, name, org_type_id, description, url, email, address) VALUES (2147483647, 'ВГУИТ', 1, 'Воронежский государственный университет инженерных технологий', 'https://vguit.ru', 'rect1@ggg.ru',  'ул. 91-летия Декабря, 111');
INSERT INTO matcher.organizations (org_id, name, org_type_id, description, url, email, address) VALUES (2147483646, 'МГУ', 1, 'Московский государственный университет', 'https://mgu.ru', 'rect2@ggg.ru',  'ул. 92-летия Декабря, 112');
INSERT INTO matcher.organizations (org_id, name, org_type_id, description, url, email, address) VALUES (2147483645, 'Atos', 2, 'Международный лидер в области цифровой трансформации с годовым оборотом более 11 миллиардов евро и количеством сотрудников 105 000 человек', 'https://vguit.ru', 'rect3@ggg.vrn.ru',  'ул. 93-летия Декабря, 113');
INSERT INTO matcher.organizations (org_id, name, org_type_id, description, url, email, address) VALUES (2147483644, 'РТ Лабс', 2, 'Компания, создавшая госуслуги', 'https://vguit.ru', 'rect4@ggg.vrn.ru',  'ул. 94-летия Декабря, 114');

INSERT INTO matcher.user_organizations (user_id, org_id, start_date, end_date, is_admin) VALUES (2147483647, 2147483645, '2020-07-28', '2030-12-31', false);
INSERT INTO matcher.user_organizations (user_id, org_id, start_date, end_date, is_admin) VALUES (2147483646, 2147483644, '2015-08-31', '2020-05-31', false);
INSERT INTO matcher.user_organizations (user_id, org_id, start_date, end_date, is_admin) VALUES (2147483645, 2147483646, '2018-09-01', '2022-08-31', false);
INSERT INTO matcher.user_organizations (user_id, org_id, start_date, end_date, is_admin) VALUES (2147483644, 2147483645, '2020-10-24', '2029-11-01', false);
INSERT INTO matcher.user_organizations (user_id, org_id, start_date, end_date, is_admin) VALUES (2147483643, 2147483647, '2017-09-20', '2021-07-01', false);
INSERT INTO matcher.user_organizations (user_id, org_id, start_date, end_date, is_admin) VALUES (2147483642, 2147483647, '2020-04-18', '2022-09-29', false);
INSERT INTO matcher.user_organizations (user_id, org_id, start_date, end_date, is_admin) VALUES (2147483641, 2147483645, '2021-05-05', '2035-04-19', true);
INSERT INTO matcher.user_organizations (user_id, org_id, start_date, end_date, is_admin) VALUES (2147483640, 2147483644, '2020-02-01', '2021-11-15', true);
INSERT INTO matcher.user_organizations (user_id, org_id, start_date, end_date, is_admin) VALUES (2147483639, 2147483646, '2019-11-09', '2022-09-29', false);
INSERT INTO matcher.user_organizations (user_id, org_id, start_date, end_date, is_admin) VALUES (2147483638, 2147483646, '2020-10-11', '2023-08-21', false);

INSERT INTO matcher.projects (project_id, name, description, is_active) VALUES (2147483647, 'Chess', 'Игра ШАХМАТЫ для Android', true);
INSERT INTO matcher.projects (project_id, name, description, is_active) VALUES (2147483646, 'Taxi', 'Приложение для заказа такси', true);
INSERT INTO matcher.projects (project_id, name, description, is_active) VALUES (2147483645, 'Messenger', 'Месседжер для общения, обмена фотографиями, различными файлами с возможностью создания общих чатов и групп. В группах может быть различное количество администраторов, которые также имеют свои роли.', true);
INSERT INTO matcher.projects (project_id, name, description, is_active) VALUES (2147483644, 'Alarm', 'Данный проект предназначен для создания приложения БУДИЛЬНИК для Android платформы. Планируется добавить возможность смены звука звонка будильника, возможность менять время отхода ко сну и время пробуждения. Приложение будет отслеживать время сна и давать советы для сохранения здоровья и улучшения качества сна. В случае, если человек несколько раз не отреагировал на будильник мелодия может повториться громче, либо может быть осуществлён звонок близким (функция опциональная). В приложени можно будет сменить тему и цвет.', true);
INSERT INTO matcher.projects (project_id, name, description, is_active) VALUES (2147483643, 'Calendar', 'Календарь', false);

INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483647, 2147483645, '2019-08-30', '2022-02-15', true, 'Создатель');
INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483646, 2147483647, '2020-07-31', '2023-12-27', true, 'Создатель');
INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483645, 2147483646, '2016-03-22', '2022-09-30', true, 'Создатель');
INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483644, 2147483644, '2018-09-26', '2024-08-22', true, 'Создатель');
INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483643, 2147483643, '2014-12-13', '2021-05-11', true, 'Создатель');
INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483641, 2147483647, '2017-11-03', '2025-02-10', false, 'Участник');
INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483645, 2147483647, '2021-05-30', '2025-03-18', true, 'Участник');
INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483647, 2147483647, '2019-04-26', '2024-07-23', false, 'Участник');
INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483638, 2147483647, '2015-02-28', '2022-12-23', false, 'Участник');
INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483644, 2147483647, '2017-01-03', '2023-11-24', false, 'Участник');
INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483642, 2147483646, '2016-05-12', '2018-05-28', false, 'Участник');
INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483640, 2147483646, '2019-02-14', '2025-04-16', false, 'Участник');
INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483643, 2147483646, '2017-03-16', '2025-06-17', false, 'Участник');
INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483645, 2147483645, '2021-08-10', '2024-02-01', false, 'Участник');
INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483646, 2147483645, '2016-09-30', '2025-01-05', true, 'Участник');
INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483644, 2147483645, '2020-11-30', '2023-09-16', false, 'Участник');
INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483641, 2147483645, '2021-10-01', '2024-09-09', false, 'Участник');
INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483640, 2147483645, '2020-10-24', '2022-12-23', false, 'Участник');
INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483642, 2147483644, '2016-12-31', '2021-10-16', false, 'Участник');
INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483643, 2147483644, '2017-07-30', '2021-11-30', false, 'Участник');
INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483638, 2147483644, '2016-08-12', '2025-10-26', false, 'Участник');
INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483639, 2147483643, '2015-08-07', '2024-08-25', false, 'Участник');
INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483642, 2147483643, '2019-07-02', '2020-09-26', false, 'Участник');
INSERT INTO matcher.project_participation (user_id, project_id, start_date, end_date, is_admin, user_role) VALUES (2147483645, 2147483643, '2021-04-04', '2025-05-27', false, 'Участник');












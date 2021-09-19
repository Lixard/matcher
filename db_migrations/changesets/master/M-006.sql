INSERT INTO matcher.organizations (org_id, name, org_type_id, description, url, email, address) VALUES (1, 'ВГТУ',1,'Воронежский государственный технический университет', 'https://cchgeu.ru', 'rectorat@vgasu.vrn.ru',  'ул. 20-летия Октября, 84');
INSERT INTO matcher.organizations (org_id, name, org_type_id, description, url, email, address) VALUES (2, 'ВГУ',1,'Воронежский государственный университет', 'https://www.vsu.ru', 'test@vsu.ru',  'Университетская площадь, 1');
INSERT INTO matcher.organizations (org_id, name, org_type_id, description, url, email, address) VALUES (3, 'Neoflex',2,'The best company in the world', 'www.neoflex.ru', 'test@neoflex.ru',  'ул. Ленина, 104Б');
INSERT INTO matcher.organizations (org_id, name, org_type_id, description, url, email, address) VALUES (4, 'NetCracker',2,'Good company', 'www.netcracker.ru', 'test@netcracker.ru',  'ул. Беляшена, 108У');

INSERT INTO matcher.users (user_id, login, password, first_name, last_name, second_name, email, phone, user_type_id) VALUES (1, 'patch11k','$2a$10$LnCs.XCEWwGhOEL9xMVVLu.k1yW5uLTlN6syVebPEmYDKetX4AtlS','Николай', 'Евсюков', 'Эдуардович',  'paj@gmail.com', '88005553531', 1);
INSERT INTO matcher.users (user_id, login, password, first_name, last_name, second_name, email, phone, user_type_id) VALUES (2, 'Formeys','$2a$10$LnCs.XCEWwGhOEL9xMVVLu.k1yW5uLTlN6syVebPEmYDKetX4AtlS','Илья', 'Новичихин', 'Сергеевич',  'formmm@gmail.com', '89015253532', 1);
INSERT INTO matcher.users (user_id, login, password, first_name, last_name, second_name, email, phone, user_type_id) VALUES (3, 'KoM','$2a$10$LnCs.XCEWwGhOEL9xMVVLu.k1yW5uLTlN6syVebPEmYDKetX4AtlS','Максим', 'Щербаков', 'Артёмович',  'artiom@gmail.com', '89015878322', 2);
INSERT INTO matcher.users (user_id, login, password, first_name, last_name, second_name, email, phone, user_type_id) VALUES (4, 'anDreY2008','$2a$10$LnCs.XCEWwGhOEL9xMVVLu.k1yW5uLTlN6syVebPEmYDKetX4AtlS','Андрей', 'Скачков', 'Андреевич',  'anekdottv@gmail.com', '87017778727', 2);

INSERT INTO matcher.user_organizations (user_id, org_id, start_date, end_date, is_admin) VALUES (1, 1, '2021-08-31', '2021-09-29', false);
INSERT INTO matcher.user_organizations (user_id, org_id, start_date, end_date, is_admin) VALUES (2, 2, '2021-08-31', '2021-09-29', false);
INSERT INTO matcher.user_organizations (user_id, org_id, start_date, end_date, is_admin) VALUES (3, 3, '2021-08-31', '2021-09-29', false);
INSERT INTO matcher.user_organizations (user_id, org_id, start_date, end_date, is_admin) VALUES (4, 4, '2021-08-31', '2021-09-29', false);

INSERT INTO matcher.projects (project_id, name, description, is_active) VALUES (1, 'matcher','Лучший проект',true);
INSERT INTO matcher.projects (project_id, name, description, is_active) VALUES (2, '1Ybit','Сервис ставок',false);
INSERT INTO matcher.projects (project_id, name, description, is_active) VALUES (3, 'schedule','Сервис составления расписаний занятий',false);
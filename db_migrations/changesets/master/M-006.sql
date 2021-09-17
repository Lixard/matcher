INSERT INTO matcher.organizations (name, org_type_id, description, url, email, address) VALUES ('ВГТУ',1,'Воронежский государственный технический университет', 'https://cchgeu.ru', 'rectorat@vgasu.vrn.ru',  'ул. 20-летия Октября, 84');
INSERT INTO matcher.organizations (name, org_type_id, description, url, email, address) VALUES ('ВГУ',1,'Воронежский государственный университет', 'https://www.vsu.ru', 'test@vsu.ru',  'Университетская площадь, 1');
INSERT INTO matcher.organizations (name, org_type_id, description, url, email, address) VALUES ('Neoflex',2,'The best company in the world', 'www.neoflex.ru', 'test@neoflex.ru',  'ул. Ленина, 104Б');
INSERT INTO matcher.organizations (name, org_type_id, description, url, email, address) VALUES ('NetCracker',2,'Good company', 'www.netcracker.ru', 'test@netcracker.ru',  'ул. Беляшена, 108У');

INSERT INTO matcher.users (login, password, first_name, last_name, second_name, email, phone, user_type_id) VALUES ('patch11k','$2a$10$LnCs.XCEWwGhOEL9xMVVLu.k1yW5uLTlN6syVebPEmYDKetX4AtlS','Николай', 'Евсюков', 'Эдуардович',  'paj@gmail.com', '88005553531', 1);
INSERT INTO matcher.users (login, password, first_name, last_name, second_name, email, phone, user_type_id) VALUES ('Formeys','$2a$10$LnCs.XCEWwGhOEL9xMVVLu.k1yW5uLTlN6syVebPEmYDKetX4AtlS','Илья', 'Новичихин', 'Сергеевич',  'formmm@gmail.com', '89015253532', 1);
INSERT INTO matcher.users (login, password, first_name, last_name, second_name, email, phone, user_type_id) VALUES ('KoM','$2a$10$LnCs.XCEWwGhOEL9xMVVLu.k1yW5uLTlN6syVebPEmYDKetX4AtlS','Максим', 'Щербаков', 'Артёмович',  'artiom@gmail.com', '89015878322', 2);
INSERT INTO matcher.users (login, password, first_name, last_name, second_name, email, phone, user_type_id) VALUES ('anDreY2008','$2a$10$LnCs.XCEWwGhOEL9xMVVLu.k1yW5uLTlN6syVebPEmYDKetX4AtlS','Андрей', 'Скачков', 'Андреевич',  'anekdottv@gmail.com', '87017778727', 2);

INSERT INTO matcher.projects (name, description, is_active) VALUES ('matcher','Лучший проект',true);
INSERT INTO matcher.projects (name, description, is_active) VALUES ('1Ybit','Сервис ставок',false);
INSERT INTO matcher.projects (name, description, is_active) VALUES ('schedule','Сервис составления расписаний занятий',false);
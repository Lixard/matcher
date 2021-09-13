INSERT INTO matcher.organizations (name, org_type_id, description, url, email, address) VALUES ('ВГТУ',1,'Воронежский государственный технический университет', 'https://cchgeu.ru', 'rectorat@vgasu.vrn.ru',  'ул. 20-летия Октября, 84');
INSERT INTO matcher.organizations (name, org_type_id, description, url, email, address) VALUES ('ВГУ',1,'Воронежский государственный университет', 'https://www.vsu.ru', 'test@vsu.ru',  'Университетская площадь, 1');
INSERT INTO matcher.organizations (name, org_type_id, description, url, email, address) VALUES ('Neoflex',2,'The best company in the world', 'www.neoflex.ru', 'test@neoflex.ru',  'ул. Ленина, 104Б');
INSERT INTO matcher.organizations (name, org_type_id, description, url, email, address) VALUES ('NetCracker',2,'Good company', 'www.netcracker.ru', 'test@netcracker.ru',  'ул. Беляшена, 108У');

INSERT INTO matcher.users (login, password, first_name, last_name, second_name, email, phone) VALUES ('patch11k','123','Николай', 'Евсюков', 'Эдуардович',  'paj@gmail.com', 88005553531);
INSERT INTO matcher.users (login, password, first_name, last_name, second_name, email, phone) VALUES ('Formeys','1234','Илья', 'Новичихин', 'Сергеевич',  'formmm@gmail.com', 89015253532);
INSERT INTO matcher.users (login, password, first_name, last_name, second_name, email, phone) VALUES ('KoM','1234555','Максим', 'Щербаков', 'Артёмович',  'artiom@gmail.com', 89015878322);
INSERT INTO matcher.users (login, password, first_name, last_name, second_name, email, phone) VALUES ('anDreY2008','qwerty','Андрей', 'Скачков', 'Андреевич',  'anekdottv@gmail.com', 87017778727);

INSERT INTO matcher.projects (name, description, is_active) VALUES ('matcher','Лучший проект',true);
INSERT INTO matcher.projects (name, description, is_active) VALUES ('1Ybit','Сервис ставок',false);
INSERT INTO matcher.projects (name, description, is_active) VALUES ('schedule','Сервис составления расписаний занятий',false);
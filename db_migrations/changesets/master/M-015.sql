ALTER TABLE matcher.projects ADD COLUMN lifecycle varchar(700) default 'Анализ,Проектирование,Разработка,Баг-фикс,Завершение';
ALTER TABLE matcher.projects ADD COLUMN current_lifecycle varchar(200) default 'Анализ';

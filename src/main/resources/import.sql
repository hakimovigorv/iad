INSERT INTO roles(id, name) VALUES(1, 'USER');
INSERT INTO roles(id, name) VALUES(2, 'CERTIFIED');

INSERT INTO users(login , password, first_name, last_name, certified) values ('anton', '1234', 'igor', 'akimbo', false);

insert into user_roles VALUES (1,1);


insert into tasks(text, title) values ('текст задания 1', 'заголовок задания 1');

insert into tasks(text, title) values ('текст задания 2', 'заголовок задания 2');

insert into graphs ("date", "value", task_id) values ('2011-05-16 15:36:38', 1001, 1);
insert into graphs ("date", "value", task_id) values ('2011-05-16 15:37:38', 1002, 1);
insert into graphs ("date", "value", task_id) values ('2011-05-16 15:38:38', 1003, 1);
insert into graphs ("date", "value", task_id) values ('2011-05-16 15:39:38', 1004, 1);
insert into graphs ("date", "value", task_id) values ('2011-05-16 15:40:38', 1005, 1);
insert into graphs ("date", "value", task_id) values ('2011-05-16 15:41:38', 1006, 1);
insert into graphs ("date", "value", task_id) values ('2011-05-16 15:42:38', 1002, 1);
insert into graphs ("date", "value", task_id) values ('2011-05-16 15:43:38', 1001, 1);
insert into graphs ("date", "value", task_id) values ('2011-05-16 15:36:38', 3001, 2);
insert into graphs ("date", "value", task_id) values ('2011-05-16 15:36:38', 3002, 2);
insert into graphs ("date", "value", task_id) values ('2011-05-16 15:36:38', 3003, 2);
insert into graphs ("date", "value", task_id) values ('2011-05-16 15:36:38', 3004, 2);
insert into graphs ("date", "value", task_id) values ('2011-05-16 15:36:38', 2805, 2);
insert into graphs ("date", "value", task_id) values ('2011-05-16 15:36:38', 2506, 2);
insert into graphs ("date", "value", task_id) values ('2011-05-16 15:36:38', 2502, 2);
insert into graphs ("date", "value", task_id) values ('2011-05-16 15:36:38', 2501, 2);

insert into news ("date", text, title, task_id) values ('2011-05-16 15:36:38', 'текст новости 1', 'Заголовок новости 1' , 1);
insert into news ("date", text, title, task_id) values ('2011-05-16 15:36:38', 'текст новости 2', 'Заголовок новости 2' , 1);
insert into news ("date", text, title, task_id) values ('2011-05-16 15:36:38', 'текст новости 3', 'Заголовок новости 3' , 1);
insert into news ("date", text, title, task_id) values ('2011-05-16 15:36:38', 'текст новости 1', 'Заголовок новости 1' , 2);
insert into news ("date", text, title, task_id) values ('2011-05-16 15:36:38', 'текст новости 2', 'Заголовок новости 2' , 2);
insert into news ("date", text, title ,task_id) values ('2011-05-16 15:36:38', 'текст новости 3', 'Заголовок новости 3' , 2);



insert into exam_tasks(text, title, answer) values ('текст задания 1', 'заголовок задания 1', 1);
insert into exam_tasks(text, title, answer) values ('текст задания 2', 'заголовок задания 2', 2);

insert into exam_graphs ("date", "value", exam_task_id) values ('2011-05-16 15:36:38', 1001, 1);
insert into exam_graphs ("date", "value", exam_task_id) values ('2011-05-16 15:37:38', 1002, 1);
insert into exam_graphs ("date", "value", exam_task_id) values ('2011-05-16 15:38:38', 1003, 1);
insert into exam_graphs ("date", "value", exam_task_id) values ('2011-05-16 15:39:38', 1004, 1);
insert into exam_graphs ("date", "value", exam_task_id) values ('2011-05-16 15:40:38', 1005, 1);
insert into exam_graphs ("date", "value", exam_task_id) values ('2011-05-16 15:41:38', 1006, 1);
insert into exam_graphs ("date", "value", exam_task_id) values ('2011-05-16 15:42:38', 1002, 1);
insert into exam_graphs ("date", "value", exam_task_id) values ('2011-05-16 15:43:38', 1001, 1);
insert into exam_graphs ("date", "value", exam_task_id) values ('2011-05-16 15:36:38', 3001, 2);
insert into exam_graphs ("date", "value", exam_task_id) values ('2011-05-16 15:36:38', 3002, 2);
insert into exam_graphs ("date", "value", exam_task_id) values ('2011-05-16 15:36:38', 3003, 2);
insert into exam_graphs ("date", "value", exam_task_id) values ('2011-05-16 15:36:38', 3004, 2);
insert into exam_graphs ("date", "value", exam_task_id) values ('2011-05-16 15:36:38', 2805, 2);
insert into exam_graphs ("date", "value", exam_task_id) values ('2011-05-16 15:36:38', 2506, 2);
insert into exam_graphs ("date", "value", exam_task_id) values ('2011-05-16 15:36:38', 2502, 2);
insert into exam_graphs ("date", "value", exam_task_id) values ('2011-05-16 15:36:38', 2501, 2);

insert into exam_news ("date", text, title, exam_task_id) values ('2011-05-16 15:36:38', 'текст новости 1', 'Заголовок новости 1' , 1);
insert into exam_news ("date", text, title, exam_task_id) values ('2011-05-16 15:36:38', 'текст новости 2', 'Заголовок новости 2' , 1);
insert into exam_news ("date", text, title, exam_task_id) values ('2011-05-16 15:36:38', 'текст новости 3', 'Заголовок новости 3' , 1);
insert into exam_news ("date", text, title, exam_task_id) values ('2011-05-16 15:36:38', 'текст новости 1', 'Заголовок новости 1' , 2);
insert into exam_news ("date", text, title, exam_task_id) values ('2011-05-16 15:36:38', 'текст новости 2', 'Заголовок новости 2' , 2);
insert into exam_news ("date", text, title ,exam_task_id) values ('2011-05-16 15:36:38', 'текст новости 3', 'Заголовок новости 3' , 2);




INSERT INTO tb_user (first_name, last_name, status_User, email, password, img_Profile, charge, id_Department, created_At, updaed_At)
VALUES ('Alex', 'Santos', 0, 'alex.santos@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'img.png', 'Gerente de Projeto', null, Now(), null);

INSERT INTO tb_user (first_name, last_name, status_User, email, password, img_Profile, charge, id_Department, created_At, updaed_At) 
VALUES ('Ana', 'Assis', 0, 'ana.assis@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'img.png', 'desenvolvedor pleno', null, Now(), null);

INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_OPER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_category (description) Values ('Sistemas');
INSERT INTO tb_category (description) Values ('Telefonia');
INSERT INTO tb_category (description) Values ('Infraestrutura');

INSERT INTO tb_client (name, city, country, address, zip, market_Segment) VALUES ('Americanas', null, null, null, null, null);
INSERT INTO tb_client (name, city, country, address, zip, market_Segment) VALUES ('JC construtoras', null, null, null, null, null);

INSERT INTO tb_project (budget, description, due_data, img_url, initial_date, invoicing, name, owner_id, status, category_id, client_id) VALUES (15000.0, 'projeto de desenvovimento de um e-cormmece', '2023-09-12', 'icon', '2023-10-15', 30000.0, 'Sales E-com', 1, 0, 1, 1);

INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'desenho do sistema ', '2023-04-29', 'Esboço', 0, 1, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'diagrama de classe ', '2023-04-29', 'Esboço', 0, 1, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'desenvolvimento do front ', '2023-04-29', 'Esboço', 0, 1, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'backend ', '2023-04-29', 'Esboço', 0, 1, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'criação do banco de dados ', '2023-04-29', 'Esboço', 0, 1, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'implantação do DB teste ', '2023-04-29', 'Esboço', 0, 1, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'integração frontend/backend', '2023-04-29', 'Esboço', 0, 1, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'teste unitarios  ', '2023-04-29', 'Esboço', 3, 1, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'Infraestrutura para implantação' , '2023-04-29', 'Esboço', 3, 1, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'implantação PROD', '2023-04-29', 'Esboço', 3, 1, 1);

INSERT INTO tb_project (budget, description, due_data, img_url, initial_date, invoicing, name, owner_id, status, category_id, client_id) VALUES (27000.0, 'Desenvolvimento de um Data Center', '2024-03-09', 'icon', '2023-11-10', 56000.0, 'Data Center', 1, 0, 3, 2);

INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'Infraestrutura ', '2023-04-29', 'Esboço', 0, 2, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'Infraestrutura ', '2023-04-29', 'Esboço', 0, 2, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'Infraestrutura ', '2023-04-29', 'Esboço', 3, 2, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'Infraestrutura ', '2023-04-29', 'Esboço', 3, 2, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'Infraestrutura ', '2023-04-29', 'Esboço', 3, 2, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'Infraestrutura ', '2023-04-29', 'Esboço', 3, 2, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'Infraestrutura', '2023-04-29', 'Esboço', 3, 2, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'Infraestrutura  ', '2023-04-29', 'Esboço', 3, 2, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'Infraestrutura para implantação' , '2023-04-29', 'Esboço', 3, 2, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'Infraestrutura', '2023-04-29', 'Esboço', 3, 2, 1);


INSERT INTO tb_project (budget, description, due_data, img_url, initial_date, invoicing, name, owner_id, status, category_id, client_id) VALUES (27000.0, 'Montagem de um IA', '2024-03-09', 'icon', '2023-11-10', 56000.0, 'Data Center', 1, 0, 3, 2);

INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'Infraestrutura ', '2023-04-29', 'Esboço', 0, 2, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'Infraestrutura ', '2023-04-29', 'Esboço', 0, 2, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'Infraestrutura ', '2023-04-29', 'Esboço', 3, 2, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'Infraestrutura ', '2023-04-29', 'Esboço', 3, 2, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'Infraestrutura ', '2023-04-29', 'Esboço', 3, 2, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'Infraestrutura ', '2023-04-29', 'Esboço', 3, 2, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'Infraestrutura', '2023-04-29', 'Esboço', 3, 2, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'Infraestrutura  ', '2023-04-29', 'Esboço', 3, 2, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'Infraestrutura para implantação' , '2023-04-29', 'Esboço', 3, 2, 1);
INSERT INTO tb_task (data_initial, description, due_data, name, status, id_project, id_user) VALUES ('2023-04-15', 'Infraestrutura', '2023-04-29', 'Esboço', 3, 2, 1);



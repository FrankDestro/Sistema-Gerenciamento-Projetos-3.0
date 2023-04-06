
INSERT INTO tb_user (first_name, last_name, status_User, email, password, img_Profile, charge, id_Department, created_At, updaed_At)
VALUES ('Alex', 'Santos', 0, 'alex.santos@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'img.png', 'Gerente de Projeto', null, Now(), null);

INSERT INTO tb_user (first_name, last_name, status_User, email, password, img_Profile, charge, id_Department, created_At, updaed_At) 
VALUES ('Ana', 'Assis', 0, 'ana.assis@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'img.png', 'desenvolvedor pleno', null, Now(), null);

INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_OPER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

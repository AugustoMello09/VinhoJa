INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user (id, nome, email, senha) VALUES ('01e48abe-63b9-11ee-8c99-0242ac120002','usuario','usuario@gmail.com','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (id, nome, email, senha) VALUES ('1344e510-63b9-11ee-8c99-0242ac120002','adm','adm@gmail.com','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_user_role (user_id, role_id) VALUES ('01e48abe-63b9-11ee-8c99-0242ac120002', 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES ('1344e510-63b9-11ee-8c99-0242ac120002', 2);
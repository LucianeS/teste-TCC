-- USER
INSERT INTO USER(ID, EMAIL, NOME, SOBRENOME, SENHA, INSTITUICAO) VALUES (1, '123@123.123', 'General User', 'da Silva', '$2a$10$cy42kPdxwRGcrx02umaL3O7f7xUKXQtugjXLrM9/DNay.D.WNK3HC','IFRS');
INSERT INTO USER(ID, EMAIL, NOME, SOBRENOME, SENHA, INSTITUICAO) VALUES (2, 'admin@123.123', 'Admin', 'Barbosa', '$2a$10$cy42kPdxwRGcrx02umaL3O7f7xUKXQtugjXLrM9/DNay.D.WNK3HC','IfSul');
INSERT INTO USER(ID, EMAIL, NOME, SOBRENOME, SENHA, INSTITUICAO) VALUES (3, 'ana@123.123', 'Ana Correa', 'dos Santos', '$2a$10$cy42kPdxwRGcrx02umaL3O7f7xUKXQtugjXLrM9/DNay.D.WNK3HC', 'UFRGS');


-- ROLES
insert into roles(id, role) values (1, 'ROLE_USER');
insert into roles(id, role) values (2, 'ROLE_ADMIN');

-- USER_ROLES
insert into users_roles (user_id, role_id) values (1, 1);
insert into users_roles (user_id, role_id) values (2, 2);
insert into users_roles (user_id, role_id) values (3, 1);
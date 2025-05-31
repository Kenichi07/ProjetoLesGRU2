-- ========================
-- Tabela estado
-- ========================
insert into estado (id, nome, sigla) VALUES (1, "São Paulo", "SP");
insert into estado (id, nome, sigla) VALUES (2, "Minas Gerais", "MG");
insert into estado (id, nome, sigla) VALUES (3, "Rio de Janeiro", "RJ");

-- ========================
-- Tabela cidade
-- ========================
insert into cidade (id, nome, estado_id) VALUES (1, "São Paulo", 1);
insert into cidade (id, nome, estado_id) VALUES (2, "Campinas", 1);
insert into cidade (id, nome, estado_id) VALUES (3, "Belo Horizonte", 2);
insert into cidade (id, nome, estado_id) VALUES (4, "Rio de Janeiro", 3);
insert into cidade (id, nome, estado_id) VALUES (5, "Niterói", 3);

-- ========================
-- Tabela categoria
-- ========================
insert into categoria (id, nome) VALUES (1, "Tecnologia");
insert into categoria (id, nome) VALUES (2, "Construção");
insert into categoria (id, nome) VALUES (3, "Educação");
insert into categoria (id, nome) VALUES (4, "Beleza");
insert into categoria (id, nome) VALUES (5, "Saúde");

-- ========================
-- Tabela usuario
-- ========================
insert into usuario (id, nome, email, senha) VALUES (1, "Ana Silva", "ana@email.com", "senha123");
insert into usuario (id, nome, email, senha) VALUES (2, "Bruno Souza", "bruno@email.com", "senha123");
insert into usuario (id, nome, email, senha) VALUES (3, "Carlos Lima", "carlos@email.com", "senha123");
insert into usuario (id, nome, email, senha) VALUES (4, "Débora Almeida", "debora@email.com", "senha123");
insert into usuario (id, nome, email, senha) VALUES (5, "Eduarda Costa", "eduarda@email.com", "senha123");
insert into usuario (id, nome, email, senha) VALUES (6, "Fernando Rocha", "fernando@email.com", "senha123");

-- ========================
-- Tabela administrador
-- ========================
insert into administrador (id) VALUES (1);

-- ========================
-- Tabela consumidor_servico
-- ========================
insert into consumidor_servico (id) VALUES (2);
insert into consumidor_servico (id) VALUES (5);

-- ========================
-- Tabela prestador_servico
-- ========================
insert into prestador_servico (id, whatsapp) VALUES (3, "11999998888");
insert into prestador_servico (id, whatsapp) VALUES (4, "11988887777");
insert into prestador_servico (id, whatsapp) VALUES (6, "21977776666");

-- ========================
-- Tabela curso
-- ========================
insert into curso (id, nome, descricao, link_curso, categoria_id) VALUES (1, "Java Básico", "Curso de introdução ao Java", "http://cursojava.com", 1);

insert into curso (id, nome, descricao, link_curso, categoria_id) VALUES (2, "Elétrica Residencial", "Aprenda elétrica básica", "http://cursoeletrica.com", 2);

insert into curso (id, nome, descricao, link_curso, categoria_id) VALUES (3, "Marketing Digital", "Curso de marketing online", "http://cursomarketing.com", 3);

insert into curso (id, nome, descricao, link_curso, categoria_id) VALUES (4, "Design de Sobrancelhas", "Curso para estética facial", "http://cursoestetica.com", 4);

insert into curso (id, nome, descricao, link_curso, categoria_id) VALUES (5, "Primeiros Socorros", "Curso de primeiros socorros", "http://cursosaude.com", 5);

-- ========================
-- Tabela servico
-- ========================
insert into servico (id, nome, descricao, valor, prestadorservico_id, categoria_id) VALUES (1, "Desenvolvimento Web", "Criação de sites responsivos", 1500.00, 3, 1);

insert into servico (id, nome, descricao, valor, prestadorservico_id, categoria_id) VALUES (2, "Serviço de Pintura", "Pintura residencial e comercial", 800.00, 4, 2);

insert into servico (id, nome, descricao, valor, prestadorservico_id, categoria_id) VALUES (3, "Manutenção Elétrica", "Serviços elétricos residenciais", 600.00, 4, 2);

insert into servico (id, nome, descricao, valor, prestadorservico_id, categoria_id) VALUES (4, "Design de Sobrancelhas", "Modelagem e design facial", 200.00, 6, 4);

insert into servico (id, nome, descricao, valor, prestadorservico_id, categoria_id) VALUES (5, "Treinamento Funcional", "Aulas presenciais de funcional", 500.00, 6, 5);

-- ========================
-- Tabela cursos_favoritos
-- ========================
insert into cursos_favoritos (cufa_usu_id, cufa_cur_id) VALUES (2, 1);
insert into cursos_favoritos (cufa_usu_id, cufa_cur_id) VALUES (2, 3);
insert into cursos_favoritos (cufa_usu_id, cufa_cur_id) VALUES (5, 4);
insert into cursos_favoritos (cufa_usu_id, cufa_cur_id) VALUES (5, 5);

-- ========================
-- Tabela servicos_cidades
-- ========================
INSERT INTO servicos_cidades (seci_ser_id, seci_cid_id) VALUES (1, 1);
INSERT INTO servicos_cidades (seci_ser_id, seci_cid_id) VALUES (1, 2);
INSERT INTO servicos_cidades (seci_ser_id, seci_cid_id) VALUES (2, 3);
INSERT INTO servicos_cidades (seci_ser_id, seci_cid_id) VALUES (3, 3);
INSERT INTO servicos_cidades (seci_ser_id, seci_cid_id) VALUES (4, 4);
INSERT INTO servicos_cidades (seci_ser_id, seci_cid_id) VALUES (5, 5);

-- ========================
-- Tabela servicos_favoritos
-- ========================
INSERT INTO servicos_favoritos (sefa_con_usu_id, sefa_ser_id) VALUES (2, 1);
INSERT INTO servicos_favoritos (sefa_con_usu_id, sefa_ser_id) VALUES (2, 2);
INSERT INTO servicos_favoritos (sefa_con_usu_id, sefa_ser_id) VALUES (5, 4);
INSERT INTO servicos_favoritos (sefa_con_usu_id, sefa_ser_id) VALUES (5, 5);

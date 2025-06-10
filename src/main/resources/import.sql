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

insert into curso (id, nome, descricao, link_curso, categoria_id) VALUES (2, "Java Avançado", "Curso de aprofundamento nos conceitos de Java", "http://cursojavaavancado.com", 1);


insert into curso (id, nome, descricao, link_curso, categoria_id) VALUES (3, "Elétrica Residencial", "Aprenda elétrica básica", "http://cursoeletrica.com", 2);

insert into curso (id, nome, descricao, link_curso, categoria_id) VALUES (4, "Marketing Digital", "Curso de marketing online", "http://cursomarketing.com", 3);

insert into curso (id, nome, descricao, link_curso, categoria_id) VALUES (5, "Design de Sobrancelhas", "Curso para estética facial", "http://cursoestetica.com", 4);

insert into curso (id, nome, descricao, link_curso, categoria_id) VALUES (6, "Primeiros Socorros", "Curso de primeiros socorros", "http://cursosaude.com", 5);

-- ========================
-- Tabela servico
-- ========================
insert into servico (id, nome, descricao, valor, cidade_id, prestadorservico_id, categoria_id) VALUES (1, "Desenvolvimento Web", "Criação de sites responsivos", 1500.00, 1, 3, 1);

insert into servico (id, nome, descricao, valor, cidade_id, prestadorservico_id, categoria_id) VALUES (2, "Serviço de Pintura", "Pintura residencial e comercial", 800.00, 1, 4, 2);

insert into servico (id, nome, descricao, valor, cidade_id, prestadorservico_id, categoria_id) VALUES (3, "Manutenção Elétrica", "Serviços elétricos residenciais", 600.00, 1, 4, 2);

insert into servico (id, nome, descricao, valor, cidade_id, prestadorservico_id, categoria_id) VALUES (4, "Design de Sobrancelhas", "Modelagem e design facial", 200.00, 1, 6, 4);

insert into servico (id, nome, descricao, valor, cidade_id,prestadorservico_id, categoria_id) VALUES (5, "Treinamento Funcional", "Aulas presenciais de funcional", 500.00, 1, 6, 5);

insert into servico (id, nome, descricao, valor, cidade_id, prestadorservico_id, categoria_id) VALUES (6, "Desenvolvimento Mobile", "Criação de aplicativos Android e iOS", 2000.00, 2, 3, 1);

insert into servico (id, nome, descricao, valor, cidade_id, prestadorservico_id, categoria_id) VALUES (7, "Reforma de Banheiro", "Modernização e reforma completa de banheiros", 2500.00, 3, 4, 2);
insert into servico (id, nome, descricao, valor, cidade_id, prestadorservico_id, categoria_id) VALUES (8, "Aulas de Inglês", "Curso de inglês para todos os níveis", 300.00, 5, 6, 3);

insert into servico (id, nome, descricao, valor, cidade_id, prestadorservico_id, categoria_id) VALUES (9, "Corte de Cabelo Masculino", "Corte clássico e moderno para homens", 80.00, 2, 3, 4);

insert into servico (id, nome, descricao, valor, cidade_id, prestadorservico_id, categoria_id) VALUES (10, "Consultoria Nutricional", "Orientação alimentar personalizada", 400.00, 3, 4, 5);

insert into servico (id, nome, descricao, valor, cidade_id, prestadorservico_id, categoria_id) VALUES (11, "Manutenção de Computadores", "Formatação, instalação de softwares e limpeza", 250.00, 4, 6, 1);

insert into servico (id, nome, descricao, valor, cidade_id, prestadorservico_id, categoria_id) VALUES (12, "Instalação de Piso", "Serviço especializado em instalação de pisos laminados", 1200.00, 4, 3, 2);

insert into servico (id, nome, descricao, valor, cidade_id, prestadorservico_id, categoria_id) VALUES (13, "Reforço Escolar", "Aulas de reforço para ensino fundamental", 200.00, 4, 4, 3);

insert into servico (id, nome, descricao, valor, cidade_id, prestadorservico_id, categoria_id) VALUES (14, "Maquiagem Profissional", "Maquiagem para eventos e festas", 250.00, 5, 6, 4);

insert into servico (id, nome, descricao, valor, cidade_id, prestadorservico_id, categoria_id) VALUES (15, "Personal Trainer", "Acompanhamento presencial para treinos", 700.00, 5, 3, 5);


-- ========================
-- Tabela cursos_favoritos
-- ========================
insert into curso_favorito (usuario_id, curso_id) VALUES (2, 1);
insert into curso_favorito (usuario_id, curso_id) VALUES (2, 3);
insert into curso_favorito (usuario_id, curso_id) VALUES (5, 4);
insert into curso_favorito (usuario_id, curso_id) VALUES (5, 5);


-- ========================
-- Tabela servicos_favoritos
-- ========================
INSERT INTO servico_favorito (usuario_id, servico_id) VALUES (2, 1);
INSERT INTO servico_favorito (usuario_id, servico_id) VALUES (2, 2);
INSERT INTO servico_favorito (usuario_id, servico_id) VALUES (5, 4);
INSERT INTO servico_favorito (usuario_id, servico_id) VALUES (5, 5);

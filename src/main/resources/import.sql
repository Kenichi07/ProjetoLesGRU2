-- ========================
-- Tabela estado
-- ========================
INSERT INTO estado (id, nome, sigla) VALUES (1, 'Acre', 'AC');
INSERT INTO estado (id, nome, sigla) VALUES (2, 'Alagoas', 'AL');
INSERT INTO estado (id, nome, sigla) VALUES (3, 'Amapá', 'AP');
INSERT INTO estado (id, nome, sigla) VALUES (4, 'Amazonas', 'AM');
INSERT INTO estado (id, nome, sigla) VALUES (5, 'Bahia', 'BA');
INSERT INTO estado (id, nome, sigla) VALUES (6, 'Ceará', 'CE');
INSERT INTO estado (id, nome, sigla) VALUES (7, 'Distrito Federal', 'DF');
INSERT INTO estado (id, nome, sigla) VALUES (8, 'Espírito Santo', 'ES');
INSERT INTO estado (id, nome, sigla) VALUES (9, 'Goiás', 'GO');
INSERT INTO estado (id, nome, sigla) VALUES (10, 'Maranhão', 'MA');
INSERT INTO estado (id, nome, sigla) VALUES (11, 'Mato Grosso', 'MT');
INSERT INTO estado (id, nome, sigla) VALUES (12, 'Mato Grosso do Sul', 'MS');
INSERT INTO estado (id, nome, sigla) VALUES (13, 'Minas Gerais', 'MG');
INSERT INTO estado (id, nome, sigla) VALUES (14, 'Pará', 'PA');
INSERT INTO estado (id, nome, sigla) VALUES (15, 'Paraíba', 'PB');
INSERT INTO estado (id, nome, sigla) VALUES (16, 'Paraná', 'PR');
INSERT INTO estado (id, nome, sigla) VALUES (17, 'Pernambuco', 'PE');
INSERT INTO estado (id, nome, sigla) VALUES (18, 'Piauí', 'PI');
INSERT INTO estado (id, nome, sigla) VALUES (19, 'Rio de Janeiro', 'RJ');
INSERT INTO estado (id, nome, sigla) VALUES (20, 'Rio Grande do Norte', 'RN');
INSERT INTO estado (id, nome, sigla) VALUES (21, 'Rio Grande do Sul', 'RS');
INSERT INTO estado (id, nome, sigla) VALUES (22, 'Rondônia', 'RO');
INSERT INTO estado (id, nome, sigla) VALUES (23, 'Roraima', 'RR');
INSERT INTO estado (id, nome, sigla) VALUES (24, 'Santa Catarina', 'SC');
INSERT INTO estado (id, nome, sigla) VALUES (25, 'São Paulo', 'SP');
INSERT INTO estado (id, nome, sigla) VALUES (26, 'Sergipe', 'SE');
INSERT INTO estado (id, nome, sigla) VALUES (27, 'Tocantins', 'TO');


-- ========================
-- Tabela cidade
-- ========================
INSERT INTO cidade (id, nome, estado_id) VALUES (1, 'São Paulo', 25);        
INSERT INTO cidade (id, nome, estado_id) VALUES (2, 'Campinas', 25);     
INSERT INTO cidade (id, nome, estado_id) VALUES (3, 'Belo Horizonte', 13);
INSERT INTO cidade (id, nome, estado_id) VALUES (4, 'Rio de Janeiro', 19);    
INSERT INTO cidade (id, nome, estado_id) VALUES (5, 'Niterói', 19);          


-- ========================
-- Tabela categoria
-- ========================
insert into categoria (id, nome) VALUES (1, "Tecnologia");
insert into categoria (id, nome) VALUES (2, "Construção");
insert into categoria (id, nome) VALUES (3, "Educação");
insert into categoria (id, nome) VALUES (4, "Beleza");
insert into categoria (id, nome) VALUES (5, "Saúde");
insert into categoria (id, nome) VALUES (6, "Automotivo");
insert into categoria (id, nome) VALUES (7, "Administração");
insert into categoria (id, nome) VALUES (8, "Eventos");

-- ========================
-- Tabela usuario
-- ========================
insert into usuario (id, nome, email, senha) VALUES (1, "admin", "admin@email.com", "senha123");
insert into usuario (id, nome, email, senha) VALUES (2, "Bruno Souza", "bruno@email.com", "senha123");
insert into usuario (id, nome, email, senha) VALUES (3, "Carlos Lima", "carlos@email.com", "senha123");
insert into usuario (id, nome, email, senha) VALUES (4, "Débora Almeida", "debora@email.com", "senha123");
insert into usuario (id, nome, email, senha) VALUES (5, "Eduarda Costa", "eduarda@email.com", "senha123");
insert into usuario (id, nome, email, senha) VALUES (6, "Fernando Rocha", "fernando@email.com", "senha123");
insert into usuario (id, nome, email, senha) VALUES (7, "Helena Martins", "helena@email.com", "senha123");  
insert into usuario (id, nome, email, senha) VALUES (8, "Igor Teixeira", "igor@email.com", "senha123");     
insert into usuario (id, nome, email, senha) VALUES (9, "Juliana Freitas", "juliana@email.com", "senha123"); 
insert into usuario (id, nome, email, senha) VALUES (10, "Lucas Mendes", "lucas@email.com", "senha123");    
insert into usuario (id, nome, email, senha) VALUES (11, "Mariana Rocha", "mariana@email.com", "senha123");


-- ========================
-- Tabela administrador
-- ========================
insert into administrador (id) VALUES (1);

-- ========================
-- Tabela consumidor_servico
-- ========================
insert into consumidor_servico (id) VALUES (2);
insert into consumidor_servico (id) VALUES (5);
insert into consumidor_servico (id) VALUES (9);
insert into consumidor_servico (id) VALUES (10);
insert into consumidor_servico (id) VALUES (11);

-- ========================
-- Tabela prestador_servico
-- ========================
insert into prestador_servico (id, whatsapp) VALUES (3, "11999998888");
insert into prestador_servico (id, whatsapp) VALUES (4, "11988887777");
insert into prestador_servico (id, whatsapp) VALUES (6, "21977776666");
insert into prestador_servico (id, whatsapp) VALUES (7, "21955554444");
insert into prestador_servico (id, whatsapp) VALUES (8, "31944443333");

-- ========================
-- Tabela curso
-- ========================
insert into curso (id, nome, descricao, link_curso, categoria_id) VALUES (1, "Java Básico", "Curso de introdução ao Java", "http://cursojava.com", 1);
insert into curso (id, nome, descricao, link_curso, categoria_id) VALUES (2, "Java Avançado", "Curso de aprofundamento nos conceitos de Java", "http://cursojavaavancado.com", 1);
insert into curso (id, nome, descricao, link_curso, categoria_id) VALUES (3, "Elétrica Residencial", "Aprenda elétrica básica", "http://cursoeletrica.com", 2);
insert into curso (id, nome, descricao, link_curso, categoria_id) VALUES (4, "Marketing Digital", "Curso de marketing online", "http://cursomarketing.com", 3);
insert into curso (id, nome, descricao, link_curso, categoria_id) VALUES (5, "Design de Sobrancelhas", "Curso para estética facial", "http://cursoestetica.com", 4);
insert into curso (id, nome, descricao, link_curso, categoria_id) VALUES (6, "Primeiros Socorros", "Curso de primeiros socorros", "http://cursosaude.com", 5);
insert into curso (id, nome, descricao, link_curso, categoria_id) VALUES (7, "Programação Web", "Curso de desenvolvimento de sites e aplicações web", "http://cursoweb.com", 1);
insert into curso (id, nome, descricao, link_curso, categoria_id) VALUES (8, "Automação Residencial", "Aprenda a automatizar sua casa com tecnologia", "http://cursoautomacao.com", 2);
insert into curso (id, nome, descricao, link_curso, categoria_id) VALUES (9, "Gestão de Mídias Sociais", "Curso de gerenciamento de redes sociais para empresas", "http://cursomidias.com", 3);
insert into curso (id, nome, descricao, link_curso, categoria_id) VALUES (10, "Maquiagem Profissional", "Curso completo de maquiagem para diferentes ocasiões", "http://cursomaquiagem.com", 4);
insert into curso (id, nome, descricao, link_curso, categoria_id) VALUES (11, "Cuidados com Idosos", "Curso sobre cuidados e atenção à terceira idade", "http://cursocuidadoidosos.com", 5);

-- ========================
-- Tabela servico
-- ========================
insert into servico (id, nome, descricao, preco, cidade_id, prestadorservico_id, categoria_id) VALUES (1, "Desenvolvimento Web", "Criação de sites modernos, responsivos e otimizados para SEO", 1500.00, 1, 3, 1);
insert into servico (id, nome, descricao, preco, cidade_id, prestadorservico_id, categoria_id) VALUES (6, "Desenvolvimento Mobile", "Aplicativos nativos e híbridos para Android e iOS", 2000.00, 2, 3, 1);
insert into servico (id, nome, descricao, preco, cidade_id, prestadorservico_id, categoria_id) VALUES (11, "Suporte Técnico em Informática", "Manutenção, formatação e instalação de sistemas", 250.00, 4, 6, 1);
insert into servico (id, nome, descricao, preco, cidade_id, prestadorservico_id, categoria_id) VALUES (16, "Design Gráfico", "Criação de logotipos, banners e identidade visual", 500.00, 1, 8, 1);
insert into servico (id, nome, descricao, preco, cidade_id, prestadorservico_id, categoria_id) VALUES (2, "Pintura Residencial", "Pintura de casas, apartamentos e áreas comerciais", 800.00, 1, 4, 2);
insert into servico (id, nome, descricao, preco, cidade_id, prestadorservico_id, categoria_id) VALUES (3, "Serviços Elétricos", "Instalações, reparos e manutenção elétrica", 600.00, 1, 4, 2);
insert into servico (id, nome, descricao, preco, cidade_id, prestadorservico_id, categoria_id) VALUES (7, "Reforma de Banheiro", "Reformas completas com acabamento de qualidade", 2500.00, 3, 4, 2);
insert into servico (id, nome, descricao, preco, cidade_id, prestadorservico_id, categoria_id) VALUES (12, "Instalação de Pisos", "Colocação de pisos laminados e vinílicos", 1200.00, 4, 3, 2);
insert into servico (id, nome, descricao, preco, cidade_id, prestadorservico_id, categoria_id) VALUES (17, "Instalações Elétricas Prediais", "Projetos e execuções em obras e reformas", 700.00, 2, 8, 2);
insert into servico (id, nome, descricao, preco, cidade_id, prestadorservico_id, categoria_id) VALUES (8, "Aulas de Inglês", "Inglês do básico ao avançado com foco em conversação", 300.00, 5, 6, 3);
insert into servico (id, nome, descricao, preco, cidade_id, prestadorservico_id, categoria_id) VALUES (13, "Reforço Escolar", "Aulas de apoio em matemática, português e ciências", 200.00, 4, 4, 3);
insert into servico (id, nome, descricao, preco, cidade_id, prestadorservico_id, categoria_id) VALUES (18, "Aulas de Português", "Revisão gramatical, redação e leitura crítica", 300.00, 3, 8, 3);
insert into servico (id, nome, descricao, preco, cidade_id, prestadorservico_id, categoria_id) VALUES (4, "Design de Sobrancelhas", "Harmonização facial por meio do design de sobrancelhas", 200.00, 1, 6, 4);
insert into servico (id, nome, descricao, preco, cidade_id, prestadorservico_id, categoria_id) VALUES (9, "Barbearia Masculina", "Corte clássico, moderno e cuidados com a barba", 80.00, 2, 3, 4);
insert into servico (id, nome, descricao, preco, cidade_id, prestadorservico_id, categoria_id) VALUES (14, "Maquiagem Profissional", "Maquiagem para festas, eventos e noivas", 250.00, 5, 6, 4);
insert into servico (id, nome, descricao, preco, cidade_id, prestadorservico_id, categoria_id) VALUES (19, "Depilação Corporal", "Depilação com cera quente e fria para todas as áreas", 250.00, 4, 8, 4);
insert into servico (id, nome, descricao, preco, cidade_id, prestadorservico_id, categoria_id) VALUES (5, "Treinamento Funcional", "Treinos personalizados para condicionamento físico", 500.00, 1, 6, 5);
insert into servico (id, nome, descricao, preco, cidade_id, prestadorservico_id, categoria_id) VALUES (10, "Consulta com Nutricionista", "Plano alimentar individualizado para seus objetivos", 400.00, 3, 4, 5);
insert into servico (id, nome, descricao, preco, cidade_id, prestadorservico_id, categoria_id) VALUES (15, "Personal Trainer", "Treinamento supervisionado com foco em resultados", 700.00, 5, 3, 5);
insert into servico (id, nome, descricao, preco, cidade_id, prestadorservico_id, categoria_id) VALUES (20, "Massagem Relaxante", "Técnicas para relaxamento muscular e alívio de estresse", 200.00, 5, 8, 5);

-- ========================
-- Tabela cursos_favoritos
-- ========================
insert into curso_favorito (usuario_id, curso_id) VALUES (2, 1);
insert into curso_favorito (usuario_id, curso_id) VALUES (2, 3);
insert into curso_favorito (usuario_id, curso_id) VALUES (5, 4);
insert into curso_favorito (usuario_id, curso_id) VALUES (5, 5);
insert into curso_favorito (usuario_id, curso_id) VALUES (3, 2);
insert into curso_favorito (usuario_id, curso_id) VALUES (3, 11);
insert into curso_favorito (usuario_id, curso_id) VALUES (3, 6);
insert into curso_favorito (usuario_id, curso_id) VALUES (9, 7);
insert into curso_favorito (usuario_id, curso_id) VALUES (10, 8);
insert into curso_favorito (usuario_id, curso_id) VALUES (11, 1);
insert into curso_favorito (usuario_id, curso_id) VALUES (8, 10);
insert into curso_favorito (usuario_id, curso_id) VALUES (6, 4);
insert into curso_favorito (usuario_id, curso_id) VALUES (4, 6);

-- ========================
-- Tabela servicos_favoritos
-- ========================
INSERT INTO servico_favorito (usuario_id, servico_id) VALUES (2, 1);
INSERT INTO servico_favorito (usuario_id, servico_id) VALUES (2, 2);
INSERT INTO servico_favorito (usuario_id, servico_id) VALUES (5, 4);
INSERT INTO servico_favorito (usuario_id, servico_id) VALUES (5, 5);
insert into servico_favorito (usuario_id, servico_id) VALUES (10, 6);  
insert into servico_favorito (usuario_id, servico_id) VALUES (10, 17); 
insert into servico_favorito (usuario_id, servico_id) VALUES (11, 2);   
insert into servico_favorito (usuario_id, servico_id) VALUES (9, 10); 

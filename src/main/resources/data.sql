-- ===================================
-- INSERTS para a tabela 'geradores'
-- ===================================
INSERT INTO geradores (nome, cnpj_cpf, endereco) VALUES
('Fábrica Alpha Ltda', '12345678000190', 'Rua Industrial, 100 - São Paulo/SP'),
('Restaurante Sabor Caseiro', '98765432000150', 'Av. Gastronomia, 50 - Rio de Janeiro/RJ'),
('Escritório Central de TI', '11223344000101', 'Alameda dos Dados, 123 - Curitiba/PR');


-- =====================================
-- INSERTS para a tabela 'cooperativas'
-- =====================================
INSERT INTO cooperativas (nome, tipo_residuo_aceito, localizacao) VALUES
('Coop Verde Reciclagem', 'Plástico, Papelão', 'Bairro Limpo, Setor A'),
('Mão Amiga Orgânicos', 'Resíduo Orgânico', 'Zona Rural, KM 5'),
('Metal Forte Descarte', 'Ferro, Cobre, Alumínio', 'Parque Industrial, Lote 5');


-- ==================================
-- INSERTS para a tabela 'residuos'
-- ==================================
INSERT INTO residuos (tipo_residuo, peso_ou_volume, unidade_medida, data_registro, status_residuo, localizacao, gerador_id) VALUES
-- Resíduos da Fábrica Alpha (id=1)
('Plástico Filme', 150.5, 0, NOW(), 1, 'Depósito 1', 1),  -- 150.5 KG, AGUARDANDO_COLETA (1)
('Óleo Contaminado', 30.0, 1, NOW(), 0, 'Área de Descarte', 1),   -- 30.0 L, GERADO (0)
('Sucata de Metal', 500.0, 0, NOW(), 2, 'Pátio Principal', 1),   -- 500.0 KG, COLETADO (2)

-- Resíduos do Restaurante Sabor Caseiro (id=2)
('Orgânico', 25.0, 0, NOW(), 1, 'Cozinha Fundos', 2),  -- 25.0 KG, AGUARDANDO_COLETA (1)
('Vidro Quebrado', 5.0, 0, NOW(), 3, 'Lixeira Externa', 2),     -- 5.0 KG, DESTINADO (3)

-- Resíduos do Escritório Central de TI (id=3)
('Papelão', 5.0, 0, NOW(), 0, 'Sala 301', 3);  -- 5.0 KG, GERADO (0)
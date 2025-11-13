-- Criação da tabela de Geradores
CREATE TABLE geradores (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    cnpj_cpf VARCHAR(14) UNIQUE NOT NULL,
    endereco VARCHAR(255)
);

-- Criação da tabela de Cooperativas
CREATE TABLE cooperativas (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    tipo_residuo_aceito VARCHAR(255),
    localizacao VARCHAR(255)
);

-- Criação da tabela de Resíduos
-- O campo 'status_residuo' e 'unidade_medida' são armazenados como INT (ordinal) conforme especificado nas entidades (@Enumerated(EnumType.ORDINAL))
CREATE TABLE residuos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    tipo_residuo VARCHAR(255) NOT NULL,
    peso_ou_volume DOUBLE NOT NULL,
    unidade_medida INT NOT NULL,  -- 0: KG, 1: L (exemplo, baseado na ordem da enum)
    data_registro DATETIME NOT NULL,
    status_residuo INT NOT NULL,  -- 0: GERADO, 1: AGUARDANDO_COLETA, 2: COLETADO, 3: DESTINADO
    localizacao VARCHAR(255),
    
    gerador_id BIGINT,
    FOREIGN KEY (gerador_id) REFERENCES geradores(id)
);
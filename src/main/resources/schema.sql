-- Apaga tabelas existentes para garantir um começo limpo (útil com create-drop)
DROP TABLE IF EXISTS residuos;
DROP TABLE IF EXISTS cooperativas;
DROP TABLE IF EXISTS geradores;

-- Criação da tabela de Geradores
CREATE TABLE geradores
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome     VARCHAR(255)       NOT NULL,
    cnpj_cpf VARCHAR(14) UNIQUE NOT NULL,
    endereco VARCHAR(255)
);

-- Criação da tabela de Cooperativas
CREATE TABLE cooperativas
(
    id                  BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome                VARCHAR(255) NOT NULL,
    tipo_residuo_aceito VARCHAR(255),
    localizacao         VARCHAR(255)
);

-- Criação da tabela de Resíduos (COM ENUMS COMO STRING)
CREATE TABLE residuos
(
    id             BIGINT PRIMARY KEY AUTO_INCREMENT,
    tipo_residuo   VARCHAR(255) NOT NULL,
    peso_ou_volume DOUBLE NOT NULL,
    unidade_medida VARCHAR(50)  NOT NULL, -- MUDOU: de INT para VARCHAR
    data_registro  DATETIME     NOT NULL,
    status_residuo VARCHAR(50)  NOT NULL, -- MUDOU: de INT para VARCHAR
    localizacao    VARCHAR(255),

    gerador_id     BIGINT,
    FOREIGN KEY (gerador_id) REFERENCES geradores (id)
);
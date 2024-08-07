CREATE TABLE pacientes (
                         id BIGSERIAL PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         email VARCHAR(100) NOT NULL UNIQUE,
                         telefone VARCHAR(20) DEFAULT 'N/A' NOT NULL,
                         cpf VARCHAR(11) NOT NULL UNIQUE,
                         logradouro VARCHAR(100) NOT NULL,
                         bairro VARCHAR(100) NOT NULL,
                         cep VARCHAR(9) NOT NULL,
                         complemento VARCHAR(100),
                         numero VARCHAR(20),
                         uf CHAR(2) NOT NULL,
                         cidade VARCHAR(100) NOT NULL,
                         ativo BOOLEAN DEFAULT TRUE
);

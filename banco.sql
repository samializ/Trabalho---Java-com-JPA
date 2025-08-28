-- Criar o banco de dados
CREATE DATABASE loja;
USE loja;

-- =========================
-- Tabela Produto (classe base)
-- =========================
CREATE TABLE Produto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DOUBLE NOT NULL,
    descricao VARCHAR(255)
);

-- =========================
-- Subclasse ProdutoFisico (JOINED)
-- =========================
CREATE TABLE ProdutoFisico (
    id BIGINT PRIMARY KEY,
    peso DOUBLE,
    prateleira DOUBLE,
    CONSTRAINT fk_prod_fisico FOREIGN KEY (id) REFERENCES Produto(id)
);

-- =========================
-- Subclasse ProdutoDigital (JOINED)
-- =========================
CREATE TABLE ProdutoDigital (
    id BIGINT PRIMARY KEY,
    urlDownload VARCHAR(255),
    CONSTRAINT fk_prod_digital FOREIGN KEY (id) REFERENCES Produto(id)
);

-- =========================
-- Categoria (Muitos para Muitos)
-- =========================
CREATE TABLE Categoria (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE produto_categoria (
    produto_id BIGINT NOT NULL,
    categoria_id BIGINT NOT NULL,
    PRIMARY KEY (produto_id, categoria_id),
    FOREIGN KEY (produto_id) REFERENCES Produto(id),
    FOREIGN KEY (categoria_id) REFERENCES Categoria(id)
);

-- =========================
-- Pedido (Um para Muitos)
-- =========================
CREATE TABLE Pedido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cliente VARCHAR(100) NOT NULL
);

CREATE TABLE pedido_produto (
    pedido_id BIGINT NOT NULL,
    produtos_id BIGINT NOT NULL,
    PRIMARY KEY (pedido_id, produtos_id),
    FOREIGN KEY (pedido_id) REFERENCES Pedido(id),
    FOREIGN KEY (produtos_id) REFERENCES Produto(id)
);

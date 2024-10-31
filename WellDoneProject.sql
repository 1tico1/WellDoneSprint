-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 31/10/2024 às 16:34
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Banco de dados: welldone
--

-- --------------------------------------------------------

--
-- Estrutura para tabela cliente
--

CREATE TABLE cliente (
  id_cliente bigint(20) NOT NULL,
  nome varchar(255) NOT NULL,
  endereco varchar(255) NOT NULL,
  nr_telefone bigint(20) DEFAULT NULL,
  email varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela cliente
--

INSERT INTO cliente (id_cliente, nome, endereco, nr_telefone, email) VALUES(1, 'Rodrigo Santos', 'BA - Avenida Girasóis, 987', 71987654321, 'rodrigosantos@outlook.com');
INSERT INTO cliente (id_cliente, nome, endereco, nr_telefone, email) VALUES(2, 'Amanda Silva', 'RJ - Rua da Paz, 123', 21987654321, 'amandasiva@gmail.com');
INSERT INTO cliente (id_cliente, nome, endereco, nr_telefone, email) VALUES(3, 'Carlos Souza', 'MG - Avenida Central, 456', 31965432198, 'carlossouza@hotmail.com');
INSERT INTO cliente (id_cliente, nome, endereco, nr_telefone, email) VALUES(4, 'Laura Oliveira', 'RS - Praça das Flores, 789', 51912345678, 'lauraoliveira@gmail.com');
INSERT INTO cliente (id_cliente, nome, endereco, nr_telefone, email) VALUES(5, 'Diego Santos', 'BA - Avenida Paulista, 987', 78765437771, 'diegosantos@gmail.com');

-- --------------------------------------------------------

--
-- Estrutura para tabela pagamento
--

CREATE TABLE pagamento (
  pagamento_id bigint(20) NOT NULL,
  pagamento_metodo varchar(255) NOT NULL,
  pagamento_vlr_total decimal(10,2) NOT NULL,
  pagamento_id_prod bigint(20) NOT NULL,
  pagamento_id_cliente bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela pagamento
--

INSERT INTO pagamento (pagamento_id, pagamento_metodo, pagamento_vlr_total, pagamento_id_prod, pagamento_id_cliente) VALUES(1, 'Cartão de Crédito', 4999.00, 3, 3);
INSERT INTO pagamento (pagamento_id, pagamento_metodo, pagamento_vlr_total, pagamento_id_prod, pagamento_id_cliente) VALUES(2, 'Boleto Bancário', 6999.00, 2, 1);
INSERT INTO pagamento (pagamento_id, pagamento_metodo, pagamento_vlr_total, pagamento_id_prod, pagamento_id_cliente) VALUES(3, 'Transferência Bancária', 8499.00, 4, 2);
INSERT INTO pagamento (pagamento_id, pagamento_metodo, pagamento_vlr_total, pagamento_id_prod, pagamento_id_cliente) VALUES(4, 'Cartão de Débito', 9499.00, 5, 5);
INSERT INTO pagamento (pagamento_id, pagamento_metodo, pagamento_vlr_total, pagamento_id_prod, pagamento_id_cliente) VALUES(5, 'Pix', 7999.00, 1, 4);

-- --------------------------------------------------------

--
-- Estrutura para tabela pedido
--

CREATE TABLE pedido (
  pedido_id bigint(20) NOT NULL,
  pedido_qtd int(11) NOT NULL,
  pedido_status varchar(255) NOT NULL,
  pedido_id_cliente bigint(20) NOT NULL,
  pedido_id_produto bigint(20) NOT NULL,
  pedido_cliente_id bigint(20) DEFAULT NULL,
  pedido_data date DEFAULT NULL,
  pedido_vlr_total decimal(38,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela pedido
--

INSERT INTO pedido (pedido_id, pedido_qtd, pedido_status, pedido_id_cliente, pedido_id_produto, pedido_cliente_id, pedido_data, pedido_vlr_total) VALUES(1, 2, 'Pendente', 1, 1, NULL, NULL, NULL);
INSERT INTO pedido (pedido_id, pedido_qtd, pedido_status, pedido_id_cliente, pedido_id_produto, pedido_cliente_id, pedido_data, pedido_vlr_total) VALUES(2, 1, 'Pedido Pago', 2, 2, NULL, NULL, NULL);
INSERT INTO pedido (pedido_id, pedido_qtd, pedido_status, pedido_id_cliente, pedido_id_produto, pedido_cliente_id, pedido_data, pedido_vlr_total) VALUES(3, 3, 'Pedido em separação', 3, 5, NULL, NULL, NULL);
INSERT INTO pedido (pedido_id, pedido_qtd, pedido_status, pedido_id_cliente, pedido_id_produto, pedido_cliente_id, pedido_data, pedido_vlr_total) VALUES(4, 1, 'Pedido Entregue', 4, 4, NULL, NULL, NULL);
INSERT INTO pedido (pedido_id, pedido_qtd, pedido_status, pedido_id_cliente, pedido_id_produto, pedido_cliente_id, pedido_data, pedido_vlr_total) VALUES(6, 3, 'Pendente', 1, 1, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura para tabela produto
--

CREATE TABLE produto (
  produto_id bigint(20) NOT NULL,
  produto_nome varchar(255) NOT NULL,
  produto_descricao text DEFAULT NULL,
  produto_preco decimal(10,2) NOT NULL,
  produto_qtd_estoque int(11) NOT NULL,
  produto_categoria varchar(255) NOT NULL,
  produto_marca varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela produto
--

INSERT INTO produto (produto_id, produto_nome, produto_descricao, produto_preco, produto_qtd_estoque, produto_categoria, produto_marca) VALUES(1, 'Apple iPhone 15 Pro Max 256GB', 'O iPhone 15 Pro Max 256GB é o celular perfeito para...', 7799.00, 55, 'Celular', '');
INSERT INTO produto (produto_id, produto_nome, produto_descricao, produto_preco, produto_qtd_estoque, produto_categoria, produto_marca) VALUES(2, 'Samsung Galaxy S22 Ultra 512GB', 'O Samsung Galaxy S22 Ultra 512GB é um smartphone potente...', 6999.00, 40, 'Celular', '');
INSERT INTO produto (produto_id, produto_nome, produto_descricao, produto_preco, produto_qtd_estoque, produto_categoria, produto_marca) VALUES(3, 'Sony PlayStation 5', 'A PlayStation 5 da Sony oferece uma experiência de...', 4999.00, 30, 'Console de Videogame', '');
INSERT INTO produto (produto_id, produto_nome, produto_descricao, produto_preco, produto_qtd_estoque, produto_categoria, produto_marca) VALUES(4, 'LG OLED TV 65\" 4K', 'A LG OLED TV 65\" 4K oferece uma experiência de...', 8499.00, 20, 'Televisor', '');
INSERT INTO produto (produto_id, produto_nome, produto_descricao, produto_preco, produto_qtd_estoque, produto_categoria, produto_marca) VALUES(5, 'Dell XPS 15 9500', 'O Dell XPS 15 9500 é um laptop premium com tela 4K...', 9499.00, 15, 'Notebook', '');

-- --------------------------------------------------------

--
-- Estrutura para tabela role
--

CREATE TABLE `role` (
  id bigint(20) NOT NULL,
  nome varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela role
--

INSERT INTO role (id, nome) VALUES(1, 'ROLE_ADMIN');
INSERT INTO role (id, nome) VALUES(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Estrutura para tabela usuario
--

CREATE TABLE usuario (
  id bigint(20) NOT NULL,
  username varchar(100) NOT NULL,
  password varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela usuario
--

INSERT INTO usuario (id, username, password) VALUES(1, 'admin', '$2a$12$2YT8FinSneWUGXAYzzxMvuanIdw5w4wR1kL3mgFTC8Xfk92mhEeaG');

-- --------------------------------------------------------

--
-- Estrutura para tabela usuario_roles
--

CREATE TABLE usuario_roles (
  usuario_id bigint(20) NOT NULL,
  role_id bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela usuario_roles
--

INSERT INTO usuario_roles (usuario_id, role_id) VALUES(1, 1);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela cliente
--
ALTER TABLE cliente
  ADD PRIMARY KEY (id_cliente);

--
-- Índices de tabela pagamento
--
ALTER TABLE pagamento
  ADD PRIMARY KEY (pagamento_id);

--
-- Índices de tabela pedido
--
ALTER TABLE pedido
  ADD PRIMARY KEY (pedido_id);

--
-- Índices de tabela produto
--
ALTER TABLE produto
  ADD PRIMARY KEY (produto_id);

--
-- Índices de tabela role
--
ALTER TABLE role
  ADD PRIMARY KEY (id),
  ADD UNIQUE KEY nome (nome);

--
-- Índices de tabela usuario
--
ALTER TABLE usuario
  ADD PRIMARY KEY (id),
  ADD UNIQUE KEY username (username);

--
-- Índices de tabela usuario_roles
--
ALTER TABLE usuario_roles
  ADD PRIMARY KEY (usuario_id,role_id),
  ADD KEY FK3t77lxrs76nthhni13ctc7dlj (role_id);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela cliente
--
ALTER TABLE cliente
  MODIFY id_cliente bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela pagamento
--
ALTER TABLE pagamento
  MODIFY pagamento_id bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela pedido
--
ALTER TABLE pedido
  MODIFY pedido_id bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela produto
--
ALTER TABLE produto
  MODIFY produto_id bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela role
--
ALTER TABLE role
  MODIFY id bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela usuario
--
ALTER TABLE usuario
  MODIFY id bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas usuario_roles
--
ALTER TABLE usuario_roles
  ADD CONSTRAINT FK3t77lxrs76nthhni13ctc7dlj FOREIGN KEY (role_id) REFERENCES role (id),
  ADD CONSTRAINT FKqblnumndby0ftm4c7sg6uso6p FOREIGN KEY (usuario_id) REFERENCES usuario (id);
COMMIT;

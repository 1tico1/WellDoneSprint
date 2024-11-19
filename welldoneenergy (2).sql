-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 10/11/2024 às 16:24
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `welldoneenergy`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `consumo`
--

CREATE TABLE `consumo` (
  `id` bigint(20) NOT NULL,
  `quantidade` double NOT NULL,
  `usuario_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `consumo`
--

INSERT INTO `consumo` (`id`, `quantidade`, `usuario_id`) VALUES
(1, 1234.56, 1),
(2, 987.65, 2),
(3, 543.21, 3),
(4, 1500.78, 4),
(5, 2100.9, 5);

-- --------------------------------------------------------

--
-- Estrutura para tabela `energia`
--

CREATE TABLE `energia` (
  `id` bigint(20) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `geracao` double NOT NULL,
  `usuario_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `energia`
--

INSERT INTO `energia` (`id`, `tipo`, `geracao`, `usuario_id`) VALUES
(1, 'Solar', 2500, 1),
(2, 'Eólica', 3200.5, 2),
(3, 'Hidrelétrica', 4500.75, 3),
(4, 'Biomassa', 1500.3, 4);

-- --------------------------------------------------------

--
-- Estrutura para tabela `relatorio`
--

CREATE TABLE `relatorio` (
  `id` bigint(20) NOT NULL,
  `periodo` varchar(255) NOT NULL,
  `energia_gerada` double NOT NULL,
  `energia_consumida` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `relatorio`
--

INSERT INTO `relatorio` (`id`, `periodo`, `energia_gerada`, `energia_consumida`) VALUES
(1, 'Janeiro 2024', 10000, 8500),
(2, 'Fevereiro 2024', 9800.5, 8200.75),
(3, 'Março 2024', 10500.3, 8700.6),
(4, 'Abril 2024', 10750.2, 8900.8);

-- --------------------------------------------------------

--
-- Estrutura para tabela `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `role`
--

INSERT INTO `role` (`id`, `nome`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `usuario`
--

INSERT INTO `usuario` (`id`, `username`, `password`) VALUES
(1, 'admin', '$2a$12$2YT8FinSneWUGXAYzzxMvuanIdw5w4wR1kL3mgFTC8Xfk92mhEeaG'),
(3, 'admin1', '$2a$10$C5qv2s1l/aPopGTcS0VYwOdmM1ccmEpsAc/X1QaofDYFUkDUlcruO');

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario_roles`
--

CREATE TABLE `usuario_roles` (
  `usuario_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `usuario_roles`
--

INSERT INTO `usuario_roles` (`usuario_id`, `role_id`) VALUES
(1, 1),
(3, 1);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `consumo`
--
ALTER TABLE `consumo`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `energia`
--
ALTER TABLE `energia`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `relatorio`
--
ALTER TABLE `relatorio`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nome` (`nome`);

--
-- Índices de tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Índices de tabela `usuario_roles`
--
ALTER TABLE `usuario_roles`
  ADD PRIMARY KEY (`usuario_id`,`role_id`),
  ADD KEY `FK3t77lxrs76nthhni13ctc7dlj` (`role_id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `consumo`
--
ALTER TABLE `consumo`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `energia`
--
ALTER TABLE `energia`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `relatorio`
--
ALTER TABLE `relatorio`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `usuario_roles`
--
ALTER TABLE `usuario_roles`
  ADD CONSTRAINT `FK3t77lxrs76nthhni13ctc7dlj` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `FKqblnumndby0ftm4c7sg6uso6p` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

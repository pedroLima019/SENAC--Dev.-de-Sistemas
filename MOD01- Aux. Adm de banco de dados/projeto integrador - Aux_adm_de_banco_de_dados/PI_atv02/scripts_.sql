CREATE TABLE `Dev_software` (
  `ID` int,
  `email` varchar(30),
  `nome` varchar(30),
  `cpf` int
);

CREATE TABLE `componentes` (
  `ID` int,
  `nome_componente` varchar(30)
);

CREATE TABLE `empresa / projeto` (
  `ID` int,
  `nome_empresa` varchar(30),
  `nome_projeto` varchar(30),
  `nome_responsavel` varchar(30)
);

CREATE TABLE `doc_texto/pag_html` (
  `ID` int,
  `nome_projeto` varchar(30),
  `nome_responsavel` varchar(30)
);

-- Tabela Dev_software
INSERT INTO `Dev_software` (`ID`, `email`, `nome`, `cpf`) VALUES
(1, 'joao@example.com', 'João', 123456789),
(2, 'maria@example.com', 'Maria', 987654321),
(3, 'pedro@example.com', 'Pedro', 456789123);

-- Tabela componentes
INSERT INTO `componentes` (`ID`, `nome_componente`) VALUES
(1, 'Componente A'),
(2, 'Componente B'),
(3, 'Componente C');

-- Tabela empresa/projeto
INSERT INTO `empresa/projeto` (`ID`, `nome_empresa`, `nome_projeto`, `nome_responsavel`) VALUES
(1, 'Empresa X', 'Projeto A', 'João'),
(2, 'Empresa Y', 'Projeto B', 'Maria'),
(3, 'Empresa Z', 'Projeto C', 'Pedro');

-- Tabela doc_texto/pag_html
INSERT INTO `doc_texto/pag_html` (`ID`, `nome_projeto`, `nome_responsavel`) VALUES
(1, 'Projeto A', 'João'),
(2, 'Projeto B', 'Maria'),
(3, 'Projeto C', 'Pedro');


CREATE TABLE `Dev_software` (
  `ID` int,
  `email` varchar(30),
  `nome` varchar(30),
  `cpf` int
);

CREATE TABLE `componentes` (
  `ID` int,
  `nome_componente` varchar(30)
);

CREATE TABLE `empresa_projeto` (
  `ID` int,
  `nome_empresa` varchar(30),
  `nome_projeto` varchar(30),
  `nome_responsavel` varchar(30)
);

CREATE TABLE `doc_texto_pag_html` (
  `ID` int,
  `nome_projeto` varchar(30),
  `nome_responsavel` varchar(30)
);

-- Tabela Dev_software
INSERT INTO `Dev_software` (`ID`, `email`, `nome`, `cpf`) VALUES
(1, 'joao@example.com', 'João', 123456789),
(2, 'maria@example.com', 'Maria', 987654321),
(3, 'pedro@example.com', 'Pedro', 456789123);

-- Tabela componentes
INSERT INTO `componentes` (`ID`, `nome_componente`) VALUES
(1, 'Componente A'),
(2, 'Componente B'),
(3, 'Componente C');

-- Tabela empresa_projeto
INSERT INTO `empresa_projeto` (`ID`, `nome_empresa`, `nome_projeto`, `nome_responsavel`) VALUES
(1, 'Empresa X', 'Projeto A', 'João'),
(2, 'Empresa Y', 'Projeto B', 'Maria'),
(3, 'Empresa Z', 'Projeto C', 'Pedro');

-- Tabela doc_texto_pag_html
INSERT INTO `doc_texto_pag_html` (`ID`, `nome_projeto`, `nome_responsavel`) VALUES
(1, 'Projeto A', 'João'),
(2, 'Projeto B', 'Maria'),
(3, 'Projeto C', 'Pedro');

CREATE VIEW `vw_dev_software` AS
SELECT * FROM `Dev_software`;

CREATE VIEW `vw_componentes` AS
SELECT * FROM `componentes`;

CREATE VIEW `vw_projetos` AS
SELECT
  ep.`ID`,
  ep.`nome_empresa`,
  ep.`nome_projeto`,
  ep.`nome_responsavel`,
  dtph.`ID` AS `doc_texto_pag_html_ID`,
  dtph.`nome_responsavel` AS `doc_texto_pag_html_responsavel`
FROM `empresa_projeto` ep
LEFT JOIN `doc_texto_pag_html` dtph ON ep.`nome_projeto` = dtph.`nome_projeto`;

CREATE TRIGGER `tr_atualiza_responsavel`
AFTER INSERT ON `empresa_projeto`
FOR EACH ROW
BEGIN
    DECLARE projeto_nome VARCHAR(30);
    DECLARE responsavel_nome VARCHAR(30);

    SET projeto_nome = NEW.nome_projeto;

    -- Lógica para obter o nome do responsável do projeto
    -- Pode ser substituída pela lógica adequada à sua aplicação
    -- Neste exemplo, estou considerando que o nome do responsável é derivado do nome do projeto
    SET responsavel_nome = CONCAT('Responsável de ', projeto_nome);

    UPDATE `empresa_projeto`
    SET nome_responsavel = responsavel_nome
    WHERE ID = NEW.ID;
END;

CREATE INDEX idx_empresa_projeto
ON empresa_projeto (nome_empresa, nome_projeto);




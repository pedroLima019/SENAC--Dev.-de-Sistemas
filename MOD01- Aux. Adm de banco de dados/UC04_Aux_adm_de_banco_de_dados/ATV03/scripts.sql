use uc4atividades;

/***
consulta para um relatório de todas as vendas pagas em dinheiro. 
Necessários para o relatório data da venda, valor total; produtos vendidos, quantidade e valor unitário; nome do cliente, cpf e telefone.
Ordena-se pela data de venda, as mais recentes primeiro.
**/
SELECT * FROM venda v, item_venda iv, produto p, cliente c, funcionario f
WHERE v.id = iv.venda_id AND c.id = v.cliente_id AND p.id = iv.produto_id AND f.id = v.funcionario_id and tipo_pagamento = 'D';

-- Execute o comando EXPLAIN mostrando detalhes da execução da consulta
EXPLAIN SELECT * FROM venda v, item_venda iv, produto p, cliente c, funcionario f
WHERE v.id = iv.venda_id AND c.id = v.cliente_id AND p.id = iv.produto_id AND f.id = v.funcionario_id and tipo_pagamento = 'D';

-- Realize ajustes de otimização nas consultas utilizando JOINs entre as tabelas assim como removendo os asteriscos ( * ) e definindo quais colunas devem ser retornadas de cada consulta afim de otimiza-la.
SELECT v.data_venda, v.valor_total, p.nome AS nome_produto, iv.quantidade, iv.valor_unitario, c.nome AS nome_cliente, c.cpf, c.telefone
FROM venda v
JOIN item_venda iv ON v.id = iv.venda_id
JOIN produto p ON p.id = iv.produto_id
JOIN cliente c ON c.id = v.cliente_id
JOIN funcionario f ON f.id = v.funcionario_id
WHERE v.tipo_pagamento = 'D'
ORDER BY v.data_venda DESC;

-- Crie índices que possam se beneficiar do recurso para melhorar o desempenho das consultas, considerando principalmente colunas utilizadas nas cláusulas Where.   
CREATE INDEX idx_venda_id ON venda (id);
CREATE INDEX idx_item_venda_venda_id ON item_venda (venda_id);
CREATE INDEX idx_produto_id ON produto (id);
CREATE INDEX idx_cliente_id ON cliente (id);
CREATE INDEX idx_venda_funcionario_id ON venda (funcionario_id);
CREATE INDEX idx_venda_tipo_pagamento ON venda (tipo_pagamento);

CREATE VIEW vendas_em_dinheiro AS
SELECT v.data_venda, v.valor_total, p.nome AS nome_produto, iv.quantidade, iv.valor_unitario, c.nome AS nome_cliente, c.cpf, c.telefone
FROM venda v
JOIN item_venda iv ON v.id = iv.venda_id
JOIN produto p ON p.id = iv.produto_id
JOIN cliente c ON c.id = v.cliente_id
JOIN funcionario f ON f.id = v.funcionario_id
WHERE v.tipo_pagamento = 'D'
ORDER BY v.data_venda DESC;


/***
consulta para encontrar todas as vendas de produtos de um dado fabricante
Mostrar dados do produto, quantidade vendida, data da venda.
Ordena-se pelo nome do produto.
***/
SELECT * 
FROM produto p, item_venda iv, venda v
WHERE p.id = iv.produto_id AND v.id = iv.venda_id AND p.fabricante like '%lar%';

-- Execute o comando EXPLAIN mostrando detalhes da execução da consulta
EXPLAIN SELECT * 
FROM produto p, item_venda iv, venda v
WHERE p.id = iv.produto_id AND v.id = iv.venda_id AND p.fabricante like '%lar%'
ORDER BY p.nome;

-- Realize ajustes de otimização nas consultas utilizando JOINs entre as tabelas assim como removendo os asteriscos ( * ) e definindo quais colunas devem ser retornadas de cada consulta afim de otimiza-la.
SELECT p.nome, p.quantidade, v.data_venda
FROM produto p
JOIN item_venda iv ON p.id = iv.produto_id
JOIN venda v ON v.id = iv.venda_id
WHERE p.fabricante LIKE '%lar%'
ORDER BY p.nome;nome ;

-- Aqui está o comando para criar o índice:
CREATE INDEX idx_produto_fabricante ON produto (fabricante);

-- Aqui está a consulta otimizada:
SELECT p.*
FROM produto p
JOIN item_venda iv ON p.id = iv.produto_id
JOIN venda v ON v.id = iv.venda_id
WHERE p.fabricante LIKE '%lar%';

CREATE VIEW vendas_por_fabricante AS
SELECT p.nome, iv.quantidade, v.data_venda
FROM produto p
JOIN item_venda iv ON p.id = iv.produto_id
JOIN venda v ON v.id = iv.venda_id
WHERE p.fabricante LIKE '%lar%'
ORDER BY p.nome;

/***
Relatório de vendas de produto por cliente.
Mostrar dados do cliente, dados do produto e valor e quantidade totais de venda ao cliente de cada produto.
*/

SELECT SUM(iv.subtotal), SUM(iv.quantidade)
FROM produto p, item_venda iv, venda v, cliente c
WHERE p.id = iv.produto_id AND v.id = iv.venda_id AND c.id = v.cliente_id /*f.id = v.funcionario_id*/
GROUP BY c.nome, p.nome ;

-- Execute o comando EXPLAIN mostrando detalhes da execução da consulta
EXPLAIN SELECT SUM(iv.subtotal), SUM(iv.quantidade)
FROM produto p, item_venda iv, venda v, cliente c
WHERE p.id = iv.produto_id AND v.id = iv.venda_id AND c.id = v.cliente_id
GROUP BY c.nome, p.nome;

-- Realize ajustes de otimização nas consultas utilizando JOINs entre as tabelas assim como removendo os asteriscos ( * ) e definindo quais colunas devem ser retornadas de cada consulta afim de otimiza-la.

SELECT c.nome AS nome_cliente, p.nome AS nome_produto, SUM(iv.subtotal) AS total_subtotal, SUM(iv.quantidade) AS total_quantidade
FROM produto p
JOIN item_venda iv ON p.id = iv.produto_id
JOIN venda v ON v.id = iv.venda_id
JOIN cliente c ON c.id = v.cliente_id
GROUP BY c.nome, p.nome;

CREATE INDEX idx_produto_id ON produto (id);
CREATE INDEX idx_item_venda_produto_id ON item_venda (produto_id);
CREATE INDEX idx_venda_id ON venda (id);
CREATE INDEX idx_cliente_id ON cliente (id);













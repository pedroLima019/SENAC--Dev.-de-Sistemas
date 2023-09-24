USE uc4atividades;

/*Crie um stored procedure que receba  id de cliente, data inicial e data final e que mostre a lista de compras realizadas pelo referido cliente entre as datas informadas (incluindo essas datas), mostrando nome do cliente, id da compra, total, nome e quantidade de cada produto comprado.*/

DELIMITER //

CREATE PROCEDURE procedure_atvd2(cliente_id INT, data_inicial DATETIME, data_final DATETIME)
BEGIN
SELECT c.nome, v.id, v.data, v.data_envio, v.valor_total, i.nome_produto, i.quantidade
	FROM cliente c
	JOIN venda v on c.id = v.cliente_id
	JOIN item_venda i on v.id = i.venda_id
	WHERE DATA BETWEEN data_inicial AND data_final AND cliente_id = c.id;
END //

DELIMITER ;

CALL procedure_atvd2 ('5', '2019-01-08', '2022-02-27');



USE uc4atividades;

DELIMITER //
CREATE FUNCTION determinarTipoCliente(cliente_id INT) RETURNS VARCHAR(10)
BEGIN
    DECLARE total_compras DECIMAL(9,2);
    DECLARE tipo_cliente VARCHAR(10);
    SET total_compras = (
        SELECT SUM(v.valor_total)
        FROM uc4atividades.venda v
        WHERE v.cliente_id = cliente_id
        AND v.data >= DATE_SUB(NOW(), INTERVAL 2 YEAR)
    );
    
    IF total_compras > 10000 THEN
        SET tipo_cliente = 'PREMIUM';
    ELSE
        SET tipo_cliente = 'REGULAR';
    END IF;
    
    RETURN tipo_cliente;
END //
DELIMITER ;

SELECT determinarTipoCliente(1);

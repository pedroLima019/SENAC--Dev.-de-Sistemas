USE uc4atividades;

/*Crie um trigger que atue sobre a tabela “usuário” de modo que, ao incluir um novo usuário, aplique automaticamente MD5() à coluna “senha”, utilize nesta atividade variáveis com New.*/

DELIMITER //

CREATE TRIGGER trigger_usuario BEFORE INSERT
ON usuario
FOR EACH ROW
BEGIN
SET NEW.senha=md5(NEW.senha);

END //

DELIMITER ;

INSERT INTO usuario
(login, senha, ultimo_login)
VALUES
('Carol_mota_teste2', '9672', '2023-06-02 18:10');

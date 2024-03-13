CREATE DATABASE gerenciamentoTarefas;
USE gerenciamentoTarefas;

CREATE TABLE Tarefas(
id INT PRIMARY KEY auto_increment, 
nome varchar(100),
dataCadastro date , 
prioridade varchar(100)
);

select * from Tarefas; 
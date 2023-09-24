USE hospital;
CREATE TABLE tipo_quarto(
id_tipo INT NOT NULL AUTO_INCREMENT,
descricao  VARCHAR(45),
valor_diaria REAL NOT NULL,
PRIMARY KEY (id_tipo)
);

CREATE TABLE quarto (
id_quarto INT NOT NULL AUTO_INCREMENT,
numero INT NOT NULL UNIQUE,
tipo_id INT NOT NULL,
PRIMARY KEY (id_quarto),
FOREIGN KEY (tipo_id) REFERENCES tipo_quarto(id_tipo)
 );
 
 INSERT INTO quartos (tipo_quarto, valor_diaria)
VALUES 
  ('Apartamento', 200.00),
  ('Quarto Duplo', 150.00),
  ('Enfermaria', 100.00);
 
 CREATE TABLE convenio(
 id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 nome_convenio VARCHAR(45) NOT NULL,
 cnpj INT NOT NULL UNIQUE,
 carencia DATE,
 carteira_convenio INT 
 );
 
INSERT INTO convenio (nome_convenio)
VALUES
  ('Unimed'),
  ('Amil'),
  ('SulAmérica'),
  ('Bradesco Saúde');

 
 CREATE TABLE paciente(
 id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 nome VARCHAR(45) NOT NULL,
 data_nascimento DATE NOT NULL,
 endereco VARCHAR(45),
 telefone INT,
 email VARCHAR(45),
 cpf INT NOT NULL UNIQUE,
 rg INT NOT NULL UNIQUE,
 id_convenio INT,
 FOREIGN KEY(id_convenio) REFERENCES convenio(id)
 );
 
 INSERT INTO paciente (nome_paciente, cpf, id_convenio)
VALUES
  ('Ana Paula', '12345678901', 1),
  ('Marcos Silva', '23456789012', 2),
  ('José Santos', '34567890123', NULL),
  ('Mariana Costa', '45678901234', 1),
  ('Fernanda Oliveira', '56789012345', 4),
  ('Pedro Castro', '67890123456', NULL),
  ('Lucas Rodrigues', '78901234567', 3),
  ('Camila Santos', '89012345678', NULL),
  ('João Silva', '90123456789', 1),
  ('Maria Souza', '01234567890', 2);
 
 CREATE TABLE medico(
 id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 nome VARCHAR(45) NOT NULL
 );
 
 INSERT INTO medico (nome_medico, crm, id_especialidade)
VALUES
  ('João Silva', '123456', 2),
  ('Maria Souza', '654321', 1),
  ('Pedro Castro', '789012', 3),
  ('Camila Santos', '345678', 4),
  ('Fernanda Oliveira', '901234', 1),
  ('Lucas Rodrigues', '567890', 2),
  ('Mariana Costa', '432109', 7),
  ('Luiz Fernandes', '098765', 6),
  ('Ana Paula Pereira', '321098', 1),
  ('Carlos Henrique Almeida', '567890', 2);
 
 CREATE TABLE especialidade(
 id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 especialidade VARCHAR(45)
 );
 
 INSERT INTO especialidade (nome_especialidade)
VALUES
  ('Pediatria'),
  ('Clínico geral'),
  ('Gastroenterologia'),
  ('Dermatologia'),
  ('Oftalmologia'),
  ('Ortopedia'),
  ('Neurologia');
 
CREATE TABLE medico_especialidade( 
id_medico INT NOT NULL,
id_especialidade INT NOT NULL,
FOREIGN KEY (id_medico) REFERENCES medico(id),
FOREIGN KEY (id_especialidade) REFERENCES especialidade(id)
);

CREATE TABLE consulta(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
valor DECIMAL NOT NULL,
data_consulta DATE NOT NULL,
paciente_id INT NOT NULL,
medico_id INT NOT NULL,
especialidade_id INT NOT NULL,
convenio_id INT NOT NULL,
FOREIGN KEY(paciente_id) REFERENCES paciente(id),
FOREIGN KEY(medico_id) REFERENCES medico(id),
FOREIGN KEY(especialidade_id) REFERENCES especialidade(id),
FOREIGN KEY(convenio_id) REFERENCES convenio(id)
);

INSERT INTO Consulta (data_consulta, hora_consulta, id_paciente, id_medico)
VALUES 
('2018-03-20', '14:00:00', 1, 2),
('2018-05-10', '09:30:00', 2, 1),
('2018-07-05', '16:15:00', 3, 3),
('2019-01-12', '10:00:00', 4, 4),
('2019-03-28', '11:45:00', 5, 5),
('2019-06-15', '13:30:00', 6, 6),
('2020-02-02', '15:00:00', 7, 7),
('2020-04-20', '10:30:00', 8, 8),
('2021-09-10', '08:45:00', 9, 9),
('2022-11-25', '14:15:00', 10, 10);

CREATE TABLE receita(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
medicamentos VARCHAR(45) NOT NULL,
consulta_id INT NOT NULL,
FOREIGN KEY(consulta_id) REFERENCES consulta(id)
);

INSERT INTO consulta (paciente_id, medico_id, data) VALUES (2, 6, '2020-02-15');
SET @consulta_id := LAST_INSERT_ID();
INSERT INTO receita (consulta_id, medicamento) VALUES (@consulta_id, 'Paracetamol');
INSERT INTO receita (consulta_id, medicamento) VALUES (@consulta_id, 'Dipirona');

INSERT INTO consulta (paciente_id, medico_id, data) VALUES (4, 3, '2018-05-23');
SET @consulta_id := LAST_INSERT_ID();
INSERT INTO receita (consulta_id, medicamento) VALUES (@consulta_id, 'Amoxicilina');
INSERT INTO receita (consulta_id, medicamento) VALUES (@consulta_id, 'Ibuprofeno');

INSERT INTO consulta (paciente_id, medico_id, data) VALUES (7, 9, '2019-12-10');
SET @consulta_id := LAST_INSERT_ID();
INSERT INTO receita (consulta_id, medicamento) VALUES (@consulta_id, 'Dipirona');
INSERT INTO receita (consulta_id, medicamento) VALUES (@consulta_id, 'Cefalexina');

INSERT INTO consulta (paciente_id, medico_id, data) VALUES (3, 8, '2021-08-06');
SET @consulta_id := LAST_INSERT_ID();
INSERT INTO receita (consulta_id, medicamento) VALUES (@consulta_id, 'Cloridrato de Tramadol');
INSERT INTO receita (consulta_id, medicamento) VALUES (@consulta_id, 'Metoclopramida');

INSERT INTO consulta (paciente_id, medico_id, data) VALUES (9, 9, '2017-09-20');
SET @consulta_id := LAST_INSERT_ID();
INSERT INTO receita (consulta_id, medicamento) VALUES (@consulta_id, 'Amoxicilina');
INSERT INTO receita (consulta_id, medicamento) VALUES (@consulta_id, 'Dipirona');



CREATE TABLE internacao(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
data_entrada DATE NOT NULL,
data_prevalta DATE,
data_alta DATE NOT NULL,
procedimento VARCHAR(45),
medico_id INT NOT NULL,
paciente_id INT NOT NULL,
quarto_id INT NOT NULL,
FOREIGN KEY(medico_id) REFERENCES medico(id),
FOREIGN KEY(paciente_id) REFERENCES paciente(id),
FOREIGN KEY(quarto_id) REFERENCES quarto(id_quarto)
);

INSERT INTO internacoes (id_paciente, id_medico, id_quarto, data_inicio, data_fim, valor_total)
VALUES 
  (1, 4, 1, '2021-06-15', '2021-06-25', 2000.00),
  (2, 5, 2, '2022-01-10', '2022-01-20', 1500.00),
  (3, 6, 3, '2019-03-22', '2019-03-28', 700.00),
  (4, 7, 1, '2020-05-01', '2020-05-10', 2000.00),
  (5, 8, 2, '2018-09-17', '2018-09-23', 1200.00),
  (6, 9, 3, '2022-03-08', '2022-03-15', 700.00),
  (7, 10, 1, '2021-08-10', '2021-08-15', 1000.00),
  (1, 5, 1, '2022-02-10', '2022-02-20', 2500.00),
  (2, 6, 2, '2020-07-01', '2020-07-15', 1800.00),
  (4, 8, 1, '2018-04-01', '2018-04-10', 2200.00);

CREATE TABLE enfermeiro(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(45) NOT NULL,
cpf INT NOT NULL UNIQUE,
cre INT NOT NULL UNIQUE
);

INSERT INTO enfermeiro(id, nome, telefone, email, endereco, internacao_id, internacao_quarto)
VALUES
(1, 'Enfermeiro 1', '(11) 1111-1111', 'enfermeiro1@teste.com', 'Rua A, 123', 1, '102'),
(2, 'Enfermeiro 2', '(22) 2222-2222', 'enfermeiro2@teste.com', 'Rua B, 456', 1, '102'),
(3, 'Enfermeiro 3', '(33) 3333-3333', 'enfermeiro3@teste.com', 'Rua C, 789', 2, '201'),
(4, 'Enfermeiro 4', '(44) 4444-4444', 'enfermeiro4@teste.com', 'Rua D, 321', 3, '302'),
(5, 'Enfermeiro 5', '(55) 5555-5555', 'enfermeiro5@teste.com', 'Rua E, 654', 3, '302'),
(6, 'Enfermeiro 6', '(66) 6666-6666', 'enfermeiro6@teste.com', 'Rua F, 987', 4, '101');

CREATE TABLE internacao_enfermeiro(
internacao_id INT NOT NULL,
enfermeiro_id INT NOT NULL,
FOREIGN KEY(internacao_id) REFERENCES internacao(id),
FOREIGN KEY(enfermeiro_id) REFERENCES enfermeiro(id)
);

CREATE TABLE tipos_quartos (
    id_tipo_quarto INT PRIMARY KEY AUTO_INCREMENT,
    nome_tipo_quarto VARCHAR(50) NOT NULL,
    descricao_tipo_quarto TEXT,
    preco_diaria DECIMAL(10,2) NOT NULL
);

INSERT INTO tipos_quartos (nome_tipo_quarto, descricao_tipo_quarto, preco_diaria) VALUES 
    ('Apartamento', 'Quarto individual com banheiro privativo', 350.00),
    ('Quarto Duplo', 'Quarto para duas pessoas com banheiro compartilhado', 250.00),
    ('Enfermaria', 'Quarto coletivo para mais de duas pessoas', 150.00);

ALTER TABLE medico ADD crm INT  NOT NULL UNIQUE;



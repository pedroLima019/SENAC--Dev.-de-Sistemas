use uc4atividades;

-- Criação da tabela Pessoas
CREATE TABLE Pessoas (
  ID INT,
  nome VARCHAR(255),
  cpf VARCHAR(11),
  endereco VARCHAR(255),
  PRIMARY KEY (ID)
);

-- Criação da tabela Telefones
CREATE TABLE Telefones (
  ID INT,
  telefone VARCHAR(255),
  FOREIGN KEY (ID) REFERENCES Pessoas(ID)
);


-- Criação da tabela Produto
CREATE TABLE Produto (
  produto_ID INT PRIMARY KEY,
  nome_produto VARCHAR(255)
);

-- Criação da tabela Item_venda
CREATE TABLE Item_venda (
  venda_id INT,
  produto_ID INT,
  quantidade INT,
  valor_unitario DECIMAL(9,2),
  subtotal DECIMAL(9,2),
  PRIMARY KEY (venda_id, produto_ID),
  FOREIGN KEY (produto_ID) REFERENCES Produto(produto_ID)
);

-- Criação da tabela Venda
CREATE TABLE Venda (
  id INT PRIMARY KEY,
  data DATETIME,
  status VARCHAR(45),
  valor_total DECIMAL(9,2),
  cliente_ID INT,
  funcionario_ID INT,
  tipo_pagamento CHAR(1),
  FOREIGN KEY (cliente_ID) REFERENCES Cliente(ID),
  FOREIGN KEY (funcionario_ID) REFERENCES Funcionario(ID)
);

-- Criação da tabela Pagamento
CREATE TABLE Pagamento (
  venda_id INT,
  tipo_pagamento CHAR(1),
  numero_cartao_pagamento VARCHAR(16),
  numero_parcelas_pagamentos INT,
  data_pagamento DATETIME,
  FOREIGN KEY (venda_id) REFERENCES Venda(id)
);






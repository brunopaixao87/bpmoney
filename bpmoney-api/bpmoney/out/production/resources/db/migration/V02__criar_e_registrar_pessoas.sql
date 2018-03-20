
CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	cpf VARCHAR(11) NOT NULL,
	logradouro VARCHAR(30),
	numero VARCHAR(30),
	complemento VARCHAR(30),
	bairro VARCHAR(30),
	cep VARCHAR(30),
	cidade VARCHAR(30),
	estado VARCHAR(30),
	ativo BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, cpf, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('João Silva', '23095751001', 'Rua do Abacaxi', '10', null, 'Brasil', '3840012', 'Uberlândia', 'MG', true);
INSERT INTO pessoa (nome, cpf, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Maria Rita', '73575297037', 'Rua do Sabiá', '110', 'Apto 101', 'Colina', '1140012', 'Ribeirão Preto', 'SP', true);
INSERT INTO pessoa (nome, cpf, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Pedro Santos', '64805713046', 'Rua da Bateria', '23', null, 'Morumbi', '5421212', 'Goiânia', 'GO', true);
INSERT INTO pessoa (nome, cpf, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Ricardo Pereira', '45062465001', 'Rua do Motorista', '123', 'Apto 302', 'Aparecida', '3840012', 'Salvador', 'BA', true);
INSERT INTO pessoa (nome, cpf, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Josué Mariano', '08212497038', 'Av Rio Branco', '321', null, 'Jardins', '56400-12', 'Natal', 'RN', true);
INSERT INTO pessoa (nome, cpf, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Pedro Barbosa', '40544525078', 'Av Brasil', '100', null, 'Tubalina', '7740012', 'Porto Alegre', 'RS', true);
INSERT INTO pessoa (nome, cpf, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Henrique Medeiros', '23490887077', 'Rua do Sapo', '1120', 'Apto 201', 'Centro', '1240012', 'Rio de Janeiro', 'RJ', true);
INSERT INTO pessoa (nome, cpf, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Carlos Santana', '26947593000', 'Rua da Manga', '433', null, 'Centro', '3140012', 'Belo Horizonte', 'MG', true);
INSERT INTO pessoa (nome, cpf, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Leonardo Oliveira', '51146267010', 'Rua do Músico', '566', null, 'Segismundo Pereira', '3840000', 'Uberlândia', 'MG', true);
INSERT INTO pessoa (nome, cpf, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Isabela Martins', '62159245046', 'Rua da Terra', '1233', 'Apto 10', 'Vigilato', '9940012', 'Manaus', 'AM', true);
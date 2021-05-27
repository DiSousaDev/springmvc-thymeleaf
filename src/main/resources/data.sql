INSERT INTO departamentos (nome) VALUES ('Recursos Humanos');
INSERT INTO departamentos (nome) VALUES ('Contabilidade');
INSERT INTO departamentos (nome) VALUES ('Administração');
INSERT INTO departamentos (nome) VALUES ('Tecnologia da Informação');

INSERT INTO cargos (nome, id_departamento_fk) VALUES ('Desenvolvedor Java Júnior', 4);
INSERT INTO cargos (nome, id_departamento_fk) VALUES ('Auxiliar Contábil', 2);
INSERT INTO cargos (nome, id_departamento_fk) VALUES ('Auxiliar Administrativo', 3);
INSERT INTO cargos (nome, id_departamento_fk) VALUES ('Contador', 2);
INSERT INTO cargos (nome, id_departamento_fk) VALUES ('Desenvolvedor Java Pleno', 4);
INSERT INTO cargos (nome, id_departamento_fk) VALUES ('Psicologo', 1);
INSERT INTO cargos (nome, id_departamento_fk) VALUES ('Auxiliar de RH', 1);

INSERT INTO enderecos (logradouro, numero, complemento, bairro, cidade, uf, cep) VALUES ('Rua das Oliveiras', 260, 'Fundos', 'Centro', 'Porto Alegre', 'RS', '97050-015');
INSERT INTO enderecos (logradouro, numero, complemento, bairro, cidade, uf, cep) VALUES ('Av. dos Palmares', 320, null, 'Ribeirão', 'Canoas', 'RS', '98050-908');
INSERT INTO enderecos (logradouro, numero, complemento, bairro, cidade, uf, cep) VALUES ('Rua Senador Cassiano do Nascimento', 135, 'Ap. 106', 'Noroeste', 'Porto Alegre', 'RS', '90798-099');
INSERT INTO enderecos (logradouro, numero, complemento, bairro, cidade, uf, cep) VALUES ('Av. Maracanã', 135, 'Ap. 108', 'Maracanã', 'Rio de Janeiro', 'RJ', '91050-980');
INSERT INTO enderecos (logradouro, numero, complemento, bairro, cidade, uf, cep) VALUES ('Rua Gomes Carneiro', 909, null, 'Centro', 'Porto Alegre', 'RS', '98080-999');
 
INSERT INTO funcionarios (nome, data_entrada, data_saida, salario, cargo_id_fk, endereco_id_fk) VALUES ('Jorge da Silva', '2014-10-01', null, 3500.99, 7, 1);
INSERT INTO funcionarios (nome, data_entrada, data_saida, salario, cargo_id_fk, endereco_id_fk) VALUES ('Ana Maria Lindoval', '2014-08-01', '2015-03-02', 3560.70, 3, 2);
INSERT INTO funcionarios (nome, data_entrada, data_saida, salario, cargo_id_fk, endereco_id_fk) VALUES ('Juan Perez', '2015-01-05', null, 4060.99, 4, 3);
INSERT INTO funcionarios (nome, data_entrada, data_saida, salario, cargo_id_fk, endereco_id_fk) VALUES ('Marcio Silva', '2013-10-18', '2015-09-06', 2890.99, 2, 4);
INSERT INTO funcionarios (nome, data_entrada, data_saida, salario, cargo_id_fk, endereco_id_fk) VALUES ('Joana Prado', '2015-05-01', null, 6804.00, 6, 5);


Alterar o usuario e senha do mySql no arquivo application.properties

# Criar o Schema "contas"no mySql executando o seguinte SQL

CREATE SCHEMA `contas` ;

# Apos subir a aplicaçao para criar as tabelas, inserir os seguintes registros ou executar o teste addStatus na classe StatusServiceTest

INSERT INTO 'contas'.'status' ('cod_status', 'descricao') VALUES ('', 'Ativa');

INSERT INTO 'contas'.'status' ('descricao') VALUES ('Bloqueada');

INSERT INTO 'contas'.'status' ('descricao') VALUES ('Cancelada');


# Foi utilizado o app Postman para testar os serviços disponibilizados
